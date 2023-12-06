import java.util.ArrayList;

public class Central {
    public Central() {
        this.zone0 = new ArrayList<Sensor>();
        this.zone1 = new ArrayList<Sensor>();
        this.zone2 = new ArrayList<Sensor>();

        this.isArmed = false;
        this.siren = null;
        this.isReadyArm = true;

        this.z0isClose = 0;
        this.z1isClose = 0;
        this.z2isClose = 0;

    }

    public void arm() {
        if (isReadyArm) {
            this.isPerimetral = true;
            this.isArmed = true;
            System.out.println("Armado");
        } else {
            if (z0isClose != 0)
                System.out.println("Zona 0 abierta");
            if (z1isClose != 0)
                System.out.println("Zona 1 abierta");
            if (z2isClose != 0)
                System.out.println("Hay alguien en la casa");
        }
    }

    public void disarm() {
        this.isPerimetral = false;
        this.isArmed = false;
        this.siren.stop();

    }

    public void perimetral() {
        if (isReadyPer) {
            this.isPerimetral = true;
            this.isArmed = false;
            System.out.println("Perimetro armado");
        } else {
            if (z0isClose != 0)
                System.out.println("Zona 0 abierta");
            if (z1isClose != 0)
                System.out.println("Hay alguien en la casa");
        }

    }

    public void setSiren(Siren s) {
        this.siren = s;
    }

    public void addNewSensorZ0(Sensor s) {
        this.zone0.add(s);
    }

    public void addNewSensorZ1(Sensor s) {
        this.zone1.add(s);
    }

    public void addNewSensorZ2(Sensor s) {
        this.zone2.add(s);
    }

    public void checkZone() {
        this.z0isClose = 0;
        this.z1isClose = 0;
        this.z2isClose = 0;
        this.isReadyArm = true;
        this.isReadyPer = true;
        for (Sensor sensor : this.zone0) {
            if (sensor.toString() == "0") {
                z0isClose++;
            }
        }

        for (Sensor sensor : this.zone1) {
            if (sensor.toString() == "0") {
                z1isClose++;
            }
        }
        for (Sensor sensor : this.zone2) {
            if (sensor.toString() == "0") {
                z2isClose++;

            }
        }

        if (z0isClose != 0 || z1isClose != 0) {
            this.isReadyPer = false;
        }
        if (z0isClose != 0 || z1isClose != 0 || z2isClose != 0) {
            this.isReadyArm = false;
        }

        if (isArmed) {
            if (z0isClose != 0 || z1isClose != 0 || z2isClose != 0)
                this.siren.play();
            else
                this.siren.stop();
        }

        if (isPerimetral) {
            if (z0isClose != 0 || z1isClose != 0)
                this.siren.play();
            else
                this.siren.stop();
        }

    }

    public String getHeader() {
        return "Central";
    }

    public int getState() {
        return this.isArmed ? 1 : 0;
    }

    private ArrayList<Sensor> zone0;
    private ArrayList<Sensor> zone1;
    private ArrayList<Sensor> zone2;
    private int z0isClose;
    private int z1isClose;
    private int z2isClose;
    private boolean isArmed;
    private boolean isPerimetral;
    private boolean isReadyArm;
    private boolean isReadyPer;
    private Siren siren;
}
