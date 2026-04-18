package sorting;

// 삽입 정렬 알고리즘  ( 포인트 - 기준과 경계선 )
/*
 * 적당한 자리 찾아서 삽입한다.
 * 먼저 배열의 처음 수를 기준 수로 잡는다. (key)
 * 그리고 기준과 경계선의 왼쪽에 있는 수를 비교한다. (j)
 * 그리고 기준과 경계선의 오른쪽에 있는 수를 비교한다. (i+1)
 * 기준과 경계선의 왼쪽에 있는 수가 기준보다 크면, 그 수를 오른쪽으로 이동한다. 
 * 그리고 경계선을 왼쪽으로 이동한다. (j--)
 * 그리고 기준과 경계선의 왼쪽에 있는 수가 기준보다 작으면, 그 수를 오른쪽으로 이동한다. 	
 */

public class InsertionSort {
	private int[] arr;

	public InsertionSort(int[] arr) {
		this.arr = arr;

	}

	public void InsertionSorting() {
		int arrLength = arr.length; // 배열 길이
		for (int i = 1; i < arrLength; i++) {
			int key = arr[i]; // 기준값
			int j = i - 1; // 경계선

			// key 값이 경계선보다 작으면 경계선을 오른쪽으로 밀고 빈자리에 key 값을 삽입한다.
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j]; // 경계선의 값을 오른쪽으로 이동한다.
				j--; // 경계선을 왼쪽으로 이동한다.
			}
			arr[j + 1] = key; // key 값을 적절한 위치에 삽입한다.
		}
	}

}
