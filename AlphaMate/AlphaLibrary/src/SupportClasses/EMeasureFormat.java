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
        switch(persision){
            case 0:
                DecimalFormat df = new DecimalFormat("#");
                number = Double.parseDouble(df.format(measure.doubleValue(measure.getUnit())));
        }
        return number;
    }
    
}
