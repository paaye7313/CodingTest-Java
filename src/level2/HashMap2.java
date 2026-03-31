package level2;

/*
    2026-03-31
    이 문제는 사용 가능한 모든 조합의 수를 구하는 문제
    의상을 착용할 수 있느 부위가 있고, 한 부위에는 하나의 의상만 착용이 가능함
    주워진 데이터로는 의상의 이름과 착용부위가 있지만 이름은 딱히 필요해 보이진 않고 착용부위의 갯수가 중요해 보임
    문제 분류에서 이 문제가 해시를 이용한 문제라는 것을 힌트로 주어짐
    키로 착용부위, 값으로 가지수로 데이터를 모와 총 의상수 + 각 착용부위 가지수 * 로 구하면 좋아 보이지만 
    착용부위에 꼭 의상을 착용 하지 않아도 되기 때문에 각 착용부위 + 1 로 모두 곱하면 될것 처럼 보임
    해시맵관련 메소드들은 전에 해본 HashMap.java와 구글을 통해 검색
    테스트했으나 기대값에서 +1인 값이 출력 되는 상황
    생각해보니 꼭 의상을 착용 하지 않아도 되지만 아무 옷도 입지 않는 경우는 없기 때문에 기존 출력에서 -1을 함
    채점 통과


*/
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 해시맵
        Map<String, Integer> hashMap = new HashMap<>();
        // 착용 부위별 옷가지 수를 카운팅
        for (String[] c : clothes) {
            hashMap.put(c[1], hashMap.getOrDefault(c[1], 1) + 1);
        }
        // values만 가져옴
        Collection<Integer> values = hashMap.values();
        // stream으로 모든 요소를 곱하고 +1을 함
        return values.stream().reduce(1, (a, b) -> a * b) - 1;
    }
}