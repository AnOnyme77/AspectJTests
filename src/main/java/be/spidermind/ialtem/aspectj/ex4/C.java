package be.spidermind.ialtem.aspectj.ex4;

public class C {
    public int m(int n) {
        if (n == 2) {
            return 2;
        } else {
            return n * m(n - 1);
        }
    }

    public static void main(String[] args) {
        C o = new C();
        System.out.println(o.m(2));
        System.out.println(o.m(5));
    }
}
