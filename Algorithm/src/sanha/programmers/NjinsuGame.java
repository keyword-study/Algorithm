package sanha.programmers;

import sanha.programmers.K진수에서소수개수구하기.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class NjinsuGame {
    public static void main(String[] args) {
        NjinsuGame n = new NjinsuGame();
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        //System.out.println("solution = " + n.solution(16, 1000, 1000, 99));
       // System.out.println("solution = " + n.solution_1(16, 16, 2, 2));
        System.out.println("solution = " + n.solution_1(2, 4, 2, 1));
       // System.out.println("solution = " + n.solution(16, 1000, 100, 100));
        //System.out.println(nJinsu(8, 26091).equals("62753"));
        //System.out.println(nJinsu(16, 26091).equals("65EB"));
        //System.out.println(nJinsu(2, 26091).equals("110010111101011"));
        //System.out.println("solution = " + n.solution(16, 16, 2, 1));
       // String tmp = Integer.toString(15, 16).toUpperCase();
       // System.out.println("tmp = " + tmp);
    }
    public String solution(int n, int t, int m, int p) {
        ArrayList<String> integers = makeUseNumbers(n, t, m);
         return process(integers,t, m, p);
    }

    public static String process(ArrayList<String> arrayList,int t,int m,int p){
        String result = "";
        int cnt =0;
        for(int i=0; i < arrayList.size(); i++){
            cnt++;
            if(cnt == p){
                result += arrayList.get(i);
            }
            if(cnt == m){
                cnt = 0;
            }
        }
        return result.substring(0,t);
    }

    public static ArrayList<String> makeUseNumbers (int n, int t, int m){
        int i = 0;
        ArrayList<String> result = new ArrayList<>();
        while(result.size() > t*m){
            String[] split = Integer.toString(i,n).toUpperCase().split("");
            result.addAll(Arrays.asList(split));
            i++;
        }
        return result;
    }

    public String solution_1(int n,int t, int m,int p){
        String result = "";
        int cnt =0;
        for(int i=0; i< t*m; i++){
            String[] split = Integer.toString(i,n).toUpperCase().split("");
            for(int j=0; j<split.length; j++) {
                cnt ++;
                if(cnt == p){
                    result +=split[j];
                }
                if(cnt == m){
                    cnt = 0;
                }
            }
        }
        return result.substring(0,t);
    }
}
