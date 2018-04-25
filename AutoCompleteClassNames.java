import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class returns list of classes to match the classAbr as Auto Complete.
 * It will match the class Abr based on case. case sensitive auto complete.
 * and the Abr should be in order.
 */
public class AutoCompleteClassNames {

    //List of ClassNames
    static String[] classNames = {
            "DataViewController",
            "TssClientEagerLoadTask",
            "CitGemfireCacheManager",
            "CitConcurrentMap",
            "DataManager",
            "TestDataManager",
            "ICacheManager"};

    public static void main(String args[]){
        autoComplete(classNames,"Data");
        autoComplete(classNames,"TsCliELT");
        autoComplete(classNames,"CitMap");
    }

    /**
     * This method will take the classNames Array and class Abrviation
     * and return list of the classes which is matching.
     * @param classNamesArr
     * @param classAbr
     * @return
     */
    public static String[] autoComplete(String[] classNamesArr, String classAbr ){
        List<String> className = new ArrayList<>();


        Arrays.stream(classNamesArr).forEach(classObj -> {
            // check if it starts with a string
            if(classObj.startsWith(classAbr)){
                className.add(classObj);
            }else{
                if(isClassMatching(classObj,classAbr)){
                    className.add(classObj);
                }
            }


        });

        System.out.println("Abr ["+classAbr+"] ClassName ["+className);
        Object[] objArr = className.toArray();
        return Arrays.copyOf(objArr, objArr.length, String[].class);
    }

    /**
     * This method will compatre the className and ClassAbr and return true if its matching
     * @param className
     * @param classAbr
     * @return
     */
    public static boolean isClassMatching(String className , String classAbr){
        List<String> abrLst = convertStringByCase(classAbr);
        List<String> classNameLst = convertStringByCase(className);
        boolean isMatching = false;
        if(classNameLst.size() == abrLst.size()){
            for(int i = 0 ; i < abrLst.size(); i++){
                if(classNameLst.get(i).startsWith(abrLst.get(i))){
                    isMatching = true;
                }else{
                    isMatching = false;
                    break;
                }
            }
        }
        return isMatching;
    }

    /**
     * Convert String into StringArr based using the UpperCase as delimeter
     * @param data
     * @return
     */
    public static List<String> convertStringByCase(String data){
        List<String> convertedByCaseLst  = new ArrayList<String>();

        char[] dataArr = data.toCharArray();
        //System.out.println(dataArr);
        String partitioned = "";
        for(char c : dataArr){
            if(Character.isUpperCase(c)){
                if(!"".equals(partitioned)){
                    convertedByCaseLst.add(partitioned);
                    partitioned = Character.toString(c);
                } else {
                    partitioned += c;
                }
            } else {
                partitioned += c;
            }

        }
        convertedByCaseLst.add(partitioned);
        return convertedByCaseLst;
    }
}
