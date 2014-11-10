/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

/**
 *
 * @author Greg
 */
public class EMeasureUtilities {

    public static List<Unit> findCompatiableUnits(Unit unit) {
        List<Unit> compatiableUnits = new ArrayList<Unit>();
        for (Field field : SI.class.getFields()) {
            Unit testUnit = null;
            try {
                testUnit = (Unit) field.get(unit);
            } catch (IllegalArgumentException ex) {
            } catch (IllegalAccessException ex) {
            }
            if (testUnit.isCompatible(unit)) {
                if (!compatiableUnits.contains(testUnit)) {
                    compatiableUnits.add(testUnit);
                }
            }
        }
        for (Field field : NonSI.class.getFields()) {
            Unit testUnit = null;
            try {
                testUnit = (Unit) field.get(unit);
            } catch (IllegalArgumentException ex) {
            } catch (IllegalAccessException ex) {
            }
            if (testUnit.isCompatible(unit)) {
                if (!compatiableUnits.contains(testUnit)) {
                    compatiableUnits.add(testUnit);
                }
            }
        }
        return compatiableUnits;
    }

    public static void getUnitType() {
        List unitType = new ArrayList();

    }
}
