package Solution;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution16 {

    public static void main(String[] args) {
        int [] progresses1 = {93, 30, 55};
        int [] speeds1 = {1, 30, 5};

        int [] progresses2 = {90, 95, 39, 59, 99, 87};
        int [] speeds2 = {2, 1, 20, 10, 1, 9};

        System.out.println(Arrays.toString(solution16(progresses1, speeds1)));
        System.out.println(Arrays.toString(solution16(progresses2, speeds2)));
    }
    public static int[] solution16(int[] progresses, int[] speeds) {
        Queue<Integer> progressesQueue = new ArrayDeque<>();
        Queue<Integer> speedsQueue = new ArrayDeque<>();

        int[] answer = new int[100];
        int first = 0; // 첫 번째 값
        int check; // 배포 개수
        int j = 0; // answer 배열 인덱스

        // 각각의 queue에 초기값을 저장한다.
        for (int i = 0; i < speeds.length; i++) {
            progressesQueue.add(progresses[i]);
            speedsQueue.add(speeds[i]);
        }

        while (!progressesQueue.isEmpty()) {
            // 모든 작업에 속도를 더하는 과정
            int size = progressesQueue.size();
            for (int i = 0; i < size; i++) {
                int progress = progressesQueue.poll();
                int speed = speedsQueue.poll();
                progressesQueue.add(progress + speed); // 업데이트된 진행 상황을 다시 큐에 추가
                speedsQueue.add(speed); // 속도는 그대로 다시 추가
            }

            // 배포 과정
            check = 0;
            while (!progressesQueue.isEmpty() && progressesQueue.peek() >= 100) {
                progressesQueue.poll();
                speedsQueue.poll();
                check++;
            }

            if (check > 0) {
                answer[j++] = check;
            }
        }

        // 필요한 크기만큼 배열 복사
        int[] result = new int[j];
        System.arraycopy(answer, 0, result, 0, j);

        return result;
    }
}
