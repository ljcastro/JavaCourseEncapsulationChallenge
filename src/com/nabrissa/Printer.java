package com.nabrissa;

/**
 * Created by lucasjcastro on 26/2/17.
 */
public class Printer {

    private String name;
    private double tonerLevel = 100;
    private int pagesPrinted = 0;
    private boolean duplex;
    private int paperUsed = 0;


    public Printer(String name, double tonerLevel, boolean duplex) {
        this.name = name;
        if (tonerLevel >= 0 || tonerLevel <=100) {
            this.tonerLevel = tonerLevel;
        }
        this.duplex = duplex;
    }

    public void addToner(int addToner) {
        if (addToner < 0) {
            System.out.println("You cannot use a negative number for adding toner!");
            return;
        }

        if (this.tonerLevel == 100) {
            System.out.println("You cannot add toner at this moment. The printer is at 100% level.");
            return;
        }

        double validToner = this.tonerLevel + addToner;
        if (validToner <= 100) {
            System.out.println("Adding " + addToner + "% toner to the printer.");
            this.tonerLevel = validToner;
        } else {
            System.out.println("You cannot add " + addToner + "% toner.");
            System.out.println("The printer has actually " + this.tonerLevel + "% of toner.");
            System.out.println("Add up to " + (100 - this.tonerLevel) + "% for refill.");
        }
    }

    public void printPages(int pages, boolean duplex){
        if (pages <= 0) {
            System.out.println("Input a correct number of pages (maybe greater than 0?)");
            return;
        }

        if (this.tonerLevel <= 0 || updateTonerLevel(pages) <= 0) {
            System.out.println("Insufficient toner for that number of pages (" + pages + ").");
            System.out.println("Please add more toner to the printer.");
            return;
        }

        if (duplex == true && this.duplex == true) {
            System.out.println("Printing " + pages + " pages using duplex mode.");
            this.pagesPrinted += pages;
            this.paperUsed += updatePaperUsed(pages, true);
        } else if (duplex == false) {
            System.out.println("Printing " + pages + " pages");
            this.pagesPrinted += pages;
            this.paperUsed += updatePaperUsed(pages, false);
        } else {
            System.out.println("Your Printer is not duplex capable.");
            System.out.println("Printing " + pages + " pages");
            this.pagesPrinted += pages;
            this.paperUsed += updatePaperUsed(pages, false);
        }
        this.tonerLevel = updateTonerLevel(pages);
    }

    private double updateTonerLevel (int pages) {
        double newTonerLevel = this.tonerLevel - (pages * 0.2);
        return newTonerLevel;
    }

    private int updatePaperUsed(int pages, boolean duplex) {
        if (duplex == true) {
            return ((pages / 2) + (pages % 2));
        } else {
            return (pages);
        }
    }

    public void printerStatus() {
        System.out.println("---------------------------------------------");
        System.out.println("Printer: " + getName());
        System.out.println("Pages printed: " + getPagesPrinted());
        System.out.println("Paper used: " + getPaperUsed());
        System.out.println("Actual Toner Level: " + getTonerLevel() + "%");
        System.out.println("---------------------------------------------");
    }

    public String getName() {
        return name;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public int getPaperUsed() {
        return paperUsed;
    }
}
