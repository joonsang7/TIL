#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

void error_handling(char *message);

int main(int argc, char *argv[])
{

    for(int i = 0; i < argc; i++) {
        printf("argv[%d] = %s\n", i, argv[i]);
    }
    
    int serv_sock;
    int clnt_sock;

    struct sockaddr_in serv_addr;
    struct sockaddr_in clnt_addr;
    socklen_t clnt_addr_size;

    char message[] = "Hello World!";

    // 예외 처리: 인자 개수가 2가 아니면 에러 메시지 출력 후 종료
    if(argc != 2){
        printf("Usage : %s <port>\n", argv[0]);
        exit(1);
    }

    // 소켓 생성. 소켓의 생성은 socket() 함수를 사용하며, PF_INET은 IPv4 인터넷 프로토콜을 의미하고, SOCK_STREAM은 TCP 소켓을 의미한다.
    serv_sock = socket(PF_INET, SOCK_STREAM, 0);
    // 예외 처리: 소켓 생성 실패 시 에러 메시지 출력 후 종료
    if(serv_sock == -1)
        error_handling("socket() error");

    // serv_addr 구조체를 초기화하고, 소켓의 주소 정보를 설정한다.
    // memset() 함수를 사용하여 구조체를 0으로 초기화하고, sin_family를 AF_INET으로 설정하여 IPv4를 사용하도록 한다.
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    // INADDR_ANY는 서버가 실행되는 호스트의 모든 IP 주소를 의미하며, htonl() 함수를 사용하여 네트워크 바이트 순서로 변환한다.
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(atoi(argv[1]));

    // bind() 함수를 사용하여 소켓에 주소 정보를 할당한다.
    if(bind(serv_sock, (struct sockaddr*) &serv_addr, sizeof(serv_addr)) == -1)
        error_handling("bind() error");

    // listen() 함수를 사용하여 클라이언트의 연결 요청을 기다린다.
    if(listen(serv_sock, 5) == -1)
        error_handling("listen() error");

    // accept() 함수를 사용하여 클라이언트의 연결 요청을 수락한다. 이 함수는 블로킹 함수로, 클라이언트의 연결 요청이 올 때까지 대기한다.
    clnt_addr_size = sizeof(clnt_addr);
    // accept() 함수는 클라이언트의 연결 요청을 수락하고, 새로운 소켓을 반환한다. 이 소켓은 클라이언트와의 통신에 사용된다.
    clnt_sock = accept(serv_sock, (struct sockaddr*)&clnt_addr, &clnt_addr_size);
    // 예외 처리: accept() 실패 시 에러 메시지 출력 후 종료
    if(clnt_sock == -1)
        error_handling("accept() error");

    // 만약 클라이언트와의 연결이 성공하면, write() 함수를 사용하여 "Hello World!" 메시지를 클라이언트로 전송한다.
    // 클라이언트의 ip 주소도 출력한다.
    printf("Connected client IP: %s \n", inet_ntoa(clnt_addr.sin_addr));
    write(clnt_sock, message, sizeof(message));
    // 전송이 완료되면, close() 함수를 사용하여 클라이언트 소켓과 서버 소켓을 닫는다.
    close(clnt_sock);
    close(serv_sock);
    return 0;
}

void error_handling(char *message)
{
    fputs(message, stderr);
    fputc('\n', stderr);
    exit(1);
}