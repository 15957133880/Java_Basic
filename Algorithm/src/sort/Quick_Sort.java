package sort;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] array1 = new int[]{2,9, -9, 7, -6, 3, 8, 0, 3, -1};
        quickSort2(array1, 0, array1.length-1);
        for (int i = 0; i <= array1.length - 1; i++) {
            System.out.print(array1[i]+ ",");
        }
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    private static void quickSort1(int[] array, int start, int end) {
        //pivot值先不动，把小于pivotr的放到前面，大于pivot的放到后面，最后再把pivot放到指定位置
        if (start < end) {
            int key = array[start];
            int i = start;
            for (int j = start + 1; j <= end; j++) {
                if (array[j] <key) {
                    swap(array, ++i, j);
                }
            }
            swap(array, start, i);
            quickSort1(array, start, i-1);
            quickSort1(array, i+1, end);
        }
    }

    private static void quickSort2(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition(array, start, end);
            quickSort2(array, start, pivot-1);
            quickSort2(array, pivot+1, end);
        }
    }

    private static void quickSort3(int[] array, int start, int end) {
        if (start < end) {
            int pivot = partition2(array, start, end);
            quickSort2(array, start, pivot-1);
            quickSort2(array, pivot+1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if (array[j] < pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, start, i);
        return i;
    }

    private static int partition2(int[] array, int start, int end) {
        int pivotIndex = start;
        while (start != end) {
            while (start < end && array[start] < array[pivotIndex]) {start++;}
            while (start < end && array[end] >= array[pivotIndex]) {end--;}
            swap(array, start, end);
        }
        return start;
    }

}

