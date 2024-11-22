import java.util.HashMap;

public class Solution18 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,8};
        int target = 6;

        int [] arr2 = {2,3,5,9};
        int target2 = 10;

        System.out.println(solution(arr, target));
        System.out.println(solution(arr2, target2));
    }

    public static boolean solution(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int n = target - arr[i];

            // 자기 자신을 포함하지 않는지 확인
            if (hashMap.containsKey(n) && hashMap.get(n) != i) {
                return true;
            }
        }

        return false;
    }
}
