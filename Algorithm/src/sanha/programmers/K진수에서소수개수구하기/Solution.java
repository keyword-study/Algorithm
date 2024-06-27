package sanha.programmers.K진수에서소수개수구하기;

public class Solution {
    public int solution(int n, int k) {
        String kJinsu = kJimsu(n, k);
        return countSosu(kJinsu);
    }

    private static int countSosu(String data){
        System.out.println("data = " + data);
        int answer =0;
        String[] split = data.split("0");
        for(int i=0; i<split.length; i++){
            if(split[i].equals("")){
                continue;
            }
            if(isSosu(Long.parseLong(split[i]))){
                answer++;
            };
        }
        return answer;
    }


    private static String kJimsu(int n, int k) {
        int num = n;
        StringBuilder result = new StringBuilder();
        while (num >0) {
            int na = num / k;
            result.insert(0,num % k);
            num = na;
        }
        return result.toString();
    }
    private static boolean isSosu(Long n){
        if(n == 1){
            return false;
        }
        for(int i=1; i<=n; i++){
            if(n%i==0){
                if(!(i == 1 || i == n)){
                    return false;
                }
            }
        }
        return true;
    }
}
