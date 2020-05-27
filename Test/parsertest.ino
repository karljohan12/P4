#include <Servo.h> 
Servo body;
Servo shoulder;
Servo grapper;

const int a = 1;
const int b = 2;
const int c = 3;
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

    body.attach(a);
    shoulder.attach(b);
    grapper.attach(c);






} 

void loop() {
    //CNC(pickupSubjectStart);
    body.write(30);
    shoulder.write(50);
    grapper.write(0);

    delay(5000);
    //CNC(PlaceSubjectCNC);
    body.write(80);
    shoulder.write(30);
    grapper.write(72);

    delay(5000);
    //CNC(Waiting);
    body.write(80);
    shoulder.write(10);
    grapper.write(0);

    delay(2000);
    //CNC(openGrapper);
    grapper.write(72);

    delay(20000);
    //CNC(pickupSubjectCNC);
    body.write(80);
    shoulder.write(30);
    grapper.write(0);

    delay(5000);
    //CNC(HandInSubject);
    body.write(0);
    shoulder.write(30);
    grapper.write(0);

    delay(2000);
} 
