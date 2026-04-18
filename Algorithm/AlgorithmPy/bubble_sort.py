import random
import time

# 10,000개의 random int array 생성
arr_size = 10000
arr = [random.randint(0, 10000) for _ in range(arr_size)]


# Bubble Sort 함수
def bubble_sort(arr):
    n = len(arr) # 배열의 길이
    for i in range(n): # 배열의 길이만큼 반복한다
        for j in range(0, n - i - 1): # 마지막 i 요소는 이미 정렬되어 있으므로 n-i-1까지 반복한다
            # index + 1 의 값이 index 보다 크면 교환한다
            if arr[j] > arr[j + 1]: 
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    
    
# 10 회 반복하여 Bubble Sort 실행 및 시간 측정
for i in range(10):
    # 실행 시간 측정
    start_time = time.time()
    bubble_sort(arr)
    end_time = time.time()

    # 실행 시간을 ms 단위로 출력
    execution_time = (end_time - start_time) * 1000
    print(f"실행 시간: {execution_time:.2f} ms")    



