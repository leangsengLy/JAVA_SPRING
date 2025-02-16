package flow_interface.main;

import flow_interface.classes.Desktop;
import flow_interface.classes.Developer;
import flow_interface.classes.Laptop;
import flow_interface.interfaces.Computer;

public class Main {
    public static void main(String[] args) {
        Computer des = new Desktop();
        Computer lap = new Laptop();
        Developer lyzee = new Developer();
        lyzee.displayDev(lap);
    }
}
