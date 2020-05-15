#include <Servo.h> 
Servo base;
Servo shoulder;
Servo elbow;
Servo wristver;
Servo wristrot;
Servo gripper;

const int i = 0;
void setup() {
    int SOFT_START_CONTROL_PIN = 12;
    int LOW_LIMIT_TIMEOUT = 2000;
    int HIGH_LIMIT_TIMEOUT = 6000;
    pinMode(SOFT_START_CONTROL_PIN,OUTPUT);
    digitalWrite(SOFT_START_CONTROL_PIN,LOW); 
    long int tmp=millis();
    while(millis()-tmp < LOW_LIMIT_TIMEOUT)
        digitalWrite(SOFT_START_CONTROL_PIN,HIGH);
        delayMicroseconds(80);
        digitalWrite(SOFT_START_CONTROL_PIN,LOW);
        delayMicroseconds(450); 
    while(millis()-tmp < HIGH_LIMIT_TIMEOUT)
        digitalWrite(SOFT_START_CONTROL_PIN,HIGH);
        delayMicroseconds(75);
        digitalWrite(SOFT_START_CONTROL_PIN,LOW);
        delayMicroseconds(430); 
    digitalWrite(SOFT_START_CONTROL_PIN,HIGH);

    switch(i) {
        case 1:{
            int e = 3;

            e++;
        }
        case 2:{
            int e = 3;
        }
    }
    int array[] = {1, 3, 5};
    int val1 = 10;
    int val2 = 20;
    int max = val1 >= val2 ? val1 : val2;
    base.attach(11);
    shoulder.attach(10 + i);
    elbow.attach(9);
    wristver.attach(6);
    wristrot.attach(5);
    gripper.attach(3);




} 

void loop() {
    delay(1000);
    //Braccio(standUpright);
    base.write(10);
    shoulder.write(90);
    elbow.write(100);
    wristver.write(100);
    wristrot.write(100);
    gripper.write(60);

    int uy = 34;
    delay(1000);
    //Braccio(Extend);
    base.write(10);
    shoulder.write(90);
    elbow.write(100);
    wristver.write(100);
    wristrot.write(100);
    gripper.write(30);

    delay(3000);
    //Braccio(yr);
    gripper.write(30);
    elbow.write(80);

    testing();
}

bool testing() {
}
