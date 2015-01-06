/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Unit.Measure;
import java.text.DecimalFormat;

/**
 *
 * @author Greg
 */
public class EMeasureFormat {
    
    public static double format(Measure measure,int persision) {
        double number = 0;
        DecimalFormat df;
        switch(persision){
            case 0:
                df = new DecimalFormat("#");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 1:
                df = new DecimalFormat("#.#");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 2:
                df = new DecimalFormat("#.##");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 3:
                df = new DecimalFormat("#.000");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 4:
                df = new DecimalFormat("#.####");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 5:
                df = new DecimalFormat("#.#####");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 6:
                df = new DecimalFormat("#.######");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 7:
                df = new DecimalFormat("#.#######");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 8:
                df = new DecimalFormat("#.########");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
            case 9:
                df = new DecimalFormat("#.#########");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
                break;
        }
        return number;
    }
    
    public static String format(double measure,int persision,boolean sciNotation) {
        String number = "ERROR";
        DecimalFormat df;
        switch(persision){
            case 0:
                if(sciNotation){
                    df = new DecimalFormat("#");
                    number = df.format(measure);
                } else {
                    df = new DecimalFormat("#");
                    number = df.format(measure);
                }
                break;
            case 1:
                if(sciNotation){
                    df = new DecimalFormat("#.#E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.0");
                number = df.format(measure);
                }
                break;
            case 2:
                if(sciNotation){
                    df = new DecimalFormat("#.##E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.00");
                number = df.format(measure);
                }
                break;
            case 3:
                if(sciNotation){
                    df = new DecimalFormat("#.###E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.000");
                number = df.format(measure);
                }
                break;
            case 4:
                if(sciNotation){
                    df = new DecimalFormat("#.####E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.0000");
                number = df.format(measure);
                }
                break;
            case 5:
                if(sciNotation){
                    df = new DecimalFormat("#.#####E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.00000");
                number = df.format(measure);
                }
                break;
            case 6:
                if(sciNotation){
                    df = new DecimalFormat("#.######E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.000000");
                number = df.format(measure);
                }
                break;
            case 7:
                if(sciNotation){
                    df = new DecimalFormat("#.#######E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.0000000");
                number = df.format(measure);
                }
                break;
            case 8:
                if(sciNotation){
                    df = new DecimalFormat("#.########E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.00000000");
                number = df.format(measure);
                }
                break;
            case 9:
                if(sciNotation){
                    df = new DecimalFormat("#.#########E0");
                    number = df.format(measure);
                } else {
                df = new DecimalFormat("#.000000000");
                number = df.format(measure);
                }
                break;
        }
        return number;
    }
}