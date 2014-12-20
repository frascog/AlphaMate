/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Models.EMeasure;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
public class EMeasureCalculator {
    
    public static void times(EMeasure eMeasure, EMeasure eMeasureA, EMeasure eMeasureB) {
        eMeasure.setMinimum(eMeasureA.getMinimum() * eMeasureB.getMinimum());
        eMeasure.setNominal(eMeasureA.getNominal() * eMeasureB.getNominal());
        eMeasure.setMaximun(eMeasureA.getMaximun() * eMeasureB.getMaximun());
    }

    public static void times(EMeasure eMeasure, double number) {
        eMeasure.setMinimum(eMeasure.getMinimum() * number);
        eMeasure.setNominal(eMeasure.getNominal() * number);
        eMeasure.setMaximun(eMeasure.getMaximun() * number);
    }

    public static void divide(EMeasure eMeasure, EMeasure eMeasureA, EMeasure eMeasureB) {
        eMeasure.setMinimum(eMeasureA.getMinimum() / eMeasureB.getMinimum());
        eMeasure.setNominal(eMeasureA.getNominal() / eMeasureB.getNominal());
        eMeasure.setMaximun(eMeasureA.getMaximun() / eMeasureB.getMaximun());
    }

    public static void setEMeasure(EMeasure eMeasureA, EMeasure eMeasureB) {
        eMeasureB.setMinimum(eMeasureA.getMinimum());
        eMeasureB.setNominal(eMeasureA.getNominal());
        eMeasureB.setMaximun(eMeasureA.getMaximun());
    }
    
    public static EMeasure eMeasuretoUnit(EMeasure eMeasureA, EMeasure eMeasureB, Unit unit) {
        eMeasureB.setMinimum(eMeasureA.getMinimum());
        eMeasureB.setNominal(eMeasureA.getNominal());
        eMeasureB.setMaximun(eMeasureA.getMaximun());
        eMeasureB.setUnit(unit);
        return eMeasureB;
    }
}
