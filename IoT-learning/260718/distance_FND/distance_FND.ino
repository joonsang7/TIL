/*
 초음파 센서로 거리 측정 후 4-digit FND에 표시하기
 - 초음파 센서: A0(Trig), A1(Echo)
 - FND: 2~9번핀(세그먼트 a~g, dot), 10~13번핀(자릿수 선택 Digit1~4)
*/

// 0~9까지 세그먼트 표시를 위한 상수
const byte number[10] = {
  //dot  gfedcba
  B00111111,	//0
  B00000110,	//1
  B01011011,	//2
  B01001111,	//3
  B01100110,	//4
  B01101101,	//5
  B01111101,	//6
  B00000111,	//7
  B01111111,	//8
  B01101111,	//9
};

// 4개의 digit에 연결된 핀 설정
const byte digitNumber[4] = {13, 12, 11, 10};

// 초음파 센서 핀 설정
const int trigPin = A0;
const int echoPin = A1;

// 표시할 값(거리, cm)
int count = 0;

// 각 자릿수를 저장하기 위한 변수
int value[4] = {0, 0, 0, 0};

// 4개의 digit을 순서대로 켜기 위한 변수 (1~4)
int digitSelect = 1;

// 시간 측정용 변수
long sampleTime;
int count5ms;

void setup()
{
  // 2~13번 핀을 a b c d e f g dot / Digit1~4 순서로 사용한다.
  for (int i = 2; i <= 13; ++i) {
    pinMode(i, OUTPUT);
  }

  // 초음파 센서 핀 설정
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);

  // 4 digit 모두 소등 (Digit 핀은 LOW일 때 켜지므로 HIGH로 꺼둔다)
  for (int i = 10; i <= 13; ++i) {
    digitalWrite(i, HIGH);
  }
}

void loop()
{
  // 현재 시간을 저장한다.
  sampleTime = millis();

  // 자릿수를 하나씩 바꿔가며 FND에 출력한다 (멀티플렉싱)
  fndDisplay(digitSelect, value[digitSelect - 1]);
  ++digitSelect;
  if (digitSelect >= 5) digitSelect = 1;

  // 앞서 저장한 시간에서 5ms가 지날 때까지 대기 (멀티플렉싱 주기 유지)
  while (millis() - sampleTime < 5);

  ++count5ms;
  if (count5ms > 200) {
    // 5ms * 200 = 1초 마다 초음파 센서로 거리를 측정한다.
    count = readDistance();

    // 표시 범위(0~9999)를 벗어나면 보정한다.
    if (count > 9999) count = 9999;
    if (count < 0) count = 0;

    // 변수를 각 자릿수로 나눈다
    value[3] = count / 1000;
    value[2] = (count - (value[3] * 1000)) / 100;
    value[1] = (count - (value[3] * 1000) - (value[2] * 100)) / 10;
    value[0] = count - (value[3] * 1000) - (value[2] * 100) - (value[1] * 10);

    count5ms = 0;
  }
}

// 초음파 센서로 거리(cm)를 측정하는 함수
int readDistance()
{
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // 최대 30ms까지만 에코 신호를 기다린다 (약 5m 범위, 타임아웃 방지)
  long duration = pulseIn(echoPin, HIGH, 30000);

  if (duration == 0) return 9999;  // 에코 신호가 없으면(측정 실패) 최대값 표시

  int distance = duration * 0.034 / 2;  // cm 단위로 변환
  return distance;
}

// FND에 한 자릿수를 표시하는 루틴
void fndDisplay(int digit, int displayValue)
{
  boolean bitValue;

  // 세그먼트를 바꾸기 전에 모든 digit을 잠깐 꺼서 잔상(ghosting)을 방지한다.
  for (int i = 1; i <= 4; ++i) {
    digitalWrite(digitNumber[i - 1], HIGH);
  }

  // 표시할 숫자에 해당하는 세그먼트 패턴을 출력한다.
  for (int i = 0; i <= 7; ++i) {
    bitValue = bitRead(number[displayValue], i);
    digitalWrite(i + 2, !bitValue);
  }

  // 4개 digit 중 표시하려는 자릿수만 켠다.
  for (int i = 1; i <= 4; ++i) {
    if (digit == i) digitalWrite(digitNumber[i - 1], HIGH);
    else digitalWrite(digitNumber[i - 1], LOW);
  }
}
