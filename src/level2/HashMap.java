package level2;

/*
    2026-03-23
    구매할 물건과 수를 HashMap으로 만들고, 할인 물건과 수도 HashMap으로 만든 다음
    둘을 비교하여 같은 경우를 카운트해서 리턴

    내가 생각하지 못한 사실 : 구매할 물건 수는 10개 고정이다, 
                            이를 통해 0부터 discount.length - 10까지의 시작점을 보면 된다.
                            또, HashMap끼리 equals()로 비교가 가능했다.
*/

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 1단계: want 배열을 HashMap으로 변환
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int count = 0;

        // 2단계: discount 배열의 각 시작점을 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            // 3단계: i번째부터 10일간의 할인 제품을 HashMap으로 카운트
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                discountMap.put(product, discountMap.getOrDefault(product, 0) + 1);
            }

            // 4단계: wantMap과 discountMap이 정확히 같은지 비교
            if (wantMap.equals(discountMap)) {
                count++;
            }
        }

        return count;
    }
}