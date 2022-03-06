import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> asw = new ArrayList<>();
        int len = progresses.length;
        int checkpoint = 0;
        while(checkpoint < len){
            System.out.println("checkpoint: " + checkpoint);
            int count = 0;
            // pass a day
            for(int i = checkpoint; i < len; i++){
                progresses[i] = progresses[i] + speeds[i];
                System.out.print(progresses[i] + " ,");
            }
            System.out.println();
            for(int j = checkpoint; j < len; j++){
                if(progresses[j] >= 100){
                    count++;
                    checkpoint = j + 1;
                } else
                    break;
            }
            if(count > 0){
                asw.add(count);
                System.out.println("count: " + count);
            }
        }
        int[] answer = new int[asw.size()];
        for(int i = 0; i < asw.size(); i++){
            answer[i] = asw.get(i);
        }
        return answer;
    }
}