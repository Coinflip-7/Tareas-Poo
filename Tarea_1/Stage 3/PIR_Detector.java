public class PIR_Detector {
    public PIR_Detector(double x, double y, double inclinacion, double cono, double rango) {
        this.sensor = new Sensor();
        this.x = x;
        this.y = y;
        this.inclinacion = inclinacion;
        this.cono = cono;
        this.rango = rango;
    }

    {
        id = nextId++;
    }

    public int getState() {
        return Integer.valueOf(sensor.toString());
    }

    public void setState(SwitchState s){
        this.sensor.setState(s);
    }

    public String getHeader() {
        return "Pir" + id;
    }

    public double distancia(Person person) {
        double distance = Math.sqrt(Math.pow(person.getPositionX() - this.x, 2) + Math.pow(person.getPositionY() - this.y, 2));
        return distance;
    }

    private double angulo(Person person){
        double op;
        double hip;
        double angle;
        hip = distancia(person);
        op = Math.sqrt(Math.pow(person.getPositionY() - this.y,2));
        angle = Math.asin(op/hip)*180/Math.PI;
        return angle;
    }
    public void detectar(Person person){
        double distancia;
        double angle,anglemax,anglemin;
        distancia = this.distancia(person);
        if (distancia < this.rango){
            angle = this.angulo(person);
            anglemax = this.inclinacion + (this.cono/2);
            anglemin = this.inclinacion - (this.cono/2);
            if(angle < anglemax && angle > anglemin){
                this.setState(SwitchState.OPEN);
            }
            else 
                this.setState(SwitchState.CLOSE);

        } else 
            this.setState(SwitchState.CLOSE);

    }

    public Sensor getSensor() {
        return this.sensor;
    }

    private double x;
    private double y;
    private double inclinacion;
    private double cono;
    private double rango;
    private Sensor sensor;
    private final int id;
    private static int nextId;
    static {
        nextId = 0;
    }

}