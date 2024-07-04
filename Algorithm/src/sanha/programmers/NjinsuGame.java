package sanha.programmers;

import sanha.programmers.K진수에서소수개수구하기.Solution;

import java.util.ArrayList;

public class NjinsuGame {
    public static void main(String[] args) {
        NjinsuGame n = new NjinsuGame();
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        //System.out.println("solution = " + n.solution(2, 4, 2, 1));
        //System.out.println("solution = " + n.solution(16, 16, 2, 1));
        //System.out.println("solution = " + n.solution(16, 16, 2, 2));
    }
    public String solution(int n, int t, int m, int p) {
        ArrayList<String> integers = makeUseNumbers(n, t, m);
         return process(integers,t, m, p);
    }

    public static String process(ArrayList<String> arrayList, int t,int m,int p){
        String result = "";
        int cnt =0;
        for(int i=0; i < t*m; i++){
            cnt++;
            if(cnt == p){
                result += arrayList.get(i);
            }
            if(cnt == m){
                cnt = 0;
            }
        }
        return result;
    }

    public static ArrayList<String> makeUseNumbers (int n, int t, int m){
        ArrayList<String> result = new ArrayList<>();
        int cnt = 0;
        while(!(result.size() > t * m)){
            String[] split = nJinsu(n, cnt).split("");
            for(String s : split){
                result.add(s);
            }
            cnt++;
        }
        return result;
    }

    public static String nJinsu(int nJinsu, int number){
        StringBuilder result = new StringBuilder();
        while(number / nJinsu != 0){
            int jinsu = number % nJinsu;
            if(jinsu > 9 && nJinsu == 16){
                result.append(makeABCDEF(jinsu));
            }else{
                System.out.println("jinsu = " + jinsu);
                result.append(jinsu);
            }
            number = number / nJinsu;
        }
        if(nJinsu == 16 && number > 9){
            result.append(makeABCDEF(number));
        }else{
            result.append(number);
        }
        return result.reverse().toString();
    }

    public static String makeABCDEF(int num){
        return switch (num) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> null;
        };
    }
    public static boolean isABCDEF(String s){
         if(s.equals("A") || s.equals("B") || s.equals("C") || s.equals("D") || s.equals("E")|| s.equals("F")){
            return true;
        }
         return false;
    }
}
