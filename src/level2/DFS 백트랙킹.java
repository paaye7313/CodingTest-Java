package level2;

/*
    2026-03-26
    이 문제는 완전탐색문제
    선택지는 깊이우선탐색이냐 아니면 넓이우선탐색이냐
    남은 피로도에 따라 입장조건이 되는 던전을 돌 수 있음
    원작 게임의 경우 입장조건이 높은 순으로 도는 것이 좋지만 이번 문제의 경우 아닐수 도 있음
    깊이우선탐색을 하면서 가장 높은 점수만 갱신 하면 됨
    우선 AI나 구글에 검색하기 전에 혼자 해봄
    깊이우선탐색이기 때문에 스택 필요
    문제를 다시 읽어보니 문제의 던전은 하루에 한번씩만 입장이 가능함 -> 방문확인 배열 필요
    java.util 라이브러리에서 제공하는 스택의 사용법을 잊어서 구글에 검색
    그냥 깊이우선탐색을 구글에 검색
    여러번 테스트와 수정을 거쳐 테스트는 통과, 하지만 채점은 몇몇경우가 실패하여 오답
    AI에게 질문함 -> 결과 깊이우선탐색을 맞았지만 백트랙킹 으로 해결했어야 함
    AI가 출력해준 코드로 채점까지 통과
    코드 분석 시작
    1. 재귀함수를 사용하기 때문에 리턴할 최대값 변수를 solution 밖에서 선언
    2. 재귀함수에 따라갈 파라미터로는 현재 피로도(초기값 k), 던전 정보, 방문 여부, 탐험한 던전 수(초기값 0)
    3-1. 우선 최대값 변수를 갱신
    3-2. for문으로 모든 던전 시도
    3-3-1. 방문하지 않았고 필요 피로도 조건에 맞다면 방문함으로 표시 후 재귀함수 호출
    3-3-2. 재귀함수 호출 시 파라미터로 현재 피로도에서 방문한 던전 피로도를 차감, 탐험한 던전 수 + 1
    3-4. 재귀함수에서 돌아왔을때 방문함을 해제(여기가 백트랙킹의 핵심)
*/
import java.util.*;

class Solution {
    private int maxDungeons = 0;

    public int solution(int k, int[][] dungeons) {
        // 백트래킹으로 모든 가능한 던전 탐험 순서를 시도
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);

        return maxDungeons;
    }

    // DFS 백트래킹: 현재 피로도, 던전 정보, 방문 여부, 탐험한 던전 수
    private void dfs(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
        // 현재까지의 최댓값 갱신
        maxDungeons = Math.max(maxDungeons, count);

        // 모든 던전을 시도해본다
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 탐험하지 않았고, 필요 피로도를 충족한다면
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                // 현재 던전을 탐험한 후의 상태로 다음 재귀 호출
                dfs(currentFatigue - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}