package PerformanceLabTestTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class task4 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        int[][] visitTimes = readFiles(file);
        int[] visitCrossings = new int[1440];
        for (int i = 0; i < visitTimes.length; i++) {
            for (int j = visitTimes[i][0]; j < visitTimes[i][1]; j++) {
                visitCrossings[j]++;
            }
        }
        int max = findMax(visitCrossings);
        for (int i = 1; i < visitCrossings.length; i++) {

            if (visitCrossings[i] == max) {
                if (visitCrossings[i - 1] != max) {
                    int hour = i / 60;
                    int minutes = i - (hour * 60);
                    System.out.print(hour + ":" + minutes + " ");
                }
            }
            if (visitCrossings[i] != max) {
                if (visitCrossings[i - 1] == max) {
                    int hour = i / 60;
                    int minutes = i - (hour * 60);
                    if (minutes < 10) {
                        System.out.println(hour + ":0" + minutes + " ");
                    } else {
                        System.out.println(hour + ":" + minutes + " ");
                    }
                }
            }
        }
    }

    public static int[][] readFiles(File file) throws FileNotFoundException {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(" ");
                String[] tempLine = lines[0].split(":");
                int minutes = (Integer.parseInt(tempLine[0])) * 60 + Integer.parseInt(tempLine[1]);
                x.add(minutes);
                String[] tempLine2 = lines[1].split(":");
                int minutes2 = (Integer.parseInt(tempLine2[0])) * 60 + Integer.parseInt(tempLine2[1]);
                y.add(minutes2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[][] time = new int[x.size()][2];
        for (int i = 0; i < time.length; i++) {
            time[i][0] = x.get(i);
            time[i][1] = y.get(i);
        }
        return time;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}
