package level2;

/*
    2026-04-06
    문제설명부터 큐(Queue)를 사용한다고 설명
    기본적인 큐에 더해 큐 내부에 있는 요소중 우선순위가 높은 요소가 있는지 확인하는 과정이 필요
    큐에 요소를 뺄 때마다 우선순위가 높은 요소가 있는지 확인해야 함
    그냥 for문으로 돌릴 수 도 있겠지만 큐의 요소가 많아질수록 비효율적이 될 수 있음
    하지만 마침 프로세스 최대수는 100이하라고 되어있음
    그러므로 일단 for문으로 진행 하고 나중에 최적화 시도
    1. 큐에 주어진 프로세스 베열을 넣음
    2. 큐에서 요소를 하나씩 뺌(count+1)
    3. 뺀 요소가 우선순위가 가장 높은 요소인지 확인(for문)
     - 우선순위가 가장 높지 않으면 큐의 뒤에 넣음
     - 추적중인 프로세스라면 location도 업데이트(location = queue.size())
     - 우선순위가 가장 높다면 4.으로
    4. 추적중인 프로세스(location == 0)라면 break
    큐 사용법을 구글에 검색
    if문 중첩을 햇갈려서 시행착오가 있었음
    if문 들을 정리해서 침착하게 작성
    위의 순서와는 조금 달라졌지만 깔끔해짐
    배열 길이가 짧아서 반복문 2개를 중첩해도 빠르게 실행이 됨
    깔끔하게 성공
*/
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList();
        int count = 0;

        for (int p : priorities) {
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            int best = 0;
            for (int q : queue) {
                if (q > best)
                    best = q;
            }
            int now = queue.poll();

            if (now == best) {
                count++;
                if (location == 0) {
                    break;
                }
            }
            if (now < best) {
                queue.add(now);
                if (location == 0) {
                    location = queue.size();
                }
            }
            if (location > 0) {
                location--;
            }
        }
        return count;
    }
}