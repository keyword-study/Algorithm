package seungheyon.programmers;

import java.util.ArrayList;
import java.util.List;

public class NewsClusteringJava {
    public static void main(String[] args) {
        String str1 = "aaabbcccccccc";
        String str2 = "aaaabbcccc";
        int result = solution(str1, str2);
        System.out.println(result); // Example usage
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> str1Set = new ArrayList<>();
        List<String> str2Set = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);
            if (str.matches("[a-zA-Z]+")) {
                str1Set.add(str);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);
            if (str.matches("[a-zA-Z]+")) {
                str2Set.add(str);
            }
        }

        if(str1Set.size()==0&&str2Set.size()==0){
            return 65536;
        }

        List<String> unionSet = new ArrayList<>(str2Set);
        unionSet.addAll(str1Set);


        int sum = unionSet.size();


        int sub = 0;
        for(String string1 : str1Set){
            for(String string2 : str2Set){
                if(string1.equals(string2)){
                    sub ++;
                    str1Set.remove(string1);
                    str2Set.remove(string2);
                }
            }
        }

//        str2Set.retainAll(str1Set);
//        str1Set.retainAll(str2Set);
//        int sub = Math.min(str1Set.size(), str2Set.size());

        double ja = (double) sub / (sum-sub);
        int intJa = (int) (ja * 65536);

        return intJa;
    }
}
