/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

/**
 *
 * @author frascog
 */
public class MeasureConvertor {

    public static Measure convertUnit(Measure measure, Unit newUnit) {
        measure = convertToBaseUnit(measure);
        return convertToNewUnit(measure, newUnit);
    }

    private static Measure convertToBaseUnit(Measure measure) {
        double value = measure.getValue();
        if (measure.getUnit().getUnitType() == UnitType.Temperature) {
            if (measure.getUnit().equals(SystemOfUnits.fahrenheit)) {
                value = (measure.getValue() - 32) * (5.0 / 9.0);
            } else if (measure.getUnit().equals(SystemOfUnits.kelvin)) {
                value = measure.getValue() - 273.15;
            }
        } else {
            value = measure.getValue() / measure.getUnit().getConverstionFactor();
        }
        return Measure.valueOf(value, getBaseUnit(measure.getUnit()));
    }

    private static Measure convertToNewUnit(Measure measure, Unit newUnit) {
        double value = measure.getValue();
        if (newUnit.getUnitType() == UnitType.Temperature) {
            if (newUnit.equals(SystemOfUnits.fahrenheit)) {
                value = (measure.getValue() * (9.0 / 5.0)) + 32;
            } else if (newUnit.equals(SystemOfUnits.kelvin)) {
                value = (measure.getValue() + 273.15);
            }
        } else {
            value = value * newUnit.getConverstionFactor();
        }
        return Measure.valueOf(value, newUnit);
    }

    private static Unit getBaseUnit(Unit unit) {
        for (Object object : SystemOfUnits.getUnits().toArray()) {
            if (object instanceof Unit) {
                Unit newUnit = (Unit) object;
                if (unit.getUnitType() == newUnit.getUnitType()) {
                    if (newUnit.getConverstionFactor() == 1) {
                        return newUnit;
                    }
                }
            }
        }
        return null;
    }
}
