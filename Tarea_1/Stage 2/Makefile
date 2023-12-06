JFLAGS = -g
JC = javac
JVM = java
MAIN = Stage2
FILE = config.txt


CLASSES = \
Stage2.java \
Door.java \
Central.java \
Window.java \
Sensor.java \
State.java \
SwitchState.java \
Siren.java\
MagneticSensor.java 




default: compile

compile:
	$(JC) $(JFLAGS) $(CLASSES)

run:
	$(JVM) $(MAIN) $(FILE) 

clean:
	$(RM) *.class