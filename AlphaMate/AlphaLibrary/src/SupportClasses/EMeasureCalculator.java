/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Models.EMeasure;
import Unit.Unit;

/**
 *
 * @author frascog
 */
public class EMeasureCalculator {
    
    public static void times(EMeasure eMeasureA, EMeasure eMeasureB, EMeasure eMeasureC) {
        eMeasureC.setMinimum(eMeasureA.getMinimum() * eMeasureB.getMinimum());
        eMeasureC.setNominal(eMeasureA.getNominal() * eMeasureB.getNominal());
        eMeasureC.setMaximun(eMeasureA.getMaximun() * eMeasureB.getMaximun());
    }
    
    public static void times(EMeasure eMeasure, double number) {
        eMeasure.setMinimum(eMeasure.getMinimum() * number);
        eMeasure.setNominal(eMeasure.getNominal() * number);
        eMeasure.setMaximun(eMeasure.getMaximun() * number);
    }

    public static void divide(EMeasure eMeasureA, EMeasure eMeasureB,EMeasure eMeasureC) {
        eMeasureC.setMinimum(eMeasureA.getMinimum() / eMeasureB.getMinimum());
        eMeasureC.setNominal(eMeasureA.getNominal() / eMeasureB.getNominal());
        eMeasureC.setMaximun(eMeasureA.getMaximun() / eMeasureB.getMaximun());
    }

    public static void setEMeasure(EMeasure eMeasureA, EMeasure eMeasureC) {
        eMeasureC.setMinimum(eMeasureA.getMinimum());
        eMeasureC.setNominal(eMeasureA.getNominal());
        eMeasureC.setMaximun(eMeasureA.getMaximun());
    }
    
    public static EMeasure eMeasuretoUnit(EMeasure eMeasureA, EMeasure eMeasureC, Unit unit) {
        eMeasureC.setMinimum(eMeasureA.getMinimum());
        eMeasureC.setNominal(eMeasureA.getNominal());
        eMeasureC.setMaximun(eMeasureA.getMaximun());
        eMeasureC.setUnit(unit);
        return eMeasureC;
    }
}
