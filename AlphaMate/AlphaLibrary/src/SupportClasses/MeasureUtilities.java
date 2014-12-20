/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.measure.quantity.*;
import javax.measure.unit.NonSI;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

/**
 *
 * @author Greg
 */
public class MeasureUtilities {

    public static HashMap unitTypes;

    public static String getUnitName(Unit unit) {
        String unitName = null;
        Field[] fieldsNonSI = NonSI.class.getFields();
        Field[] fieldsSI = SI.class.getFields();
        for (Field field : fieldsSI) {
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
        if (unitName == null) {
            for (Field field : fieldsNonSI) {
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

    public static Object[] getUnitTypes() {
        unitTypes = new HashMap();
        unitTypes.put("Acceleration", SI.METRES_PER_SQUARE_SECOND);
        unitTypes.put("Amount Of Substance", SI.MOLE);
        unitTypes.put("Angle", SI.RADIAN);
        unitTypes.put("Angular Acceleration", new ProductUnit<AngularAcceleration>(SI.RADIAN.divide(SI.SECOND.pow(2))));
        unitTypes.put("Angular Velocity", new ProductUnit<AngularVelocity>(SI.RADIAN.divide(SI.SECOND)));
        unitTypes.put("Area", SI.SQUARE_METRE);
        unitTypes.put("Catalytic Activity", SI.KATAL);
        unitTypes.put("Data Amount", SI.BIT);
        unitTypes.put("Data Rate", new ProductUnit<DataRate>(SI.BIT.divide(SI.SECOND)));
        unitTypes.put("Dimensionless", Unit.ONE);
        unitTypes.put("Duration", SI.SECOND);
        unitTypes.put("Dynamic Viscosity", new ProductUnit<DynamicViscosity>(SI.PASCAL.times(SI.SECOND)));
        unitTypes.put("Electric Capacitance", SI.FARAD);
        unitTypes.put("Electric Charge", SI.COULOMB);
        unitTypes.put("Electric Conductance", SI.SIEMENS);
        unitTypes.put("Electric Current", SI.AMPERE);
        unitTypes.put("Electric Inductance", SI.HENRY);
        unitTypes.put("Electric Potential", SI.VOLT);
        unitTypes.put("Electric Resistance", SI.OHM);
        unitTypes.put("Energy", SI.JOULE);
        unitTypes.put("Force", SI.NEWTON);
        unitTypes.put("Frequency", SI.HERTZ);
        unitTypes.put("Illuminance", SI.LUX);
        unitTypes.put("Kinematic Viscosity", new ProductUnit<KinematicViscosity>(SI.METRE.pow(2).divide(SI.SECOND)));
        unitTypes.put("Length", SI.METER);
        unitTypes.put("Luminous Flux", SI.LUMEN);
        unitTypes.put("Luminous Intensity", SI.CANDELA);
        unitTypes.put("Magnetic Flux", SI.WEBER);
        unitTypes.put("Magnetic Flux Density", SI.TESLA);
        unitTypes.put("Mass", SI.KILOGRAM);
        unitTypes.put("Mass Flow Rate", (Unit<MassFlowRate>) SI.KILOGRAM.divide(SI.SECOND));
        unitTypes.put("Power", SI.WATT);
        unitTypes.put("Pressure", SI.PASCAL);
        unitTypes.put("Radiation Dose Absorbed", SI.GRAY);
        unitTypes.put("Radiation Dose Effective", SI.SIEVERT);
        unitTypes.put("Radioactive Activity", SI.BECQUEREL);
        unitTypes.put("Solid Angle", SI.STERADIAN);
        unitTypes.put("Temperature", SI.KELVIN);
        unitTypes.put("Torque", new ProductUnit<Torque>(SI.NEWTON.times(SI.METRE)));
        unitTypes.put("Velocity", SI.METRES_PER_SECOND);
        unitTypes.put("Volume", SI.CUBIC_METRE);
        unitTypes.put("Volumetric Density", new ProductUnit<VolumetricDensity>(SI.KILOGRAM.divide(SI.METRE.pow(3))));
        unitTypes.put("Volumetric Flow Rate", (Unit<VolumetricFlowRate>) SI.METRE.pow(3).divide(SI.SECOND));
        Object[] units = unitTypes.keySet().toArray();
        Arrays.sort(units);
        return units;
    }

    public static String findUnitTypeOfUnit(Unit unit) {
        List<Unit> units = findCompatiableUnits(unit);
        for (Unit u : units) {
            if (unitTypes.containsValue(u)) {
                Object[] entrySet = unitTypes.values().toArray();
                int i = 0;
                for (Object entry : entrySet) {
                    if (entry.equals(u)) {
                        break;
                    }
                    i++;
                }
                return (String) unitTypes.keySet().toArray()[i];
            }
        }
        return null;
    }
}
