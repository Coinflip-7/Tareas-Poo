public class Window {
    public Window() {
        magneticSensor = new MagneticSensor();
        
    }
    {
        id = nextId++;
    }
    public void open() {
        magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() {
        magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){
        return "w"+id;
    }
    public int getState(){
        if (magneticSensor.getState() == SwitchState.CLOSE)
            return 1;
        else
            return 0;
    }

    private MagneticSensor magneticSensor;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}