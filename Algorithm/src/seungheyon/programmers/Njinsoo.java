package seungheyon.programmers;

class Njinsoo {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        Long order = 0L;

        int num = 0;
        while(true){
            num++;
            String numStr = convertN(num, n);
            for(int i=0;i<numStr.length();i++){
                order++;
                if((order-p)%m==0){
                    answer += numStr.substring(i,i+1);
                }
                if(answer.length()==t){
                    return answer;
                }
            }
        }
    }

    private String convertN(int n, int k){

        if (n == 0) {
            return "0";
        }

        int num = n;
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int remain = num % k;
            if (remain > 9) {
                sb.insert(0, (char)remain + 55);
            } else {
                sb.insert(0, remain);
            }
            num /= k;
        }

        return sb.toString();
    }
}