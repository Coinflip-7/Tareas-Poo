public class Sensor {
    public Sensor(){
        this(SwitchState.CLOSE);
    }
    public Sensor(SwitchState s){
        this.state = s;
    }
    public SwitchState getState(){
        return this.state;
    }
    protected void setState(SwitchState s) {
        this.state = s;
    }
    public String toString(){
        if (state== SwitchState.CLOSE)
            return "1";
        else
            return "0";
    }
    private SwitchState state;
}
