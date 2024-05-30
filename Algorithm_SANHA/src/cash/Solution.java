package cash;

import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int hit = 1;
        int miss = 5;
        ArrayList<String> memory = new ArrayList<>(cacheSize);
        int answer = 0;
        for(String s : cities){
            s =s.toLowerCase();
            if(memory.contains(s)){
                memory.remove(s);
                memory.add(s);
                answer +=hit;
            }else{
                answer+=miss;
                if(cacheSize !=0){
                    if(memory.size() == cacheSize){
                        memory.remove(0);
                    }
                    memory.add(s);
                }
            }
        }
        return answer;
    }
}