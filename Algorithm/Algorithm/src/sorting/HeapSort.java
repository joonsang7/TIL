package sorting;

public class HeapSort {

    // 힙 정렬 메인 메서드. 입력 배열을 최대 힙으로 구성한 후, 루트(최대값)를 배열 끝으로 이동시키고, 힙 크기를 줄여가며 다시
    // heapify하여 정렬을 수행
    public void heapSorting(int[] arr) {
        int n = arr.length;

        // ----------- 1단계: 최대 힙(Max Heap) 구성 --------------------------
        // 마지막 내부 노드(n/2 - 1)부터 루트(0)까지 역순으로 heapify 수행
        // 리프 노드는 자식이 없으므로 건너뜀
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 결과: arr[0]에 최대값이 위치한 최대 힙 완성

        // ----------- 2단계: 정렬 수행 --------------------------
        for (int i = n - 1; i > 0; i--) {

            // 2-1. 루트(현재 최대값)를 배열 끝으로 이동
            // arr[0](최대값) ↔ arr[i](마지막 원소) 교환
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 결과: arr[i]에 i+1번째로 큰 값이 확정됨

            // 2-2. 힙 크기를 i로 줄이고 루트부터 다시 heapify
            // (확정된 arr[i]는 힙 범위에서 제외)
            heapify(arr, i, 0);
        }
    }

    /**
     * 특정 노드(i)를 루트로 하는 서브트리의 힙 속성 유지 메소드
     * 부모가 자식보다 항상 크도록 보장 (최대 힙 조건)
     */
    private void heapify(int[] arr, int n, int i) {

        // 현재 노드, 왼쪽/오른쪽 자식 인덱스 계산
        int largest = i; // 현재 노드를 최대값으로 가정
        int left = 2 * i + 1; // 왼쪽 자식 인덱스
        int right = 2 * i + 2; // 오른쪽 자식 인덱스

        // 왼쪽 자식이 현재 최대값보다 크면 최대값 갱신
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 현재 최대값보다 크면 최대값 갱신
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 최대값이 현재 노드(i)가 아니면 교환 후 재귀 호출
        if (largest != i) {

            // 현재 노드 ↔ 최대값 노드 교환
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 교환된 자식 노드부터 다시 힙 속성 확인 (재귀)
            heapify(arr, n, largest);
        }
        // largest == i 이면 이미 힙 조건 만족 → 종료
    }
}