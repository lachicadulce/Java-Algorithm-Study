import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 초기화
        int answer = 0;
        ArrayList<Integer> students = new ArrayList<>();
        ArrayList<Integer> losts = new ArrayList<>();
        ArrayList<Integer> reserves = new ArrayList<>();
        for(int i = 0; i < n; i++)
            students.add(1);
        for(int l : lost)
            losts.add(l);
        for(int r : reserve)
            reserves.add(r);
        // 잃어버린 친구랑 여분이 있는 친구랑 같은 친구가 있는지 확인
        for(int r : reserves){
            for(int l : losts){
                if(r == l){
                    losts.remove(losts.indexOf(l));
                    reserves.set(reserves.indexOf(r), 0);
                    break;
                }
            }
        }
        Collections.sort(losts);
        // 0값 제거하기
        while(reserves.remove(Integer.valueOf(0))){}
        // 여분이 아예 없으면 체크할 필요가 없지요
        if(reserves.size() == 0){
            return n - losts.size();
        }
        // 잃어버린 친구의 앞뒤 친구들의 여분 확인
        for(int l : losts){
            int m = reserves.indexOf(l-1);
            int p = reserves.indexOf(l+1);
            if(m != -1)
                reserves.remove(m);
            else if(p != -1)
                reserves.remove(p);
            else
                students.set(l-1, 0);
        }
        // 있는 친구들 합
        for(int s : students){
            answer += s;
        }
        return answer;
    }
}