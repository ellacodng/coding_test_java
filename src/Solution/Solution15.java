package Solution;

import java.util.ArrayDeque;
import java.util.Queue;


public class Solution15 {
    public int solution(int N, int K)
    {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++)
        {
            queue.add(i);
        }

        while(!queue.isEmpty())
        {
            for (int i = 0; i < K-1; i++)
            {
                if (queue.isEmpty()) { // null exception 방지용
                    break;
                }

                int temp = queue.poll();
                queue.add(temp);
            }

            if(queue.size() == 1)
                break;

            int n = queue.remove();
        }

        return queue.poll();
    }
}