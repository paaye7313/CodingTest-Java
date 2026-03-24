package level2;

/*
    2026-03-24
    메모장을 이용해서 풀이 시작
    리스트 (동시에 완료된 ok 수집)
    스텝 (작업일)
    포인트 (제일 앞의 작업 번호)
    ok (완료된 프로그래스)

    스텝 * 스피드 + 프로그래스 가 100이 넘으면 ok 포인트++, 스탭++
    만약 다음 프로그래스의 스텝 * 스피드 + 프로그래스 가 100이 넘으면 이것도 ok 포인트++
    만약 프로그래스의 스텝 * 스피드 + 프로그래스 가 100을 넘지 못하면 저장된 ok의 값을 리스트에 저장
    스텝++ 하고 스텝 * 스피드 + 프로그래스 가 100이 넘으면 ok

    구글에서 리스트를 배열로 변환하는 방법을 찾음
    테스트와 수정을 거쳐 테스트는 통과
    채점도 통과
*/
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int step = 1;
        int point = 0;
        int ok = 0;

        while (point < progresses.length) {
            if (step * speeds[point] + progresses[point] >= 100) {
                ok++;
                point++;
                continue;
            }
            if (ok > 0) {
                list.add(ok);
                ok = 0;
            }
            step++;
        }
        if (ok > 0) {
            list.add(ok);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}