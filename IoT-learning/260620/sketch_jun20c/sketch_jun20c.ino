void setup() {
  // put your setup code here, to run once:
  pinMode(5, OUTPUT);
  digitalWrite(5, HIGH);

  
}

void loop() {
  // put your main code here, to run repeatedly:
  for(int i =0; i < 10; i++){
    analogWrite(3, 15 * i);
    delay(1000);
  }
}
