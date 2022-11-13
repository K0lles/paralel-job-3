package com.company;

public class ProgramTwo extends Thread {
    public Main.Conflict firstBow;
    public Main.Conflict otherBow;

    public ProgramTwo(Main.Conflict firstBow, Main.Conflict otherBow) {
        this.firstBow = firstBow;
        this.otherBow = otherBow;
    }

    @Override
    public void run() {
        this.firstBow.bow(this.otherBow);
    }

}
