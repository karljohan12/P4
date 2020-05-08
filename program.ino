#include <Servo.h> 
Servo base;
Servo shoulder;
Servo elbow;
Servo wristver;
Servo wristrot;
Servo gripper;

int i = 0;
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

    base.attach(11);
    shoulder.attach(AST.NonAbstract.Node.PlusExpression@574caa3f);
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

    delay(1000);
    //Braccio(Extend);
    base.write(10);
    shoulder.write(90);
    elbow.write(100);
    wristver.write(100);
    wristrot.write(100);
    gripper.write(30);

} 
