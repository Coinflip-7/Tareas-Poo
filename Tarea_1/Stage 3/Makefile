JFLAGS = -g
JC = javac
JVM = java
MAIN = Stage3
FILE = config.txt


CLASSES = \
Stage3.java \
Door.java \
Window.java \
Sensor.java \
State.java \
SwitchState.java \
Siren.java\
AePlayWave.java \
Central.java \
Person.java \
PIR_Detector.java \
MagneticSensor.java 




default: compile

compile:
	$(JC) $(JFLAGS) $(CLASSES)

run:
	$(JVM) $(MAIN) $(FILE) 

clean:
	$(RM) *.class