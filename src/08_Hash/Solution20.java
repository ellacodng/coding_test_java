import java.util.HashMap;

class Solution20 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 제품과 수량을 HashMap에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 10일씩 확인하는 루프
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();

            // 10일 동안의 할인 제품을 HashMap에 저장
            for (int j = i; j < i + 10; j++) {
                if (discountMap.containsKey(discount[j])) {
                    discountMap.put(discount[j], discountMap.get(discount[j]) + 1);
                } else {
                    discountMap.put(discount[j], 1);
                }
            }

            // 조건 확인
            boolean isMatch = true;
            for (String key : wantMap.keySet()) {
                if (!discountMap.containsKey(key) || discountMap.get(key) < wantMap.get(key)) {
                    isMatch = false;
                    break;
                }
            }

            // 조건이 맞으면 가능한 날짜로 추가
            if (isMatch) {
                answer++;
            }
        }

        return answer;
    }
}
