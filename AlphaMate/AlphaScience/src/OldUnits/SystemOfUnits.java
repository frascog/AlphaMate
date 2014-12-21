///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package OldUnits;
//
//import java.lang.reflect.Field;
//
///**
// *
// * @author frascog
// */
//public class SystemOfUnits {
//
//    //Length
//
//    public static final Unit METER = new Unit("m", UnitType.Length, 1.0);
//    public static final Unit KILOMETER = new Unit("km", UnitType.Length, 0.001);
//    public static final Unit CENTIMETRE = new Unit("cm", UnitType.Length, 100);
//    public static final Unit MILLIMETER = new Unit("mm", UnitType.Length, 1000);
//    public static final Unit FOOT = new Unit("ft", UnitType.Length, 3.28084);
//    public static final Unit YARD = new Unit("yd", UnitType.Length, 1.09361);
//    public static final Unit INCH = new Unit("in", UnitType.Length, 39.3701);
//    public static final Unit MILE = new Unit("mi", UnitType.Length, 0.000621371);
//
//    //Mass
//    public static final Unit POUND = new Unit("lb", UnitType.Mass, 2.20462);
//    public static final Unit OUNCE = new Unit("oz", UnitType.Mass, 35.274);
//    public static final Unit TON = new Unit("t", UnitType.Mass, 0.00110231);
//    public static final Unit GRAM = new Unit("g", UnitType.Mass, 0.001);
//    public static final Unit KILOGRAM = new Unit("kg", UnitType.Mass, 1);
//
//    //Tempurture
//    public static final Unit CELSIUS = new Unit("°C", UnitType.Temperature, 1);
//    public static final Unit FAHRENHEIT = new Unit("°F", UnitType.Temperature, 33.8);
//    public static final Unit KELVIN = new Unit("°K", UnitType.Temperature, 274.15);
//
//    //Pressure
//    public static final Unit ATMOSPHERE = new Unit("atm", UnitType.Pressure, 0.0000098692316931);
//    public static final Unit BAR = new Unit("b", UnitType.Pressure, 0.00001);
//    public static final Unit PASCAL = new Unit("Pa", UnitType.Pressure, 1);
//    public static final Unit PSI = new Unit("psi", UnitType.Pressure, 0.00014503773801);
//
//    //Electric potential
//    public static final Unit VOLTS = new Unit("V", UnitType.ElectricPotential, 1);
//
//    //Angular velocity
//    public static final Unit RPM = new Unit("RPM", UnitType.AngularVelocity, 9.549296596425384);
//    public static final Unit RADIAN_PER_SECOND = new Unit("rad/sec", UnitType.AngularVelocity, 1);
//
//    //Torque
//    public static final Unit NEWTON_METER = new Unit("N*m", UnitType.Torque, 1);
//    public static final Unit NEWTON_CENTIMETER = new Unit("N*cm", UnitType.Torque, 100);
//    public static final Unit NEWTON_MILLIMETER = new Unit("N*mm", UnitType.Torque, 1000);
//    public static final Unit INCH_OUNCES = new Unit("in-oz", UnitType.Torque, 141.6);
//    public static final Unit INCH_POUNDS = new Unit("in-lbs", UnitType.Torque, 8.851);
//
//    //Ampers
//    public static final Unit AMPERES = new Unit("A", UnitType.ElectricCurrent, 1);
//
//    //Flowrate
//    public static final Unit CUBIC_METER_PER_SECOND = new Unit("m³/s", UnitType.FlowRate, 1);
//    public static final Unit CUBIC_METER_PER_MINUTE = new Unit("m³/min", UnitType.FlowRate, 60);
//    public static final Unit CUBIC_METER_PER_HOUR = new Unit("m³/hr", UnitType.FlowRate, 3600);
//    public static final Unit LITER_PER_SECOND = new Unit("l/s", UnitType.FlowRate, 1000);
//    public static final Unit LITER_PER_MINUTE = new Unit("l/min", UnitType.FlowRate, 60000);
//    public static final Unit LITER_PER_HOUR = new Unit("l/hr", UnitType.FlowRate, 3600000);
//    public static final Unit GALLONS_PER_SECOND = new Unit("gps", UnitType.FlowRate, 264.2);
//    public static final Unit GALLONS_PER_MINUTE = new Unit("gpm", UnitType.FlowRate, 15850);
//    public static final Unit GALLONS_PER_HOUR = new Unit("gph", UnitType.FlowRate, 951000);
//
//    public static Unit[] findCompatiableUnits(Unit unit) {
//        int size = SystemOfUnits.class.getFields().length;
//        Unit[] compatiableUnits = new Unit[size];
//        int count = 0;
//        for (int i = 0; i < size; i++) {
//            Field field = SystemOfUnits.class.getFields()[i];
//            try {
//                Unit testUnit = (Unit) field.get(unit);
//                if (testUnit.getUnitType() == unit.getUnitType()) {
//                    compatiableUnits[count] = testUnit;
//                    count++;
//                }
//            } catch (IllegalArgumentException ex) {
//            } catch (IllegalAccessException ex) {
//            }
//        }
//        Unit[] allcompatiableUnits = new Unit[count];
//        for (int i = 0; i < count; i++) {
//            allcompatiableUnits[i] = compatiableUnits[i];
//        }
//        return allcompatiableUnits;
//    }
//
//    public static Unit unitFromString(String symbol) {
//        int size = SystemOfUnits.class.getFields().length;
//        Unit unit = null;
//        for (int i = 0; i < size; i++) {
//            Field field = SystemOfUnits.class.getFields()[i];
//            try {
//                Unit testUnit = (Unit) field.get(unit);
//                if (testUnit.getSymbol().equals(symbol)) {
//                    return testUnit;
//                }
//            } catch (IllegalArgumentException ex) {
//            } catch (IllegalAccessException ex) {
//            }
//        }
//        return null;
//    }
//}
