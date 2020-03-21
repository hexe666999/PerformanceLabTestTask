package PerformanceLabTestTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class task2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        float[][] figure = readFiles(file1);
        readFiles(file2);
        float[][] points = readFiles(file2);
        for (int i = 0; i < points.length; i++) {
            System.out.println(check(points[i][0], points[i][1], figure));
        }
    }

    public static float[][] readFiles(File file) throws FileNotFoundException {
        List<Float> x = new ArrayList();
        List<Float> y = new ArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(" ");
                x.add(Float.parseFloat(lines[0]));
                y.add(Float.parseFloat(lines[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        float[][] coordinates = new float[x.size()][2];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] = x.get(i);
            coordinates[i][1] = y.get(i);
        }
        return coordinates;
    }


    public static int check(float x, float y, float[][] figure) {
        if (pointToTop(x, y, figure)) {
            return 0;
        }
        if (pointIntoFigure(x, y, figure)) {
            return 2;
        }
        if (pointOnSides(x, y, figure)) {
            return 1;
        } else {
            return 3;
        }
    }

    public static boolean pointIntoFigure(float x, float y, float[][] figure) {
        if (!pointToRight(x, y, figure[0][0], figure[0][1], figure[1][0], figure[1][1])) {
            return false;
        }
        if (!pointToRight(x, y, figure[1][0], figure[1][1], figure[2][0], figure[2][1])) {
            return false;
        }
        if (!pointToRight(x, y, figure[2][0], figure[2][1], figure[3][0], figure[3][1])) {
            return false;
        }
        if (!pointToRight(x, y, figure[3][0], figure[3][1], figure[0][0], figure[0][1])) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean pointToRight(float x, float y, float x1, float y1, float x2, float y2) {
        return (y1 - y2) * x + (x2 - x1) * y + (x1 * y2 - x2 * y1) < 0;
    }


    public static boolean pointToTop(float x, float y, float[][] figure) {
        for (int i = 0; i < figure.length; i++) {
            if (x == figure[i][0] & y == figure[i][1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOnSide(float x, float y, float x1, float y1, float x2, float y2) {
        float pX = findP(x, x1, x2);
        float pY = findP(y, y1, y2);
        return pX < 1 & pX > 0 & pY < 1 & pY > 0;
    }

    public static boolean pointOnSides(float x, float y, float[][] figure) {
        if (isOnSide(x, y, figure[0][0], figure[0][1], figure[1][0], figure[1][1])) {
            return true;
        }
        if (isOnSide(x, y, figure[1][0], figure[1][1], figure[2][0], figure[2][1])) {
            return true;
        }
        if (isOnSide(x, y, figure[2][0], figure[2][1], figure[3][0], figure[3][1])) {
            return true;
        }
        if (isOnSide(x, y, figure[3][0], figure[3][1], figure[0][0], figure[0][1])) {
            return true;
        } else {
            return false;
        }
    }

    public static float findP(float c, float c1, float c2) {
        if (c2 == c1) {
            if (c == c1) {
                return 0.5f;
            } else {
                return 2.0f;
            }
        } else {
            return (c - c2) / (c1 - c2);
        }
    }
}
