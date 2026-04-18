package sorting;

public class QuickSort {

    // 퀵 정렬 메인 메서드. 입력 배열이 null이거나 길이가 0인 경우를 처리하고, 그렇지 않으면 quickSorting 메소드를 호출하여
    // 정렬을 수행
    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSorting(arr, 0, arr.length - 1);
    }

    // 퀵 정렬의 재귀적 구현 메서드. low와 high 인덱스를 받아서 배열을 분할하고, 각 부분에 대해 재귀적으로 quickSorting
    // 메소드를 호출하여 정렬을 수행
    private void quickSorting(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSorting(arr, low, partitionIndex - 1);
            quickSorting(arr, partitionIndex + 1, high);
        }
    }

    // 배열을 분할하는 메서드. 피벗을 선택하고, 피벗보다 작은 요소들을 왼쪽으로, 큰 요소들을 오른쪽으로 이동시킨 후, 피벗의 최종 위치를 반환
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // 배열의 두 요소를 교환하는 유틸리티 메서드. 주어진 배열과 두 인덱스를 받아서 해당 인덱스의 요소들을 서로 교환
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}