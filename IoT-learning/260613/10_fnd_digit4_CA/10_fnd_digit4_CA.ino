// a, b, c, d, e, f, g, dp
uint8_t fnd_data_pin[8] = {4, 5, 6, 7, 8, 9, 10, 11};
uint8_t fnd_data[10] = {0x3F, 0x06, 0x5B, 0x4F, 0x66,
                        0x6D, 0x7D, 0x27, 0x7F, 0x6F};
// D1,D2, D3, D4
uint8_t fnd_digit_pin[4] = {14, 15, 16, 17};

void fndDisplay(uint8_t num);

void setup()
{
  // put your setup code here, to run once:
  Serial.begin(9600);

  for (int i = 0; i < 8; i++)
  {
    pinMode(fnd_data_pin[i], OUTPUT);
    digitalWrite(fnd_data_pin[i], HIGH);
  }
  for (int i = 0; i < 4; i++)
  {
    pinMode(fnd_digit_pin[i], OUTPUT);
    digitalWrite(fnd_digit_pin[i], LOW);
  }
}

void loop()
{
  // put your main code here, to run repeatedly:
  fndDisplayArray(1234);
}

void fndDisplay(uint8_t num)
{
  for (int i = 0; i < 8; i++)
  {
    digitalWrite(fnd_data_pin[i], !bitRead(fnd_data[num], i));
  }
}

void fndDisplayArray(int number)
{

  int digits[4];
  digits[0] = number / 1000 % 10;
  digits[1] = number / 100 % 10;
  digits[2] = number / 10 % 10;
  digits[3] = number % 10;

  for (int i = 0; i < 4; i++)
  {
    fndDisplay(digits[i]);
    digitalWrite(fnd_digit_pin[i], HIGH);
    delay(5);
    digitalWrite(fnd_digit_pin[i], LOW);
  }
}
