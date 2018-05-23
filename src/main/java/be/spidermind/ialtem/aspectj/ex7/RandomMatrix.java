package be.spidermind.ialtem.aspectj.ex7;

import be.spidermind.ialtem.aspectj.ex7.async.LongRunningClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomMatrix implements LongRunningClass {

    private List<List<Integer>> matrix = new LinkedList<>();
    private Float avg = null;


    public RandomMatrix(int nbLines, int nbCols) {
        Random random = new Random();
        for(int i=0; i < nbLines; i++) {
            List<Integer> line = new LinkedList<>();
            for(int j=0; j < nbCols; j++) {
                line.add(random.nextInt());
            }
            matrix.add(line);
        }
    }

    public float avg() throws Exception {
        if(avg == null) {
            throw new Exception("Avg is not yet calculated by longRunningMethod");
        }

        return avg;
    }

    @Override
    public void longRunningMethod() {
        System.out.println("Computing Avg done");
        int nb = 0, acc = 0;
        for (List<Integer> line: matrix){
            for (int i : line) {
                acc += i;
                nb ++;
            }
        }
        avg = ((float) acc/ nb);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avg computation done");
    }
}
