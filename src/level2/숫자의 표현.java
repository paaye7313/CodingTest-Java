package level2;

/*
    2026-03-23
    처음 시도는 for문 2개로 만듬 -> 문제는 풀었지만 효율성에서 실패
    두번째 시도는 2포인트로 시도 -> 마찬가지로 효율성에서 실패
    세번때 시도는 AI 활용 -> AI 출력 도중 문제를 발견함
    바로 출력문 때문으로 확인 -> 추력문을 주석으로 처리하니 효율성 통과
    AI 출력 결과(for 2개로 만듬)도 시도 -> 효율성 통과
    출력문이랑 for의 변수 설정을 유의 해야 겠음
    간단한 문제는 출력문 차이가 큰듯.
*/

class Solution {
    public int solution(int n) {
        int count = 1;
        int sum = 0;
        int left = 1;
        int right = 2;
        while (left != right) {
            sum = 0;
            for (int i = left; i <= right; i++) {
                sum += i;
            }
            // System.out.println("left : "+ left + " right : "+right+" sum : "+sum);
            if (sum < n)
                right++;
            if (sum > n)
                left++;
            if (sum == n) {
                count++;
                left++;
                right++;
            }

        }

        return count;
    }
}
