package com.company;

public class ProgramFirst extends Thread {
    public Main.Conflict bowFirst;
    public Main.Conflict otherBow;

    public ProgramFirst(Main.Conflict bowFirst, Main.Conflict otherBow) {
        this.bowFirst = bowFirst;
        this.otherBow = otherBow;
    }

    @Override
    public void run() {
        this.bowFirst.bow(this.otherBow);
    }
}
