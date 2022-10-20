package sort;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            System.out.println("a: " + a);
            int[][] nums = new int[a][a];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    sc.nextLine();
                    String s = sc.nextLine();
                    System.out.println("**" + s.length());
                    System.out.println("s:  " + s);
                    if (s.equals("a")) {
                        nums[i][j] = 1;
                    }
                    else if (s.equals("b")) {
                        nums[i][j] = 2;
                    }
                    else if (s.equals("c")) {
                        nums[i][j] = 3;
                    }
                    System.out.println("i:" + i + "  j:" + j);
                    System.out.println("nums[i][j]:" + nums[i][j]);

                }
            }
        }

    }


}
