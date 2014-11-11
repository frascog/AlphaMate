/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.measure.quantity.*;
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

    public static Object[] getUnitTypes() {
        HashMap unitTypes = new HashMap();
        unitTypes.put(new Acceleration() {
        }, "Acceleration");
        unitTypes.put(new AmountOfSubstance() {
        }, "Amount Of Substance");
        unitTypes.put(new Angle() {
        }, "Angle");
        unitTypes.put(new AngularAcceleration() {
        }, "Angular Acceleration");
        unitTypes.put(new AngularVelocity() {
        }, "Angular Velocity");
        unitTypes.put(new Area() {
        }, "Area");
        unitTypes.put(new CatalyticActivity() {
        }, "Catalytic Activity");
        unitTypes.put(new DataAmount() {
        }, "Data Amount");
        unitTypes.put(new DataRate() {
        }, "Data Rate");
        unitTypes.put(new Dimensionless() {
        }, "Dimensionless");
        unitTypes.put(new Duration() {
        }, "Duration");
        unitTypes.put(new DynamicViscosity() {
        }, "Dynamic Viscosity");
        unitTypes.put(new ElectricCapacitance() {
        }, "Electric Capacitance");
        unitTypes.put(new ElectricCharge() {
        }, "Electric Charge");
        unitTypes.put(new ElectricConductance() {
        }, "Electric Conductance");
        unitTypes.put(new ElectricCurrent() {
        }, "Electric Current");
        unitTypes.put(new ElectricInductance() {
        }, "Electric Inductance");
        unitTypes.put(new ElectricPotential() {
        }, "Electric Potential");
        unitTypes.put(new ElectricResistance() {
        }, "Electric Resistance");
        unitTypes.put(new Energy() {
        }, "Energy");
        unitTypes.put(new Force() {
        }, "Force");
        unitTypes.put(new Frequency() {
        }, "Frequency");
        unitTypes.put(new Illuminance() {
        }, "Illuminance");
        unitTypes.put(new KinematicViscosity() {
        }, "Kinematic Viscosity");
        unitTypes.put(new Length() {
        }, "Length");
        unitTypes.put(new LuminousFlux() {
        }, "Luminous Flux");
        unitTypes.put(new LuminousIntensity() {
        }, "Luminous Intensity");
        unitTypes.put(new MagneticFluxDensity() {
        }, "Magnetic Flux Density");
        unitTypes.put(new Mass() {
        }, "Mass");
        unitTypes.put(new MassFlowRate() {
        }, "Mass Flow Rate");
        unitTypes.put(new Power() {
        }, "Power");
        unitTypes.put(new Pressure() {
        }, "Pressure");
        unitTypes.put(new RadiationDoseAbsorbed() {
        }, "Radiation Dose Absorbed");
        unitTypes.put(new RadiationDoseEffective() {
        }, "Radiation Dose Effective");
        unitTypes.put(new RadioactiveActivity() {
        }, "Radioactive Activity");
        unitTypes.put(new SolidAngle() {
        }, "Solid Angle");
        unitTypes.put(new Temperature() {
        }, "Temperature");
        unitTypes.put(new Torque() {
        }, "Torque");
        unitTypes.put(new Velocity() {
        }, "Velocity");
        unitTypes.put(new Volume() {
        }, "Volume");
        unitTypes.put(new VolumetricDensity() {
        }, "Volumetric Density");
        unitTypes.put(new VolumetricFlowRate() {
        }, "Volumetric Flow Rate");
        Object[] units = unitTypes.values().toArray();
        Arrays.sort(units);
        return units;
    }

}
