package sanha.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingPay {

    public static void main(String[] args) {
        ParkingPay parkingPay = new ParkingPay();
        System.out.println();
        //parkingPay.solution();

        int calculator = calculator(180, 5000, 10, 600, "05:34", "23:00");
        System.out.println("calculator = " + calculator);
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int standardTime = fees[2];
        int standardFee = fees[3];

        for(String string : records){
            String[] split = string.split(" ");
            String time = split[0];
            String carNum = split[1];
            String direction = split[2];

            /**
             * calculator에 값을 넣고 결과값 출력만 하면 끝
             */




        }


        return answer;
    }

    public static int calculator(int defaultTime, int defaultFee, int standardTime, int standardFee, String start, String end){
        int result =0;

        int startHour = StringToInt(start.split(":")[0]);
        int startMin = StringToInt(end.split(":")[1]);

        int endHour = StringToInt(start.split(":")[0]);
        int endMin = StringToInt(end.split(":")[1]);

        int durationHour = endHour - startHour;
        int durationMin = Math.abs(endMin - startMin);

        int duration = durationHour * 60 + durationMin;

        if(duration < defaultTime){
            return defaultFee;
        }else{
            int temp = duration - defaultTime;
            return (int) (defaultFee + Math.ceil((temp / standardTime) * standardFee));
        }
    }

    public static int StringToInt(String time){
        if(time.charAt(0) == '0'){
            return Integer.parseInt(time.substring(1));
        }
        return Integer.parseInt(time);
    }





}
