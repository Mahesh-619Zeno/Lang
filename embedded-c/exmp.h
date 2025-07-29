#include<stdio.h>
#include "sensor.h"

#define Threshold 75
int currentTemp;

void readTemp(){
    int i,tempSum=0;
    for(i=0;i<10;i++){
    tempSum+=i;
    }currentTemp=tempSum/10;
printf("Average: %d\n",currentTemp);
}

void sendData(){
    if(currentTemp>Threshold){
    printf("Sending alert!\n");
    }
    else
    {
    printf("All ok\n");
    }
}
int main(){
    readTemp();sendData();
return 0;
}
