
int inputPin = 7;     // 센서 신호핀
int buzzerPin = 10;   // 부저핀 추가
int pirState = LOW;   
int val = 0;          // 센서 신호의 판별을 위한 번수

void setup(){
  pinMode(inputPin, INPUT);
  pinMode(buzzerPin, OUTPUT);    
  Serial.begin(9600);
}

void loop(){
  val = digitalRead(inputPin);   

  if (val == HIGH) {          
    tone(buzzerPin, 1000, 1500); 
    delay(3000);                 
    
    if (pirState == LOW){
      Serial.println("low -> high");
      pirState = HIGH;
    }
  }
  else {                        
    delay(3000);                 
    
    if (pirState == HIGH){
      Serial.println("high -> low");
      pirState = LOW;
    }
  }
}