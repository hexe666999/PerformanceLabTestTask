package PerformanceLabTestTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;

public class task1 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args [0]));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        String [] arr = lines.toArray(new String[lines.size()]);

        int []numbers = new int [arr.length];
        for (int i = 0; i < arr.length; i++){
            numbers [i] = Integer.parseInt(arr[i]);
        }

        System.out.format("%.2f", percentile90(numbers));
        System.out.println();
        System.out.format("%.2f", mediana(numbers));
        System.out.println();
        System.out.format("%.2f", findMax(numbers));
        System.out.println();
        System.out.format("%.2f", findMin(numbers));
        System.out.println();
        System.out.format("%.2f", findAvg(numbers));

    }

    public static double percentile90 (int [] array){
        Arrays.sort(array);
        double n = (double) 90/100*(array.length-1)+1;
        double d = n - (int)n;
        double result = array[(int) n-1] + d * (array[(int) n]- array [(int) n-1]);
        return result;
    }

    public static double mediana(int[] array) {
        double mediana;
        Arrays.sort(array);
        if (array.length % 2 == 1) {
            mediana = array[array.length / 2];
            return mediana;
        } else {
            mediana = (double) (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
            return mediana;
        }
    }

    public static double findMax(int[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static double findMin(int[] array) {
        double min = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static double findAvg(int[] array) {

        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        result = result/ array.length;
        return result;
    }
}
