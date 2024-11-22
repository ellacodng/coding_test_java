import java.util.ArrayList;
import java.util.List;

class Solution25 {

    // 전위 순회
    public List<Integer> preOrder(List<Integer> nodes, int index) {
        List<Integer> result = new ArrayList<>();
        if (index >= nodes.size()) {
            return result;
        }

        // 현재 노드 추가
        result.add(nodes.get(index));

        // 왼쪽 자식 탐색
        result.addAll(preOrder(nodes, 2 * index + 1));

        // 오른쪽 자식 탐색
        result.addAll(preOrder(nodes, 2 * index + 2));

        return result;
    }

    // 중위 순회
    public List<Integer> inOrder(List<Integer> nodes, int index) {
        List<Integer> result = new ArrayList<>();
        if (index >= nodes.size()) {
            return result;
        }

        // 왼쪽 자식 탐색
        result.addAll(inOrder(nodes, 2 * index + 1));

        // 현재 노드 추가
        result.add(nodes.get(index));

        // 오른쪽 자식 탐색
        result.addAll(inOrder(nodes, 2 * index + 2));

        return result;
    }

    // 후위 순회
    public List<Integer> postOrder(List<Integer> nodes, int index) {
        List<Integer> result = new ArrayList<>();
        if (index >= nodes.size()) {
            return result;
        }

        // 왼쪽 자식 탐색
        result.addAll(postOrder(nodes, 2 * index + 1));

        // 오른쪽 자식 탐색
        result.addAll(postOrder(nodes, 2 * index + 2));

        // 현재 노드 추가
        result.add(nodes.get(index));

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스 1
        List<Integer> nodes1 = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println("테스트 케이스 1:");
        System.out.println("전위 순회: " + solution.preOrder(nodes1, 0));
        System.out.println("중위 순회: " + solution.inOrder(nodes1, 0));
        System.out.println("후위 순회: " + solution.postOrder(nodes1, 0));

        // 테스트 케이스 2
        List<Integer> nodes2 = List.of(10, 20, 30, 70, 40, 50, 60);
        System.out.println("\n테스트 케이스 2:");
        System.out.println("전위 순회: " + solution.preOrder(nodes2, 0));
        System.out.println("중위 순회: " + solution.inOrder(nodes2, 0));
        System.out.println("후위 순회: " + solution.postOrder(nodes2, 0));
    }
}
