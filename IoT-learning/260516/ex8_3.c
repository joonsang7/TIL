#include <stdio.h>

int main(void){

    int score[4] = {0,}; 
    int score_size = sizeof(score)/sizeof(score[0]); // score 배열의 전체 크기를 score 배열의 첫 번째 요소의 크기로 나누어서, score 배열의 요소 개수를 계산한다. sizeof(score)는 score 배열 전체의 크기를 바이트 단위로 반환하고, sizeof(score[0])는 score 배열의 첫 번째 요소의 크기를 바이트 단위로 반환한다. 따라서 이 계산은 score 배열에 몇 개의 요소가 있는지를 알려준다. 이 경우에는 5가 된다.

    printf("score 배열의 크기: %d bytes\n", score_size); // score 배열의 전체 크기 출력. 20이 나오는 이유는 int형이 4바이트이기 때문에, 5개의 요소가 있으므로 4 * 5 = 20이 된다.



    return 0;
}