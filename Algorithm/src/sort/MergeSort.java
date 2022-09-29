package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array1 = new int[]{2,9, -9, 7, -6, 3, 8, 0, 3, -1};
        mergeSort2(array1, 0, array1.length-1);
        for (int i = 0; i <= array1.length - 1; i++) {
            System.out.print(array1[i]+ ",");
        }
    }

    // 递归写法
    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;;
        int mid = left + (right - left)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    //非递归写法(没改好）
    private static void mergeSort2(int[] array, int left, int right) {
        for (int sub_group = 1; sub_group <= (right - left + 1) / 2; sub_group *= 2) {
            for (int start = left; start <= right; start += sub_group * 2) {
                merge(array, start, start + sub_group -1, start + sub_group*2 - 1 );
            }
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[array.length];
        for (int i = left; i <= right; i++) {
            tmp[i] = array[i];
        }
        int left_ = left, right_ = mid + 1, cur = left;
        while (left_ <= mid && right_ <= right) {
            if (tmp[left_] < tmp[right_]) {
                array[cur++] = tmp[left_++];
            }
            else {
                array[cur++] = tmp[right_++];
            }
        }
        while (left_ <= mid) {
            array[cur++] = tmp[left_++];
        }
        while (right_ <= right) {
            array[cur++] = tmp[right_++];
        }
    }

}
