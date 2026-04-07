package level2;

/*
    2026-04-07
    해당 문제는 괄호가 정상인지 확인하고 한칸씩 밀었을때 유효한 괄호의 개수를 구하는 문제입니다.
    1. 괄호 문자열의 길이 만큼 반복문을 돌립니다.
    2. 우선 괄호 문자열이 정상인지 확인하고 정상이라면 카운트를 하나 올립니다.
    3. 그리고 괄호 문자열을 한칸 밀어 줍니다.
    4. 반복문이 끝나면 카운트를 반환합니다.

    위 과정에서 괄호 문자열이 정상인지 확인하려면 스택을 사용해야 합니다.
    스택을 사용하여 괄호가 정상적으로 열고 닫는지 확인합니다.
    stack과 string 메소드 등을 알아보려 구글에 검색 후 테스트
    괄호를 확인하는 메소드를 만들고 그 메소드를 이용하여 괄호 문자열이 정상인지 확인
    괄호 문자열을 한칸씩 밀 때는 substring, charAt 메소드를 사용하여 구현
    채점을 시도 했지만 단 한 개의 채점에서 실패
    혹시나 괄호 문자열 이외에 다른 문자가 들어올 수 있을까 생각하여 괄호가 아닌 문자가 들어올수도 있다고 생각해 봤지만
    작성한 코드에서는 괄호가 아닌 문자가 들어올 경우에도 정상적으로 작동하는 것을 확인
    괄호 정상 확인문제를 구글에 검색
    검색 결과 괄호 확인후에 스택이 비어있는지 확인하지 않았음을 확인
    채점 통과
*/
import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (check(s))
                count++;
            s = s.substring(1) + s.charAt(0);
        }

        return count;
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (stack.empty())
                return false;
            if (c == ')') {
                if (stack.peek() != '(')
                    return false;
                stack.pop();
            }
            if (c == '}') {
                if (stack.peek() != '{')
                    return false;
                stack.pop();
            }
            if (c == ']') {
                if (stack.peek() != '[')
                    return false;
                stack.pop();
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }
}