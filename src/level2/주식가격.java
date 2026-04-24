package level2;

/*
    2026-04-24
    문제 설명
    초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
    가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

    제한사항
    prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    prices의 길이는 2 이상 100,000 이하입니다.

    이 문제는 문제를 이해하는데 시간이 좀 걸렸음
    가격이 떨어졌다는 기준이 특정(A) 초 이후 가격들중에 특정(A) 초에 기록된 가격보다 낮은 가격이 되면 가격이 떨어졌다고 판단하는 것으로 이해함
    
    단순히 for문 2개로 풀 수도 있지만 시간복잡도가 O(n^2)으로 100,000^2 = 10,000,000,000이 되어 시간 초과가 발생할 것으로 예상됨
    문제의 주제처럼 스택을 이용하여 풀어야 할 것으로 생각됨

    우선 prices의 크기만큼 for문으로 순회하는 구조
    1. 스택이 비어있으면 현재 인덱스를 스택에 넣음
    2. 스택이 비어있지 않으면 현재 인덱스에 해당하는 가격이 스택의 top에 해당하는 인덱스에 해당하는 가격보다 낮은지 확인
        2-1. 낮으면 스택의 top에 해당하는 인덱스에 해당하는 가격이 떨어졌다고 판단하여 스택에서 top을 꺼내고 
            그 인덱스에 해당하는 answer값에 현재 인덱스와 꺼낸 인덱스의 차이를 넣음
        2-2. 낮지 않으면 현재 인덱스를 스택에 쌓음
    
    스택에는 가격을 넣지 않고 인덱스만 넣는 이유는 가격이 떨어졌다고 판단할 때 현재 인덱스와 꺼낸 인덱스의 차이를 계산하기 위해서임

    구글에 스택관련 메소드를 검색하면서 문제풀이 시작

    테스트는 성공했으나 채점에서 런타임 에러 발생
    런타임 에러는 스택이 비어있을 때 peek() 메소드를 호출해서 발생한 것으로 보임
    while문 조건에 스택이 비어있지 않은지 확인하는 조건을 추가하여 해결

    채점과 효율성 테스트 모두 성공

    위에 런타임 에러를 해결하는 과정에서 isEmpty()랑 peek()가 같이 while문 조건에 들어가있어서 또 오류가 나지 않을까 걱정했지만
    자바가 알아서 &&뒤에 연산을 수행하기 전에 &&앞의 조건이 false인지 확인해서 isEmpty()가 true일 때 peek()를 호출하지 않도록 해주는 것 같음
*/

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (prices.length - 1) - idx;
        }

        return answer;
    }
}