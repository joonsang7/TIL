void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600, SERIAL_8N1);
  pinMode(13, OUTPUT);
}

String buffer = "";

void loop() {
  if (Serial.available() > 0) {
    char c = Serial.read();
    
    if (c == '\n' || c == '\r') {
      Serial.print("받은 문자 : ");
      Serial.println(buffer);  

      if(buffer == "led on"){ digitalWrite(13, HIGH); }
      else if (buffer == "led off") { digitalWrite(13, LOW); }
      buffer = "";  
      
    } else {
      buffer += c;  
    }
  }
}

