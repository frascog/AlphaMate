/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import java.text.DecimalFormat;
import javax.measure.Measure;

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
                df = new DecimalFormat("#.###");
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
    
}
