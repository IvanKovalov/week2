package com.week2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
    static String typeFloat = "float";
    static String typeDouble = "double";


    public static void main( String[] args )
    {

        getInfo();

        createTable(args[0]);


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

    static String out (int[][] array){
        String outResult = "";

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult = outResult + i + " ";
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult = outResult + array[i][j]+ " ";
            }
            outResult = outResult + " \n";
        }
        return outResult;
    }

    static String outDouble (double[][] array){
        String outResult = "";

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult = outResult + i + " ";
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult = outResult + array[i][j]+ " ";
            }
            outResult = outResult + " \n";
        }
        return outResult;
    }

    static String outFloat (float[][] array){
        String outResult = "";

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult = outResult + i + " ";
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult = outResult + array[i][j]+ " ";
            }
            outResult = outResult + " \n";
        }
        return outResult;

    }

    static String printFirstRow(double increment, double min, int max, String format){
        String stringForReturt = " ";

        for (int i = 0; i < max/increment; i++){
            if (Objects.equals(format, "int")){

                stringForReturt = stringForReturt + (int)min + " ";
            } else if (Objects.equals(format, typeDouble)) {

                stringForReturt = stringForReturt + min + " ";
            } else if (Objects.equals(format, typeFloat)) {

                stringForReturt = stringForReturt + min + " ";
            }

            min += increment;
        }
        stringForReturt = stringForReturt + "\n";

        return  stringForReturt;
    }

    static void getInfo () {

        Properties prop = new Properties();
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(System.getProperty("user.dir") + "/config.properties"), StandardCharsets.UTF_8)) {
            prop.load(isr);
        } catch (IOException e) {
            throw new RuntimeException("My message");
        }
        generalIncrement = Double.parseDouble(prop.getProperty("increment"));
        generalMin = Double.parseDouble(prop.getProperty("min"));
        generalMax = Double.parseDouble(prop.getProperty("max"));

    }

    static void createTable (String arg){
        if(arg.equals("int")){
            int[][] intArray = createTableInt((int)generalIncrement, (int)generalMin,(int)generalMax);
            String outString = out(intArray);
            System.out.print(printFirstRow(generalIncrement,generalMin,(int)generalMax, "int"));
            System.out.print(outString);
        } else if (arg.equals(typeDouble)) {
            double[][]doubleArray = createTableDouble(generalIncrement,generalMin,generalMax);
            String outString = outDouble(doubleArray);
            System.out.print(printFirstRow(generalIncrement,generalMin,(int)generalMax, typeDouble));
            System.out.print(outString);
        }else if (arg.equals(typeFloat)) {
            float[][] floatArray = createTableFloat((float) generalIncrement, (float) generalMin, (float) generalMax);
            String outString = outFloat(floatArray);
            System.out.print(printFirstRow(generalIncrement,generalMin,(int)generalMax, typeFloat));
            System.out.print(outString);
        }
    }
}
