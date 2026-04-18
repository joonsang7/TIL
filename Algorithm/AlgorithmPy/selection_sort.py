import random
import time


# 10,000개의 random int array 생성 
arr = [random.randint(0, 10000) for _ in range(10000)]  

def selection_sort(arr):
    n = len(arr)
    for i in range(n):
        # 정렬되지 않은 배열에서 최솟값 찾기
        min_index = i
        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j
        
        # 찾은 최솟값을 첫 번째 요소와 교환
        arr[i], arr[min_index] = arr[min_index], arr[i]

# 실행 시간 측정
start_time = time.time()
selection_sort(arr)
end_time = time.time()

# 실행 시간을 ms 단위로 출력
execution_time_ms = (end_time - start_time) * 1000
print(f"Execution time: {execution_time_ms:.2f} ms")
