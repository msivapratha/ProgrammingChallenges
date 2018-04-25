import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ExpiringHashMap<K,V> implements ExpiringMap<K,V>{
    

    Map<K,V> internalMap;

    private final DelayQueue<ExpiringKey<K>> delayedQueue = new DelayQueue<>();

    private final WeakHashMap<K,ExpiringKey<K>> weakMap ;

    private final long maxLifeTime;

    public ExpiringHashMap(){
        internalMap = new HashMap<K,V>();
        maxLifeTime = Long.MAX_VALUE;
        weakMap = new WeakHashMap<K,ExpiringKey<K>>();
    }

    public ExpiringHashMap(long maxLifeTime){
        internalMap = new HashMap<K,V>();
        this.maxLifeTime = maxLifeTime;
        weakMap = new WeakHashMap<K,ExpiringKey<K>>();
    }

    @Override
    public boolean renewKey(K key) {
        ExpiringKey<K> expKey =  weakMap.get(key);
        if(expKey!=null){
            expKey.renew();
            return true;
        }

        return false;
    }

    @Override
    public V put(K key, V value) {
        return put(key, value, maxLifeTime);
    }

    @Override
    public V put(K key, V value, long lifeTime) {
        ExpiringKey<K> expKey = new ExpiringKey<>(key,lifeTime);
        ExpiringKey delayedKey = new ExpiringKey(key, lifeTime);
        ExpiringKey oldKey = weakMap.put((K) key, delayedKey);
        if(oldKey != null) {
            expireKey(oldKey);
            weakMap.put((K) key, delayedKey);
        }

        delayedQueue.offer(expKey);
        weakMap.put(key,expKey);
        return internalMap.put(key, value);
    }

    private void cleanup(){
        ExpiringKey<K> expKey =  delayedQueue.poll();
        while(expKey!=null){
            internalMap.remove(expKey.getKey());
            weakMap.remove(expKey.getKey());
            expKey =  delayedQueue.poll();
        }
    }

    private void expireKey(ExpiringKey<K> delayedKey) {
        if (delayedKey != null) {
            delayedKey.expire();
            cleanup();
        }
    }

    @Override
    public int size() {
        cleanup();
        return 0;
    }

    @Override
    public boolean isEmpty() {
        cleanup();
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        cleanup();
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        cleanup();
        return false;
    }

    @Override
    public V get(Object key) {
        cleanup();
        return internalMap.get(key);
    }



    @Override
    public V remove(Object key) {
        V removedValue = internalMap.remove((K) key);
        expireKey(weakMap.remove((K) key));
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        internalMap.clear();
        delayedQueue.clear();
        weakMap.clear();
    }

    @Override
    public Set<K> keySet() {
        cleanup();
        return null;
    }

    @Override
    public Collection<V> values() {
        cleanup();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        cleanup();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        cleanup();
        return false;
    }

    @Override
    public int hashCode() {
        cleanup();
        return 0;
    }
}
