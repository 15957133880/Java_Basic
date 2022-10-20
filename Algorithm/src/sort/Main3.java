package sort;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int N = Integer.parseInt(sc.nextLine());
//
//            int[][] nums = new int[N][N];
//            for (int i = 0; i < N; i++) {
//
//                String s = sc.nextLine();
//                String[] strs = s.split("  ");
//
//                for (int j = 0; j < N; j++) {
//                    if (strs[j].equals("A")) {
//                        nums[i][j] = 1;
//                        System.out.println(nums[i][j]);
//                    }
//                    else if (strs[j].equals("B")) {
//                        nums[i][j] = 2;
//                        System.out.println(nums[i][j]);
//                    }
//                    else if (strs[j].equals("C")) {
//                        nums[i][j] = 3;
//                        System.out.println(nums[i][j]);
//                    }
//                }
//            }
//            int[][] nums = new int[2][2];
//            nums[0][0] = 1;
//            nums[0][1] = 2;
//            nums[1][0] = 1;
//            nums[1][1] = 3;
//            int res = solution(nums);
//            System.out.println("res: " + res);
        byte b = 1;
        short s = 1;
        System.out.println(true & false);

    }
    static String getType(Object o) {
        return o.getClass().toString();
    }

    static int solution(int[][] nums) {
        int res = 0;
        int M = nums.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j ++) {
                System.out.println("i:" + i + "  j:" + j);
                if (nums[i][j] == 1) {
                    int t =  bfs(nums, i, j);
                    System.out.println("t:  " + t);
                    res += t;
                }
            }
        }
        return res;
    }

    static int bfs(int[][] nums, int i, int j) {
        int M = nums.length;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(getOrder(M, i, j));
        int steps = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                int x = cur / M;
                System.out.println("x: " + x);
                int y = cur % M;
                System.out.println("y: " + y);
                visited.add(cur);
                if (nums[x][y] == 3) {
                    return steps;
                }
                if (isValid(M, x - 1, y) && (nums[x - 1][y] == 1 ||nums[x - 1][y] == 3) && !visited.contains(getOrder(M, x - 1, y))) {
                    q.offer(getOrder(M, x - 1, y));
                }
                if (isValid(M, x + 1, y) && (nums[x + 1][y] == 1 ||nums[x + 1][y] == 3) && !visited.contains(getOrder(M, x + 1, y))) {
                    q.offer(getOrder(M, x + 1, y));
                }
                if (isValid(M, x, y + 1) && (nums[x][y + 1] == 1 ||nums[x][y + 1] == 3) && !visited.contains(getOrder(M, x, y + 1))) {
                    q.offer(getOrder(M, x, y + 1));
                }
                if (isValid(M, x, y - 1) && (nums[x][y - 1] == 1 ||nums[x][y - 1] == 3) && !visited.contains(getOrder(M, x, y - 1))) {
                    q.offer(getOrder(M, x, y - 1));
                }
            }
        }
        return -1;

    }

    static int getOrder(int M, int i, int j) {
        return i * M + j;
    }
    static boolean isValid(int M, int i, int j) {

        if (i < 0 || i == M || j < 0 || j == M) {
            return false;
        }
        return true;
    }
}
