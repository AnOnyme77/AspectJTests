package be.spidermind.ialtem.aspectj.dummy;

public aspect Tracing {
    static int indent=0;

    static private String spaces(int n){
        StringBuffer s=new StringBuffer(); for (int i=0;i<n;i++)
        s.append(' '); return s.toString();
    }

    pointcut toBeTraced(int a):
            call( public static int Hello.factorial(int) ) && args(a);

    int around(int a): toBeTraced( a) {
        int local=indent++;
        System.out.printf("%s call(%d)\n", spaces(local), a);
        int r=proceed(a);
        System.out.printf("%s call(%d)=%d\n", spaces(local), a,r); indent--;
        return r;
    }
}
