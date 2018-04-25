import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ExpiringKey<K> implements Delayed {

    private long lifeTime;
    private long startTime = System.currentTimeMillis();

    private final K key;

    public ExpiringKey(K key, long lifeTime){
        this.key = key;
        this.lifeTime = lifeTime;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(getDelayTime(), TimeUnit.MILLISECONDS);
    }

    public long getDelayTime(){
        return (startTime + lifeTime ) - System.currentTimeMillis();
    }


    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.getDelayTime(), ((ExpiringKey<K>) other).getDelayTime());
    }

    public K getKey() {
        return key;
    }

    public void renew(){
        this.startTime = System.currentTimeMillis();
    }

    public void expire(){
        this.startTime = System.currentTimeMillis() - lifeTime - 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        } else if(getClass() != obj.getClass()){
            return false;
        }

        final ExpiringKey<K> other = (ExpiringKey<K>) obj;
        if(this.key != other.key && (this.key == null || this.key.equals(other.key))){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.key != null ? this.key.hashCode() : 0);
        return hash;
    }
}
