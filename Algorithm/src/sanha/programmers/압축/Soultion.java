package sanha.programmers.압축;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        String msg1 ="KAKAO";
        String msg2= "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";
        int[] solution = solution(msg1);
        //int[] solution1 = solution(msg2);
        //int[] solution2 = solution(msg3);

    }
    public static int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dictionary = getDictionary();

        String[] split = msg.split("");
        for(int i=0; i<split.length; i++) {
            String word = split[i];
            for(int j=i; j<split.length; j++) {
                if(i != j){
                    word +=split[j];
                    if(dictionary.containsKey(word)) {
                        System.out.println("출력 word = " + word);
                        result.add(dictionary.get(word));
                    }else{
                        dictionary.put(word, dictionary.size()+1);
                        System.out.println("등록 word = " + word);
                    }
                    //System.out.println("word = " + word);
                }
            }
        }

        for (String word : split) {
            if (dictionary.containsKey(word)) {
                result.add(dictionary.get(word));
            }
        }

        Set<Integer> setWithoutDuplicates = new HashSet<>(result);
        List<Integer> deleteDuplicateList = new ArrayList<>(setWithoutDuplicates);

        int[] resultArray = new int[deleteDuplicateList.size()];
        for (int k = 0; k < deleteDuplicateList.size(); k++) {
            resultArray[k] = deleteDuplicateList.get(k);
        }
        return resultArray;
    }

    public static Map<String,Integer> getDictionary (){
        int index =1;
        Map<String,Integer> dictionary = new HashMap<>();
        for(char i='A'; i<='Z'; i++){
            dictionary.put(i + "",index);
            index++;
        }
        return dictionary;
    }
}
