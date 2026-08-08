                    // a, b, c, d, e, f, g, dp
uint8_t fnd_pin[8] = { 2, 3, 4, 5, 6, 7, 8, 9};

uint8_t fnd_data[10] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 
                        0x6D, 0x7D, 0x27, 0x7F, 0x6F};

void fndDisplay(uint8_t num);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

  for(int i=0; i<8; i++){
    pinMode(fnd_pin[i], OUTPUT);
  }
}

void loop() {
  // put your main code here, to run repeatedly:
  for(int i=0; i<10; i++){
    fndDisplay(i);
    delay(500);
  }
}

void fndDisplay(uint8_t num){
  for(int i=0; i<8; i++){
    digitalWrite(fnd_pin[i], bitRead(fnd_data[num],i));
  }
}