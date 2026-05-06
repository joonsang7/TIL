import matplotlib.pyplot as plt

# 메모이제이션 @lru_cache 없이 순수 재귀 함수로 피보나치 수 계산
# 계산 효율이 매우 낮아 n이 커지면 실행 속도가 급격히 느려짐
def fibonacci(n):
    if n == 1 or n == 2:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)
# 데이터 생성
months = list(range(1, 30))
rabbits = [fibonacci(m) for m in months]
# 그래프 그리기
plt.figure(figsize=(10, 6))
plt.plot(months, rabbits, marker='o', color='orange')
plt.title(
    'Fibonacci Rabbit Problem - Number of Pairs Over 12 Months', 
    fontsize=14
)
plt.xlabel('Month', fontsize=12)
plt.ylabel('Number of Rabbit Pairs', fontsize=12)
plt.grid(True)
plt.xticks(months)
plt.yticks(rabbits)
plt.tight_layout()
plt.show()