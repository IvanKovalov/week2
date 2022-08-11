package com.week2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
// hello ivan 1
public class App 
{
   // final static Logger logger = LoggerFactory.getLogger(App.class);
    static double generalIncrement = 0;
    static double generalMin = 0;
    static double generalMax = 0;
    static String typeFloat = "float";
    static String typeDouble = "double";

    static String PATH = System.getProperty("user.dir") + "/config.properties";

    static Multiply multiply = new Multiply();

    public static void main( String[] args )
    {

        //logger.info("called GetInfo() method");
        getInfo(PATH);
        //logger.info("called createTable() method");
        createTable(args[0]);

    }


    static int[][] createTableInt (int increment, int min, int max) {

        int[][] tableInt = new int[10][max/increment];

        for (int i = 0; i < 10; i += 1){
            int column = 0;
            for (int j = min; j < max; j += increment){
                tableInt [i][column] = multiply.multiplyInt(i,j);
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
                tableDouble [i][column] = multiply.multipleDouble(multiplier,j);
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
                tableFloat[i][column] = multiply.multiplyFloat(multiplier,j);
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
        //logger.info("print int table");
        //logger.info(outResult);
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
        //logger.info("print double table");
        //logger.info(outResult);
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
        //logger.info("print float table");
        //logger.info(outResult);
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

        //logger.info("print first row for table");

        return  stringForReturt;
    }

    static void getInfo (String path) {

        Properties prop = new Properties();
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            prop.load(isr);
        } catch (IOException e) {
            throw new RuntimeException("My message");
        }
       // logger.info("Get info from property file");
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
           // logger.info("Create int table");
        } else if (arg.equals(typeDouble)) {
            double[][]doubleArray = createTableDouble(generalIncrement,generalMin,generalMax);
            String outString = outDouble(doubleArray);
            System.out.print(printFirstRow(generalIncrement,generalMin,(int)generalMax, typeDouble));
            System.out.print(outString);
            //logger.info("Create double table");
        }else if (arg.equals(typeFloat)) {
            float[][] floatArray = createTableFloat((float) generalIncrement, (float) generalMin, (float) generalMax);
            String outString = outFloat(floatArray);
            System.out.print(printFirstRow(generalIncrement,generalMin,(int)generalMax, typeFloat));
            System.out.print(outString);
            //logger.info("Create float table");
        }
    }
}
