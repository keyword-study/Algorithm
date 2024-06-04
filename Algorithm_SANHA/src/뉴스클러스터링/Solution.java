package 뉴스클러스터링;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = removeNumbersAndSpecialChars(str1.toUpperCase());
        str2 = removeNumbersAndSpecialChars(str2.toUpperCase());

        ArrayList<String> set1 = merge(str1);
        ArrayList<String> set2 = merge(str2);

        ArrayList<String> intersections = intersection(set1, set2);
        ArrayList<String> unions = union(set1, set2,intersections);

        if(isEmptySet(intersections,unions)){
            return 65536;
        }
        double size1 =  intersections.size();
        double size2 = unions.size();
        double v = size1 / size2 * 65536;
        return (int)v;
    }
    private String removeNumbersAndSpecialChars(String str){
        str = str.replaceAll("[^a-zA-Z\\s]", "*");
        str = str.replaceAll(" ", "*");
        return str;
    }

    private ArrayList<String> merge(String str){
        ArrayList<String> arrayList = new ArrayList<>();
        String[] split = str.split("");
        for(int i=0; i<split.length; i++){
            if(i+1 == split.length){break;}
            String substring = split[i]+split[i+1];
            if(!substring.contains("*")){
                arrayList.add(substring);
            }
        }
        return arrayList;
    }
    private ArrayList<String> intersection(ArrayList<String>ary1 , ArrayList<String> ary2){
        ArrayList<String> intersections = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>();
        Set<String> set1 = new HashSet<>(ary1);
        for(String str1 : set1){
            int frequency = Collections.frequency(ary2, str1);
            map.put(str1,frequency);
        }

        Set<String> set2 = new HashSet<>(ary2);
        for(String str2 : set2){
            Integer frequency = Collections.frequency(ary1, str2);
            if(map.get(str2) != null){
                if(map.get(str2) > frequency){
                    map.put(str2,frequency);
                }
            }
        }
        for(String str : map.keySet()){
            for(int i=0; i<map.get(str); i++){
                intersections.add(str);
            }
        }
        return intersections;
    }
    private ArrayList<String> union(ArrayList<String>ary1 ,ArrayList<String> ary2,ArrayList<String> intersections){
        //AA AAA
        ArrayList<String> newAry1 = new ArrayList<>(ary1);
        ArrayList<String> newAry2 = new ArrayList<>(ary2);

        ArrayList<String> unions = new ArrayList<>();
        for(String str1 : ary1){
            newAry2.remove(str1);
        }
        for(String str2 : ary2){
            newAry1.remove(str2);
        }
        unions.addAll(newAry1);
        unions.addAll(newAry2);
        unions.addAll(intersections);

        return unions;
    }
    private boolean isEmptySet(ArrayList<String>intersections , ArrayList<String>unions){
        if(intersections.size() == unions.size()){
            for(String str : intersections){
                if(!unions.contains(str)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}