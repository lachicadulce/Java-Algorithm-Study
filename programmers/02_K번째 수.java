import java.util.*;
class Solution {
      public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i : array) {
            nums.add(i);
        }

        for(int i = 0; i < commands.length; i++){
            ArrayList<Integer> subnums = new ArrayList<>();
            subnums.addAll(nums.subList(commands[i][0]-1, commands[i][1]));
            Collections.sort(subnums);

            answer[i] = subnums.get(commands[i][2]-1);
        }
        return answer;
    }
}