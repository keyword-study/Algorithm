package sanha.programmers.압축;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        String msg1 ="KAKAO";
        String msg2= "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";
        //int[] solution = solution(msg1);
        int[] solution1 = solution(msg2);
        //int[] solution2 = solution(msg3);
    }
    public static int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<String, Integer> dictionary = getDictionary();

        String[] split = msg.split("");
        for(int i = 0; i < split.length; i++) {
            String word = split[i];
                for(int j = i; j < split.length; j++) {
                    System.out.println("i == " + i + "  j = " + j);
                    System.out.println("j == " + j + "  word = " + word);
                    //값이 있으면 출력하고 다음꺼도 있는지 확인하여 등록
                    if(dictionary.containsKey(word)) {
                        int out = dictionary.get(word);
                            System.out.printf("@@@@@@@@@@@출력  %s 숫자 %d ",word,out);
                            System.out.println();
                            result.add(out);

                        if(i == j) continue;
                        word += split[j];
                    }else{
                        System.out.printf("등록  %s 숫자 %d ",word,dictionary.size()+1);
                        System.out.println();
                        dictionary.put(word, dictionary.size()+1);
                        break;
                    }
                }

            System.out.println("--------------------------------");
        }

        int[] resultArray = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resultArray[k] = result.get(k);
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
