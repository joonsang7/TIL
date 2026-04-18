package sorting;

/*
 * 선택 정렬 알고리즘 
 * 
 * 각 루프마다 
 * 1. 최대 원소를 찾는다
 * 2. 최대 원소와 맨 오른쪽 원소를 교환한다.
 * 3. 맨 오른쪽 원소를 제외한다.
 * 
 * 하나의 원소만 남을 때까지 위의 루프를 반복 !
 */

public class SelectionSort {
	private int[] arr;

	public SelectionSort(int[] arr) {
		this.arr = arr;

	}

	public void SelectionSorting() {
		int arrLength = arr.length; // 배열 길이

		// 첫 번째 for문 -> 배열의 현재 크기 만큼 반복하며 마지막 index가 Max 값이 되도록 설정
		for (int i = 0; i < arrLength - 1; i++) {
			int arrMax = arr[0]; // 최대값
			int arrMaxIndex = 0; // 최대값의 index
			// 두 번째 for문 -> 배열의 현재 크기 만큼 반복하며 최대값과 최대값의 index를 찾는다.}
			for (int j = 1; j < arrLength - i; j++) {
				if (arr[j] > arrMax) {
					arrMax = arr[j];
					arrMaxIndex = j;
				}
			}
			// 최대값과 맨 오른쪽 원소를 교환한다
			int temp = arr[arrLength - 1 - i];
			arr[arrLength - 1 - i] = arrMax;
			arr[arrMaxIndex] = temp;
			// 맨 오른쪽 원소를 제외한다. -> i가 증가하면서 arrLength - i가 감소하기 때문에, 맨 오른쪽 원소를 제외하는 효과있다
		}
	}

}
