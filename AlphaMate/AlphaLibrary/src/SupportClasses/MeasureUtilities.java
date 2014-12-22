/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Unit.SystemOfUnits;
import Unit.Unit;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Greg
 */
public class MeasureUtilities {

    public static String getUnitName(Unit unit) {
        String unitName = null;
        Field[] fields = SystemOfUnits.class.getFields();
        for (Field field : fields) {
            try {
                Unit testUnit = (Unit) field.get(unit);
                if (testUnit.equals(unit)) {
                    unitName = field.getName();
                    break;
                }
            } catch (IllegalArgumentException ex) {
            } catch (IllegalAccessException ex) {
            }
        }
        if (unitName != null) {
            unitName = unitName.replace('_', ' ');
            unitName = unitName.toLowerCase();
        }
        return unitName;
    }

    public static List<Unit> findCompatiableUnits(Unit unit) {
        List<Unit> compatiableUnits = new ArrayList<Unit>();
        compatiableUnits.add(unit);
        for (Object object : SystemOfUnits.getUnits().toArray()) {
            if (object instanceof Unit) {
                Unit testUnit = (Unit) object; 
                if (testUnit.isCompatible(unit)) {
                    if (!compatiableUnits.contains(testUnit)) {
                    compatiableUnits.add(testUnit);
                }
            }
            }
        }
        return compatiableUnits;
    }
}
