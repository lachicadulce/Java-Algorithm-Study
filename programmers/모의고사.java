import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> cnt = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        cnt.add(0);
        cnt.add(0);
        cnt.add(0);
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == num1[i % num1.length]) cnt.set(0, cnt.get(0) + 1);
            if(answers[i] == num2[i % num2.length]) cnt.set(1, cnt.get(1) + 1);
            if(answers[i] == num3[i % num3.length]) cnt.set(2, cnt.get(2) + 1);
        }
        
        int max = Collections.max(cnt);
        for(int i = 0; i < 3; i++){
            if(cnt.get(i) == max)
                answer.add(i + 1);
        }
        
        int[] result = new int[answer.size()];
        
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}