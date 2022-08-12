package com.week2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
// hello ivan 1
public class App 
{
    static final Logger logger = Logger.getLogger(App.class.getName());
    static double generalIncrement = 0;
    static double generalMin = 0;
    static double generalMax = 0;
    static String typeFloat = "float";
    static String typeDouble = "double";

    static String path = System.getProperty("user.dir") + "/config.properties";

    static Multiply multiply = new Multiply();

    static Handler consoleHandler = null;
    static Handler fileHandler  = null;

    public static void main( String[] args )
    {
        try{
            //Creating consoleHandler and fileHandler
            consoleHandler = new ConsoleHandler();
            fileHandler  = new FileHandler("./javacodegeeks.log");
            //Assigning handlers to LOGGER object
            logger.addHandler(consoleHandler);
            logger.addHandler(fileHandler);
            //Setting levels to handlers and LOGGER
            logger.removeHandler(consoleHandler);
        }catch(IOException exception){
            logger.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }

        logger.info("called GetInfo() method");
        getInfo(path);
        logger.info("called createTable() method");
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
        StringBuilder outResult = new StringBuilder("");

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult.append(i + " ");
            for (int j = 0; j < amountOfColumn; j += 1) {
                outResult.append(array[i][j] + " ");
            }
            outResult.append(" \n");
        }
        logger.info("print int table");

        return outResult.toString();
    }

    static String outDouble (double[][] array){
        StringBuilder outResult = new StringBuilder("");

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult.append(i + " ");
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult.append(array[i][j]+ " ");
            }
            outResult.append(" \n");
        }
        logger.info("print double table");
        return outResult.toString();
    }

    static String outFloat (float[][] array){
        StringBuilder outResult = new StringBuilder("");

        int amountOfColumn = (int)generalMax/(int)generalIncrement;

        for (int i = 0; i < 10; i += 1){
            outResult.append(i + " ");
            for (int j = 0; j < amountOfColumn; j += 1){
                outResult.append(array[i][j]+ " ");
            }
            outResult.append(" \n");
        }
        logger.info("print float table");

        return outResult.toString();

    }

    static String printFirstRow(double increment, double min, int max, String format){
        StringBuilder outResult = new StringBuilder(" ");

        for (int i = 0; i < max/increment; i++){
            if (Objects.equals(format, "int")){

                outResult.append((int)min + " ");
            } else if (Objects.equals(format, typeDouble)) {

                outResult.append(min + " ");
            } else if (Objects.equals(format, typeFloat)) {

                outResult.append(min + " ");
            }

            min += increment;
        }

        outResult.append("\n");
        logger.info("print first row for table");

        return  outResult.toString();
    }

    static void getInfo (String path) {

        Properties prop = new Properties();
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)) {
            prop.load(isr);
        } catch (IOException e) {
            throw new RuntimeException("My message");
        }
        logger.info("Get info from property file");
        generalIncrement = Double.parseDouble(prop.getProperty("increment"));
        generalMin = Double.parseDouble(prop.getProperty("min"));
        generalMax = Double.parseDouble(prop.getProperty("max"));

    }

    static void createTable (String arg){
        if(arg.equals("int")){
            int[][] intArray = createTableInt((int)generalIncrement, (int)generalMin,(int)generalMax);
            logger.info("Create int table");
            StringBuilder sb = new StringBuilder("\n" + printFirstRow(generalIncrement,generalMin,(int)generalMax, "int") + out(intArray));
            logger.log(Level.INFO,"{0}", sb);

        } else if (arg.equals(typeDouble)) {
            double[][]doubleArray = createTableDouble(generalIncrement,generalMin,generalMax);
            logger.info("Create double table");
            StringBuilder sb = new StringBuilder("\n" + printFirstRow(generalIncrement,generalMin,(int)generalMax, typeDouble) + outDouble(doubleArray));
            logger.log(Level.INFO,"{0}", sb);

        }else if (arg.equals(typeFloat)) {
            float[][] floatArray = createTableFloat((float) generalIncrement, (float) generalMin, (float) generalMax);
            logger.info("Create float table");
            StringBuilder sb = new StringBuilder("\n " + printFirstRow(generalIncrement,generalMin,(int)generalMax, typeFloat) + outFloat(floatArray));
            logger.log(Level.INFO,"{0}", sb);

        }
    }
}
