import java.util.ArrayList;

public class Central {
    public Central(){
        this.zone0 = new ArrayList<Sensor>();
        this.isArmed = false;
        this.siren = null;
    }
    public void arm() {
        this.isArmed = true;
    }
    public void disarm() {
        this.isArmed = false;
    }
    public void setSiren(Siren s) {
        this.siren = s;
    }
    public void addNewSensor(Sensor s){
        this.zone0.add(s);
    }
    public void checkZone(){
        if(this.isArmed) {
            for (Sensor sensor : zone0) {
                if(sensor.toString() == "0"){
                    this.siren.play();
                    break;
                }
                else 
                    this.siren.stop();
            }
        }
    }
    public String getHeader(){
        return "Central";
    }
    public int getState(){
        return this.isArmed ? 1 : 0;
    }
    private ArrayList<Sensor> zone0;
    private boolean isArmed;
    private Siren siren;
}
