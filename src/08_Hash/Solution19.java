import java.util.HashMap;

class Solution19 {
    public String solution(String[] participant, String[] completion) {
        // 참가자 이름을 저장할 HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 참가자 이름을 해시에 추가
        for (String name : participant) {
            if (hashMap.containsKey(name)) {
                hashMap.put(name, hashMap.get(name) + 1); // 동명이인이면 값 증가
            } else {
                hashMap.put(name, 1); // 처음 등장하는 이름
            }
        }

        // 완주자의 이름을 해시에서 감소
        for (String name : completion) {
            if (hashMap.containsKey(name)) {
                hashMap.put(name, hashMap.get(name) - 1);
            }
        }

        // 완주하지 못한 사람 찾기
        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) > 0) { // 값이 남아 있는 경우
                return name;
            }
        }

        return ""; // 기본 반환값 (논리적으로 도달하지 않음)
    }
}
