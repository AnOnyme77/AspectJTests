package be.spidermind.ialtem.aspectj.ex8;

public class Ex8 {
    private static int LAST_ID = 0;

    private int id = ++LAST_ID;
    public int a = 8;
    public int b = 9;
    public String c = "Laurent";

    public int id() {
        return id;
    }

    public static void main(String[] args) {
        Ex8 exo = new Ex8();
        exo.a = 9;

        exo = new Ex8();
        exo.b = 11;

        exo = new Ex8();
        exo.c = "Emilie";
    }
}
