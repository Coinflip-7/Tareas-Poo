import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stage3 {
    public Stage3() {
        doors = new ArrayList<Door>();
        windows = new ArrayList<Window>();
        persons = new ArrayList<Person>();
        pirs = new ArrayList<PIR_Detector>();
    }
    public void readConfiguration(Scanner in){
        // reading <#_doors> <#_windows> <#_PIRs>
        central = new Central();
        int numDoors = in.nextInt();
        for (int i = 0; i < numDoors; i++) {
            Door d = new Door();
            doors.add(d);
            central.addNewSensor(d.getSensor());
        }
        int numWindows = in.nextInt();
        for (int i = 0; i < numWindows; i++) {
            Window w = new Window();
            windows.add(w);
            central.addNewSensor(w.getSensor());
        }
        int numPirs = in.nextInt();
        
        for (int i = 0; i < numPirs; i++) {
            double x = Double.parseDouble(in.next());
            double y = Double.parseDouble(in.next());
            double inclinacion = in.nextDouble();
            double cono = in.nextDouble();
            double rango = in.nextDouble();
            PIR_Detector p = new PIR_Detector(x, y, inclinacion, cono, rango);
            pirs.add(p);
            central.addNewSensor(p.getSensor());
           
        }
     
        
        in.nextLine();
        String soundFile = in.next();
        siren = new Siren(soundFile);
        central.setSiren(siren);
        in.close();
    }
    public void executeUserInteraction (Scanner in, PrintStream out){
        String command;
        char parameter;
        int i;
        int step=0;
        printHeader(out);
        while (true) {
            printState(step++, out);
            command = in.next();
            if (command.charAt(0)=='x') break;
            switch (command.charAt(0)) {
                case 'd':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter== 'o')
                        doors.get(i).open();
                    else
                        doors.get(i).close();
                    break;
                case 'w':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    if (parameter== 'o')
                        windows.get(i).open();
                    else
                        windows.get(i).close();                   
                    break;
                case 'k':
                    parameter = in.next().charAt(0);
                    switch (parameter) {
                        case 'a':
                            central.arm();
                            break;
                        case 'd':
                            central.disarm();
                            break;
                    }
                    break;
                case 'c':                
                    double x = Double.parseDouble(in.next()); /*c x y */
                    double y = Double.parseDouble(in.next());/* 12345  */
                    Person p = new Person(x, y);
                    persons.add(p);
                    for (int idx=0; idx < pirs.size(); idx++)
                        pirs.get(idx).detectar(p);
                    break; 

                case 'p':
                    i = Integer.parseInt(command.substring(1));
                    parameter = in.next().charAt(0);
                    switch (parameter) {
                        case 'w':
                            persons.get(i).upMove();
                            break;
                        case 'a':
                            persons.get(i).leftMove();
                            break;
                        case 's':
                            persons.get(i).downMove();
                            break;
                        case 'd':
                            persons.get(i).rightMove();
                            break;
                    }
                    for (int idx=0; idx < pirs.size(); idx++)
                        pirs.get(idx).detectar(persons.get(i));             
                    
                    
            }


            central.checkZone();
        }
    }
    /* public void printHeader(PrintStream out){
        out.print("Step");
        for (int i=0; i < doors.size(); i++)
            out.print("\t" + doors.get(i).getHeader());
        for (int i=0; i < windows.size(); i++)
            out.print("\t" + windows.get(i).getHeader());
        for (int i=0; i < pirs.size(); i++)
            out.print("\t" + pirs.get(i).getHeader());
        out.print("\t" + siren.getHeader());
        out.print("\t" + central.getHeader());
        out.println();
        
    }
    public void printState(int step, PrintStream out){
        out.print(step);
        for (int i=0; i < doors.size(); i++)
            out.print("\t" + doors.get(i).getState());
        for (int i=0; i < windows.size(); i++)
            out.print("\t" + windows.get(i).getState());
        for (int i=0; i < pirs.size(); i++)
            out.print("\t" + pirs.get(i).getState());    
        out.print("\t  " + siren.getState());
        out.print("\t  " + central.getState());
        for (int i=0; i < persons.size(); i++)
            out.print("\t  " + persons.get(i).getPositionX()+ " " + persons.get(i).getPositionY());
       
        out.println();
    } */


    public void printHeader(PrintStream out){
        out.print("Step");
        for (int i=0; i < doors.size(); i++)
            out.print("\t" + doors.get(i).getHeader());
        for (int i=0; i < windows.size(); i++)
            out.print("\t" + windows.get(i).getHeader());
        for (int i=0; i < pirs.size(); i++)
            out.print("\t" + pirs.get(i).getHeader());
        out.print("\t" + siren.getHeader());
        out.print("\t" + central.getHeader());
        out.println();

    }
    public void printState(int step, PrintStream out){
        out.print(step+"\t");
        for (int i=0; i < doors.size(); i++)
            out.print("\t" + doors.get(i).getState());
        for (int i=0; i < windows.size(); i++)
            out.print("\t" + windows.get(i).getState());
        for (int i=0; i < pirs.size(); i++)
            out.print("\t" + pirs.get(i).getState());
        out.print("\t  "+"\t" + siren.getState());
        out.print("\t  "+"\t" + central.getState());
        for (int i=0; i < persons.size(); i++)
            out.print("\t  "+"\t " + persons.get(i).getPositionX()+ " " + persons.get(i).getPositionY());

        out.println();
    }
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage1 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        //System.out.println("File: " + args[0]);
        Stage3 stage = new Stage3();
        stage.readConfiguration(in);
        stage.executeUserInteraction(new Scanner(System.in), new PrintStream(new File("output.csv")));
    }

    private ArrayList<Door> doors;
    private ArrayList<Window> windows;
    private ArrayList<Person> persons;
    private ArrayList<PIR_Detector> pirs;
    private Central central;
    private Siren siren;
}
