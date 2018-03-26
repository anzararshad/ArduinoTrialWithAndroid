#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>
// Set these to run example.

#define FIREBASE_HOST ""

#define FIREBASE_AUTH ""

#define WIFI_SSID ""

#define WIFI_PASSWORD ""

#define LED 2

int LEDD =15;

void setup() {
pinMode(LEDD, OUTPUT);


Serial.begin(9600);

WiFi.begin(WIFI_SSID, WIFI_PASSWORD);

Serial.print("connecting");

while (WiFi.status() != WL_CONNECTED) {

Serial.print(".");

delay(500);

}

Serial.println();

Serial.print("connected: ");

Serial.println(WiFi.localIP());

Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);



Firebase.setInt("state",0);



}

void loop() {

if(Firebase.getInt("state"))

{
digitalWrite(LEDD,HIGH);
delay(100);


}
else

{


digitalWrite(LEDD,LOW);
delay(100);


}


if (Firebase.failed()) // Check for errors {

Serial.print("setting /number failed:");

Serial.println(Firebase.error());

return;



delay(1000);

}
