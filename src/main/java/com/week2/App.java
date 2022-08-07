package com.week2;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    static double generalIncrement = 0;
    static double generalMin = 0;
    static double generalMax = 0;


    public static void main( String[] args )
    {
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);

        getInfo();

        if(args[0].equals("int")){
            int[][] intArray = createTableInt((int)generalIncrement, (int)generalMin,(int)generalMax);
            String outString = out(intArray);
            printFirstRow(generalIncrement,generalMin,(int)generalMax, "int");
            System.out.print(outString);
       } else if (args[0].equals("double")) {
            double[][]doubleArray = createTableDouble(generalIncrement,generalMin,generalMax);
            String outString = outDouble(doubleArray);
            printFirstRow(generalIncrement,generalMin,(int)generalMax, "double");
            System.out.print(outString);
        }else if (args[0].equals("float")) {
            float[][] floatArray = createTableFloat((float) generalIncrement, (float) generalMin, (float) generalMax);
            String outString = outFloat(floatArray);
            printFirstRow(generalIncrement,generalMin,(int)generalMax, "float");
            System.out.print(outString);
        }


    }


    static int[][] createTableInt (int increment, int min, int max) {

        int[][] tableInt = new int[10][max/increment];

        for (int i = 0; i < 10; i += 1){
            int column = 0;
            for (int j = min; j < max; j += increment){
                tableInt [i][column] = i*j;
                column ++;

            }

        }

        return tableInt;
    }
    static double[][] createTableDouble(double increment,double min, double max) {

        int lengthOfArray2 = (int)max/(int)increment;
        double[][] tableDouble = new double[10][lengthOfArray2];

        for (int i = 0; i < 10; i += 1){
            int column = 0;
            for (double j = min; j < max; j += increment){
                double multiplier = i;
                tableDouble [i][column] = multiplier*j;
                column ++;
            }
        }

        return  tableDouble;
    }


    static float[][] createTableFloat(float increment,float min, float max) {

        int lengthOfArray2 = (int)max/(int)increment;
        float[][] tableFloat = new float[10][lengthOfArray2];

        for (int i = 0; i < 10; i += 1){
            int column = 0;
            for (float j = min; j < max; j += increment){
                float multiplier = i;
                tableFloat[i][column] = multiplier*j;
                column ++;
            }
        }

        return  tableFloat;
    }

    static String out (int[][] Array){
        String outResult = "";

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult = outResult + i + " ";
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult = outResult + Array[i][j]+ " ";
            }
            outResult = outResult + " \n";
        }
        return outResult;
    }

    static String outDouble (double[][] Array){
        String outResult = "";

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult = outResult + i + " ";
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult = outResult + Array[i][j]+ " ";
            }
            outResult = outResult + " \n";
        }
        return outResult;
    }

    static String outFloat (float[][] Array){
        String outResult = "";

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult = outResult + i + " ";
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult = outResult + Array[i][j]+ " ";
            }
            outResult = outResult + " \n";
        }
        return outResult;

    }

    static String printFirstRow(double increment, double min, int max, String format){
        String stringForReturt = " ";
        System.out.print("  ");
        for (int i = 0; i < max/increment; i++){
            if (Objects.equals(format, "int")){
                System.out.print((int)min + " ");
                stringForReturt = stringForReturt + (int)min + " ";
            } else if (Objects.equals(format, "double")) {
                System.out.print(min + " ");
                stringForReturt = stringForReturt + min + " ";
            } else if (Objects.equals(format, "float")) {
                System.out.print((float)min + " ");
                stringForReturt = stringForReturt + min + " ";
            }

            min += increment;
        }

        System.out.println("");
        return  stringForReturt;
    }

    static void getInfo () {

        Properties prop = new Properties();
        try {
            prop.load(new InputStreamReader(new FileInputStream(System.getProperty("user.dir") + "/config.properties"), Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        generalIncrement = Double.parseDouble(prop.getProperty("increment"));
        generalMin = Double.parseDouble(prop.getProperty("min"));
        generalMax = Double.parseDouble(prop.getProperty("max"));

    }
}
