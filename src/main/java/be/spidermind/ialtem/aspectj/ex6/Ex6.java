package be.spidermind.ialtem.aspectj.ex6;

public class Ex6 {
    private int nb;

    public Ex6() {
        nb = 0;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public static void main(String[] args) {
        /**
         * Please note that first set is made by Java while setting integer default value !
         */


        Ex6 ex = new Ex6();
        System.out.println("Construction finished");
        ex.setNb(1);
        System.out.println(ex.getNb());
        ex.nb = 2;
        System.out.println(ex.getNb());
        System.out.println(ex.nb);
    }
}
