package sorting;

public class MergeSort {
    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    // 추가: 재귀적으로 배열을 분할하는 메소드
    public void mergeSorting(int[] arr, int p, int r) {
        if (p < r) { // 원소가 2개 이상일 때만 분할
            int q = (p + r) / 2; // 중간 인덱스
            mergeSorting(arr, p, q); // 왼쪽 재귀
            mergeSorting(arr, q + 1, r); // 오른쪽 재귀
            merge(arr, p, q, r); // 병합
        }
    }

    // merge 메소드: 두 부분 배열을 병합하여 정렬된 배열로 만든다
    public void merge(int[] arr, int p, int q, int r) {
        int leftSize = q - p + 1;
        int rightSize = r - q;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            left[i] = arr[p + i];
        for (int j = 0; j < rightSize; j++)
            right[j] = arr[q + 1 + j];

        int i = 0, j = 0, k = p;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < leftSize)
            arr[k++] = left[i++];
        while (j < rightSize)
            arr[k++] = right[j++];
    }
}