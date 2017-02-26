package com.nabrissa;

public class Main {

    public static void main(String[] args) {

        // Create a class and demonstrate proper encapsulation techniques
        // The class will be called Printer
        // It will simulate a real computer printer
        // It should have fields for the toner level, number of pages printed,
        // and also whether its a duplex printer (capable of printing on both sides
        // of the paper
        // Add methods to fill up the toner (up to a maximum of 100%), another method
        // to simulate printing a page (which should increase the number of pages printed)
        // Decide on the scope, whether to use constructors, and anything else you think is needed

        Printer printer = new Printer("HP LaserJet 6P", 70, true);

        System.out.println("Printer: " + printer.getName());
        System.out.println("Actual Toner Level: " + printer.getTonerLevel() + "%");
        System.out.println("---------------------------------------------");
        printer.addToner(50);
        System.out.println("---------------------------------------------");
        printer.addToner(20);
        printer.printerStatus();
        printer.printPages(25,true);
        printer.printerStatus();
        printer.printPages(10,false);
        printer.printerStatus();
        printer.printPages(200,true);
        printer.printerStatus();
        printer.printPages(300,true);
        printer.printerStatus();
        printer.addToner(60);
        printer.printerStatus();

    }
}
