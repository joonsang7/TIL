const int motorPin[4] = {8, 9, 10, 11};

void setup() {
  // put your setup code here, to run once:
  for(int i =0; i<4; i++){
    pinMode(motorPin[i], OUTPUT);
  }

  Serial.begin(9600);
}

void loop() {
  int adcValue = analogRead(A0);
  int delay_val = map(adcValue, 0, 1023, 1600, 3000);
  Serial.println(delay_val);

 for(int i = 0; i < 4; i++){
    for(int j = 0; j < 4; j++){
       if(i == j) digitalWrite(motorPin[j],HIGH)
       else digitalWrite(motorPin[j],LOW);   
    }  
    delayMicroseconds(delay_val);
}
}
