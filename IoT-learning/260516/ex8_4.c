#include <stdio.h>

void myStrcpy(char *copy, unsigned long copy_size, char *origin, unsigned long origin_size);

int main(void){
    char str1[80] = "cat";
    char str2[80] = "dog";
    

    printf("str1의 크기 = %lu bytes\n", sizeof(str1)/sizeof(str1[0])); // str1 배열의 크기 출력. char형은 1바이트이므로, str1 배열의 크기는 80바이트가 된다.
    printf("str2의 크기 = %lu bytes\n", sizeof(str2)/sizeof(str2[0])); // str2 배열의 크기 출력. char형은 1바이트이므로, str2 배열의 크기는 80바이트가 된다.


    // myStrcpy(char *copy, unsigned long copy_size, char *origin, unsigned long origin_size) 
    myStrcpy(str2, sizeof(str2)/sizeof(str2[0]), 
            str1, sizeof(str1)/sizeof(str1[0])); 

            
    printf("문자열 str1의 주소 = %p\n", str1); // str1 배열의 주소 출력. %p는 포인터 주소를 출력하는 형식 지정자이다. str1은 char 배열이므로, str1 자체가 배열의 첫 번째 요소의 주소를 나타낸다. 따라서 이 출력은 str1 배열의 시작 주소를 보여준다.
    printf("문자열 str1의 값 = %s\n", str1); // str1 배열의 값 출력. %s는 문자열을 출력하는 형식 지정자이다. str1은 char 배열이므로, str1 자체가 배열의 첫 번째 요소의 주소를 나타낸다. 따라서 이 출력은 str1 배열에 저장된 문자열 "cat"을 보여준다.
    printf("문자열 str2의 주소 = %p\n", str2); // str2 배열의 주소 출력. str2도 char 배열이므로, str2 자체가 배열의 첫 번째 요소의 주소를 나타낸다. 따라서 이 출력은 str2 배열의 시작
    printf("문자열 str2의 값 = %s\n", str2); // str2 배열의 값 출력. str2는 char 배열이므로, str2 자체가 배열의 첫 번째 요소의 주소를 나타낸다. 따라서 이 출력은 str2 배열에 저장된 문자열 "cat"을 보여준다.


    return 0;
}

void myStrcpy(char *copy, unsigned long copy_size, char *origin, unsigned long origin_size){
    for( int i = 0; i < copy_size && i < origin_size; i++){
        copy[i] = origin[i]; // origin 배열의 각 요소를 copy 배열의 대응되는 요소에 복사한다. 이 루프는 origin 배열의 모든 요소를 copy 배열로 복사하는 역할을 한다. 따라서 copy 배열은 origin 배열과 동일한 문자열을 가지게 된다.
    }
}