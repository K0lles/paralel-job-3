package com.company;

public class Main {

    public static void main(String[] args) {
        taskSecond();
    }

    public static void taskSecond() {
        Conflict firstConflict = new Conflict("Bower 1");
        Conflict otherConflict = new Conflict("Bower 2");
        ProgramFirst programFirst = new ProgramFirst(firstConflict, otherConflict);
        ProgramTwo programTwo = new ProgramTwo(otherConflict, firstConflict);

        programFirst.start();
        programTwo.start();
    }

    static class Conflict {

        private final String name;
        public static boolean goFurther = false;

        public Conflict (String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Conflict bower) {
            while (goFurther) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            goFurther = true;
            System.out.format("%s: %s" + " skips me !%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Conflict bower) {
            System.out.format("%s: %s" + " skips me in answer!%n", this.name, bower.getName());
            goFurther = false;
            notifyAll();
        }
    }

}
