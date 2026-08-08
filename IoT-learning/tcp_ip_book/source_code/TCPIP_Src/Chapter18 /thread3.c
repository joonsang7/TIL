#include <stdio.h>
#include <pthread.h>
#define NUM_THREAD 100

void * thread_inc(void * arg);
void * thread_des(void * arg); 
long long num=0;

long long sum=0;

int main(int argc, char *argv[])
{
	pthread_t id_t1, id_t2;
	int range1[]={1, 5};
	int range2[]={6, 10};
	
	pthread_create(&id_t1, NULL, thread_inc, (void *)range1);
	pthread_create(&id_t2, NULL, thread_des, (void *)range2);

	pthread_join(id_t1, NULL);
	pthread_join(id_t2, NULL);
	printf("result: %lld \n", sum);
	return 0;
}

void * thread_inc(void * arg) 
{
	for (int i=0; i<50000000; i++)
	{
		num++;
	}
	pthread_mutex_lock(&mutex);
	
	return NULL;
}


void * thread_des(void * arg) 
{
	int start=((int*)arg)[0];
	int end=((int*)arg)[1];

	while(start<=end)
	{
		sum-=start;
		start++;
	}
	return NULL;
}
