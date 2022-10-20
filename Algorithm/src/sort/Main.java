package sort;

import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    static ArrayList<Integer> ordi = new ArrayList<>();
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] nums = new int[M][N];
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                nums[x][y] = 1;
            }
            int[] source = new int[2];
            int[] target =  new int[2];
            source[0] = sc.nextInt();
            source[1] = sc.nextInt();
            target[0] = sc.nextInt();
            target[1] = sc.nextInt();
            solution(nums, source[0], source[1], target[0], target[1]);
            System.out.println(lists.size());
            if (!lists.isEmpty()) {
                for (ArrayList<Integer> list : lists) {
                    System.out.print(list.get(0) + " ");
                    System.out.println(list.get(1));
                }
            }
        }
    }

    static void solution(int[][] nums, int source_x, int source_y, int target_x, int target_y) {
        if (target_x == source_x && target_y == source_y) {
            return;
        }
        int M = nums.length;
        int N = nums[0].length;
        int sx = source_x;
        int sy = source_y;
        //上
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_x--;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sx != source_x) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        // 下
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_x++;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sx != source_x) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        //左
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_y--;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sy != source_y) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        //右
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_y++;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sy != source_y) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        //左上
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_x--;
            source_y--;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sy != source_y) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        //左下
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_x++;
            source_y--;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sy != source_y) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        //右上
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_x--;
            source_y++;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sy != source_y) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;
        //右下
        while (!is_outlier(M, N, source_x , source_y ) && nums[source_x][source_y] == 1) {
            source_x++;
            source_y++;
        }
        if (!is_outlier(M, N, source_x, source_y ) && sy != source_y) {
            ordi.add(source_x);
            ordi.add(source_y);
            lists.add(new ArrayList<>(ordi));
            solution(nums, source_x, source_y, target_x, target_y);
            ordi.clear();
            lists.remove(lists.size() - 1);
        }
        source_x = sx;
        source_y = sy;

    };



    static boolean is_outlier(int M, int N, int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}
