import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        ArrayList<String> pb = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(pb);
        for(int i = 0; i < pb.size() - 1; i++){
            String s = pb.get(i); // 비교할거
            String l = pb.get(i+1); // 다음꺼
            if(s.length() < l.length() && s.equals(l.substring(0, s.length())))
                return false;
        }
        return true;
    }
}