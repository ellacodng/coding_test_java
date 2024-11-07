import java.util.ArrayDeque;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [] progresses = {93, 30, 55};
        int [] speeds = {1, 30, 5};
    }

    public int[] solution16(int[] progresses, int[] speeds) {
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