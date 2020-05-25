#include <Servo.h> 

String i = "hamse";
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

}

void loop() {
} 
