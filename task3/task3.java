package PerformanceLabTestTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import static java.util.Objects.*;

public class task3 {
    static double[] intervalSum = new double[16];

    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File(args[0]);
        findFilesInDirectory(dir);
        System.out.println(findIndexOfMax(intervalSum));


    }

    public static void findFilesInDirectory(File folder) throws FileNotFoundException {
        double[] numbers;

        for (File file : requireNonNull(folder.listFiles()))
            if (file.isFile()) {
                numbers = readFiles(file);

                for (int i = 0; i < numbers.length; i++) {
                    intervalSum[i] += numbers[i];
                }
            }
    }

    public static double[] readFiles(File file) throws FileNotFoundException {
        List<String> lines = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = lines.toArray(new String[lines.size()]);

        double[] numbers = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Double.parseDouble(arr[i]);
        }
        return numbers;
    }

    public static int findIndexOfMax(double[] array) {
        double max = array[0];
        int indexOfMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                indexOfMax = i;
            }
        }
        return indexOfMax + 1;
    }
}
