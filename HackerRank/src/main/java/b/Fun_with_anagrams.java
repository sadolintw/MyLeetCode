//import java.util.*;
//
//class Result {
//
//    /*
//     * Complete the 'funWithAnagrams' function below.
//     *
//     * The function is expected to return a STRING_ARRAY.
//     * The function accepts STRING_ARRAY text as parameter.
//     */
//
//    public static List<String> funWithAnagrams(List<String> text) {
//        // Write your code here
//
//        List<String> res = new ArrayList<String>();
//
//        if(text.size() <= 1 ){
//            return text;
//        }
//
//        //Collections.sort(text);
//
//        Set<String> store = new HashSet<String>();
//
//        for(int i = 0 ; i < text.size() ; i++ ){
//            String str = text.get(i);
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String str2 = new String(chars);
//            if(!store.contains(str2)){
//                store.add(str2);
//                res.add(str);
//            }
//        }
//        Collections.sort(res);
//
//        return res;
//    }
//
//}
//
//public class Fun_with_anagrams {
//    public static void main(String[] args) {
//        int n = 4;
//        List<String> input = Arrays.asList(new String[]{"code","aaagmnrs","anagrams","doce"});
//        Result.funWithAnagrams(input);
//    }
//}
