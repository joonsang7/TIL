#include <Servo.h>

Servo motor1;

#define servoMotorPin 9

void setup() {
  // put your setup code here, to run once:
  motor1.attach(servoMotorPin, 490, 2450);
  motor1.write(90);
}

void loop() {
  motor1.write(0); // 각도 의미
  delay(1000);
   motor1.write(90); // 각도 의미
  delay(1000);
   motor1.write(180); // 각도 의미
  delay(1000);

}
