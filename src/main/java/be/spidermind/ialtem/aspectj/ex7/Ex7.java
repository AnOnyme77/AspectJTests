package be.spidermind.ialtem.aspectj.ex7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Ex7 {

    private static RandomMatrix asyncMatrix() {
        RandomMatrix mat = new RandomMatrix(200,50);
        mat.longRunningMethod();
        return mat;
    }

    private static void syncMatrix() {
        RandomMatrix mat = new RandomMatrix(150,5000);
        mat.longRunningMethod();
        try {
            System.out.println(mat.avg());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void makeAsyncs() {
        List<RandomMatrix> matrices = new LinkedList<>();

        IntStream.range(0, 10).forEach(i -> matrices.add(asyncMatrix()));

        for (RandomMatrix mat :
                matrices) {
            boolean printed = false;
            while(!printed) {
                try {
                    System.out.println(mat.avg());
                    Thread.sleep(1000);
                    printed = true;
                } catch (Exception e) { }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Sync !");
        syncMatrix();

        System.out.println("\n\nAsync !");
        makeAsyncs();
    }
}
