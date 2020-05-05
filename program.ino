#include <Servo.h>
Servo grapper;
Servo shoulder;
Servo body;

void setup() {
    int SOFT_START_CONTROL_PIN = 12;
    int LOW_LIMIT_TIMEOUT = 2000;
    int HIGH_LIMIT_TIMEOUT = 6000;
    pinMode(SOFT_START_CONTROL_PIN,OUTPUT);
    digitalWrite(SOFT_START_CONTROL_PIN,LOW);
    grapper.attach(4);
    shoulder.attach(3);
    body.attach(3);
    int penisArray[] = {1, 2, 3};
    int penisInt = penisArray[0];


    if(true) {
        int i = 3;
        if(true) {
            int e;
        }
        else {
            int e;
        }
    }
    for(int i = 3; i < 0; i++) {
        i = 3;
        int hejkage = 1;
        hejkage += 1;
    }
    int i = 3;
    switch(i) {
        case 1:
            int ost = 1;
            break;
        case 2:
        default:
            i++;
    }

}

void loop() {
    //CNC(pickupSubjectStart);
    body.write(30);
    shoulder.write(50);
    grapper.write(0);

    delay(500);
    //CNC(openGrapper);
    grapper.write(72);
    shoulder.write(20);

}

int hamseanders(int t) {
    return 0;
}
