//package seungheyon.programmers;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class NewsClusteringJava {
////    public static void main(String[] args) {
////        String str1 = "aaabbcccccccc";
////        String str2 = "aaaabbcccc";
////        int result = solution(str1, str2);
////        System.out.println(result); // Example usage
////    }
//
//    public static int solution(String str1, String str2) {
//        str1 = str1.toUpperCase();
//        str2 = str2.toUpperCase();
//
//        List<String> str1Set = new ArrayList<>();
//        List<String> str2Set = new ArrayList<>();
//
//        for (int i = 0; i < str1.length() - 1; i++) {
//            String str = str1.substring(i, i + 2);
//            if (str.matches("[a-zA-Z]+")) {
//                str1Set.add(str);
//            }
//        }
//
//        for (int i = 0; i < str2.length() - 1; i++) {
//            String str = str2.substring(i, i + 2);
//            if (str.matches("[a-zA-Z]+")) {
//                str2Set.add(str);
//            }
//        }
//
//        if(str1Set.size()==0&&str2Set.size()==0){
//            return 65536;
//        }
//
//        List<String> unionSet = new ArrayList<>(str2Set);
//        unionSet.addAll(str1Set);
//
//
//        int sum = unionSet.size();
//
//        Map<String,Integer> intersectionMap = new HashMap<>();
//
//        double ja = (double) sub / (sum-sub);
//        int intJa = (int) (ja * 65536);
//
//        return intJa;
//    }
//}
