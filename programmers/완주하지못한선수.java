import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> parts = new HashMap<>();
        // 참가자 수에 맞춰서 인원수 올려주기
        for(String name : participant) {
            parts.put(name, parts.containsKey(name) ? parts.get(name) + 1 : 1); 
        }
        // 완주자 수에 맞춰서 인원수 낮춰주기
        for(String name : completion) {
            if(!parts.containsKey(name)) {
                return name;
            } else {
                if(parts.get(name) - 1 != 0) {
                    parts.put(name, parts.get(name) - 1);
                } else {
                    parts.remove(name);
                }
            }
        }
        return parts.keySet().iterator().next();
    }
}