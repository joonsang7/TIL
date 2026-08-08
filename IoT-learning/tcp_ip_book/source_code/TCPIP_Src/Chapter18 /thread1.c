#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
 
void* thread_main_1(void *arg);
void* thread_main_2(void *arg);
void* thread_main_3(void *arg);
 
int main(int argc, char *argv[])
{
    pthread_t t_id, t2_id, t3_id;
    int thread_param = 5;
 
    if (pthread_create(&t_id, NULL, thread_main_1, (void*)&thread_param))
    {
        puts("pthread_create() error");
        return -1;
    }
 
    if (pthread_create(&t2_id, NULL, thread_main_2, (void*)&thread_param))
    {
        puts("pthread_create() error");
        return -1;
    }
 
    if (pthread_create(&t3_id, NULL, thread_main_3, (void*)&thread_param))
    {
        puts("pthread_create() error");
        return -1;
    }
 
    pthread_join(t_id, NULL);
    pthread_join(t2_id, NULL);
    pthread_join(t3_id, NULL);
 
    puts("end of main");
    return 0;
}
 
void* thread_main_1(void *arg)
{
    int i;
    int cnt = *((int*)arg);
    for (i = 0; i < cnt; i++)
    {
        sleep(1);
        puts("running thread...1");
    }
    return NULL;
}
 
void* thread_main_2(void *arg)
{
    int i;
    int cnt = *((int*)arg);
    for (i = 0; i < cnt; i++)
    {
        sleep(1);
        puts("running thread...2");
    }
    return NULL;
}
 
void* thread_main_3(void *arg)
{
    int i;
    int cnt = *((int*)arg);
    for (i = 0; i < cnt; i++)
    {
        sleep(1);
        puts("running thread...3");
    }
    return NULL;
}