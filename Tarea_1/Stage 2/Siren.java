import java.io.File;
import java.net.URL;

public class Siren {
    public Siren (String soundFileName){
        try {
            dir = new File(soundFileName).toURI().toURL();
        }
        catch (Exception exc){
            exc.printStackTrace(System.out);
        }
        isSounding = false;
    }
    public void play(){
        isSounding = true;
        System.out.println("Wiu wiu wiu wiu wiu ...");
        //aWave= new AePlayWave(dir);
        //aWave.start();
    }
    public void stop(){
        isSounding = false;
        //aWave.stopSounding();
    }
    public String getHeader() {
        return "Siren";
    }
    public int getState() {
        return isSounding ? 1 : 0;
    }
    private URL dir;
    private boolean isSounding;
    private AePlayWave aWave;
}
