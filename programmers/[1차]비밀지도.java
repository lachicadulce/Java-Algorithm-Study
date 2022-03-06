import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] arr1s = new String[n];
        String[] arr2s = new String[n];
        
        for(int i = 0; i < n; i++){
            answer[i] = "";
            // 이진법으로 바꾸기
            arr1s[i] = Integer.toBinaryString(arr1[i]);
            arr2s[i] = Integer.toBinaryString(arr2[i]);
            // 0 채워주기
            while(arr1s[i].length() < n){
                arr1s[i] = "0" + arr1s[i];
            }
            while(arr2s[i].length() < n){
                arr2s[i] = "0" + arr2s[i];
            }
            // 합쳐주기
            for(int j = 0; j < n; j++){
                if(arr1s[i].charAt(j) == '1' || arr2s[i].charAt(j) == '1'){
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
}