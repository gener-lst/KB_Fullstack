class Solution {
	public int solution(int slice, int n) {
		int answer = 0;
		if (slice >= n) { 
			answer = 1;
		} else {
			answer = (int)Math.ceil(n / slice);
		}
		return answer;
    }
}

