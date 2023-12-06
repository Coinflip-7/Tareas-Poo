public class Door {
    public Door () {
        this.magneticSensor = new MagneticSensor();
    }
    {
        id = nextId++;
    }
    public void open() {
        this.magneticSensor.moveMagnetAwayFromSwitch();
    }
    public void close() {
        this.magneticSensor.putMagnetNearSwitch();
    }
    public String getHeader(){
        return "d"+ id;
    }
    public int getState(){
        return Integer.valueOf(magneticSensor.toString());
    }
    public MagneticSensor getSensor(){
        return this.magneticSensor;
    }

    private MagneticSensor magneticSensor;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}
