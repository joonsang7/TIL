void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); // 통신 속도 9600으로 맞추겠다는 의미
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println("hello world");
  delay(4000);
}
