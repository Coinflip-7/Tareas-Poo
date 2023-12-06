public class Door {
    public Door () {
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
        return "d"+id;
    }
    public int getState(){
        return Integer.valueOf(magneticSensor.toString());
    }

    private MagneticSensor magneticSensor;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }
}
