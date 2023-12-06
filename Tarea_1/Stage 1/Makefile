JFLAGS = -g
JC = javac
JVM = java
MAIN = Stage1
FILE = config.txt


CLASSES = \
Stage1.java \
Door.java \
Window.java \
Sensor.java \
State.java \
SwitchState.java \
MagneticSensor.java 




default: compile

compile:
	$(JC) $(JFLAGS) $(CLASSES)

run:
	$(JVM) $(MAIN) $(FILE) 

clean:
	$(RM) *.class