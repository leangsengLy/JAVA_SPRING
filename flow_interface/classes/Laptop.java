package flow_interface.classes;

import flow_interface.interfaces.Computer;

public class Laptop extends Computer {
    @Override
    public void code() {
       System.out.println("Using Laptop for internship");
    }
}
