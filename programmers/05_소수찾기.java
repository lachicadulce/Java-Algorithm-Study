import java.util.*;
class Solution {
    static Set<Integer> nums = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
		int len = numbers.length();
        int[] arr = new int[len];
		boolean[] visited = new boolean[len]; //중복해서 뽑지 않기 위해 방문했는지를 체크하는 배열
        int num = Integer.parseInt(numbers);
        for(int i = 0; i < numbers.length(); i++){
            arr[i] = num % 10;
            num = num / 10;
        }
        for(int i = 1; i < len + 1; i++) {
            permutation(arr, 0, len, i);
        }
        
        Iterator<Integer> it = nums.iterator(); // Iterator(반복자) 생성
		while (it.hasNext()) {
            if(isPrime(it.next()))
               answer++;
		}
        return answer;
    }
    // 소수면 true, 아니면 false
    static boolean isPrime(int number) {
        if(number == 2) {
            return true;
        } else if(number == 1 || number % 2 == 0) {
            return false;
        }
        for(int i = 3; i < number / 2; i = i + 2) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
    // Swap 함수를 이용해 구현 - 순서 없이 n 개중에서 r 개를 뽑는 경우
	static void permutation(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			addToSet(arr, r);
			return;
		}

		for(int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}
    // 두 배열의 값을 바꾸는 Swap 함수 
	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
	// 배열을 set에 저장
	static void addToSet(int[] arr, int r) {
        String sumNum = "";
		for(int i = 0; i < r; i++){
            sumNum += arr[i];
        }
		nums.add(Integer.parseInt(sumNum));
	}
}