package sorting;

/*
 * 버블 정렬 (거품 정렬)
 * 왼쪽 , 오른쪽 비교해서 왼쪽이 더 크면 오른쪽 수와 바꾼다.
 * 오른쪽이 크면 가만히 놔두고, 그 수부터 다시 시작해서 오른쪽과 비교 시작.
 * 한번 정렬을 다 하면, 가장 큰 수가 오른쪽에 있게된다.
 * 정렬이 끝날 때까지 반복 
 */

public class BubbleSort {
	private int[] arr;

	// 생성자
	public BubbleSort(int[] arr) {
		this.arr = arr;
	}

	public void BubbleSorting() {
		int arrayLength = arr.length;
		// 1. 바깥 for 문 -> 배열의 숫자만큼 돌면서 정렬하기 위함.
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				// 2. 내부 for 문 -> 각각의 숫자를 비교하면서위치 변경 수행
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
