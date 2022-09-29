package sort;

public class HeapSort {
    //向上建堆  向下调整
    public static void main(String[] args) {
        int[] array1 = new int[]{2,9, -9, 7, -6, 3, 8, 0, 3, -1};
        heapSort(array1);
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

    private static int getParent(int index) {
        return (index + 1) / 2 - 1;
    }

    private static int getLeft(int index) {
        return index * 2 + 1;
    }

    private static int getRight(int index) {
        return index * 2 + 2;
    }

    private static void heapSort(int[] array) {
        int len = array.length;
        buildMaxHeap(array, len);
        for (int j = len - 1; j >0; j--) {
            swap(array, 0, j);
            maxHeapfy(array, 0, j);
        }
    }

    private static void buildMaxHeap(int[] array, int heapSize) {
        for (int i = getParent(heapSize - 1); i >= 0; i--) {
            maxHeapfy(array, i, heapSize);
        }
    }

    private static void maxHeapfy(int[] array, int index, int heapSize) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest = index;
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, index, largest);
            maxHeapfy(array, largest, heapSize);
        }
    }
}
