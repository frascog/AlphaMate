/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import java.util.HashSet;

/**
 *
 * @author frascog
 */
public final class SystemOfUnits {
    
    private static HashSet<Unit> units = new HashSet<Unit>();
//    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;
//    private static final int STANDARD_GRAVITY_DIVISOR  = 100000;
//    private static final int INTERNATIONAL_FOOT_DIVIDEND =  3048;
//    private static final int INTERNATIONAL_FOOT_DIViSOR  = 10000;
//    private static final int AVOIRDUPOIS_POUND_DIVIDEND =  45359237;
//    private static final int AVOIRDUPOIS_POUND_DIVISOR  = 100000000; 
    private static final double AVOGADRO_CONSTANT = 6.02214199e23; // (1/mol).
//    private static final double ELEMENTARY_CHARGE = 1.602176462e-19; // (C).

    private SystemOfUnits() {
    
    }
    
    private static final SystemOfUnits INSTANCE = new SystemOfUnits();
    
    public static SystemOfUnits getInstance() {
        return INSTANCE;
    }
    
    private static Unit nonSI(Unit unit) {
        units.add(unit);
        return unit;
    }

    // Acceleration
    
    public static final Unit meters_per_second_squared = nonSI(new Unit("m/s²", UnitType.Acceleration, 1));
    public static final Unit centimeter_per_second_second = nonSI(new Unit("cm/s²",UnitType.Acceleration, 100));
    public static final Unit foot_per_square_second = nonSI(new Unit("ft/sec²",UnitType.Acceleration, 3.280839895));
    public static final Unit standard_gravity = nonSI(new Unit("grav",UnitType.Acceleration, 0.1019716213));
    public static final Unit mile_per_square_second = nonSI(new Unit("mi/sec²",UnitType.Acceleration,0.00062137119225));
    public static final Unit inch_per_square_second = nonSI(new Unit("in/s²", UnitType.Acceleration, 39.37007874));
    
    // Amount of Substance
    
    public static final Unit mol = nonSI(new Unit("mol", UnitType.AmountOfSubstance, 1));
    public static final Unit atom = nonSI(new Unit("atom", UnitType.AmountOfSubstance, AVOGADRO_CONSTANT));
    
    // Angle
    
    public static final Unit radians = nonSI(new Unit("rad", UnitType.Angle, 1));
    public static final Unit degrees = nonSI(new Unit("°",UnitType.Angle,57.29577951308));
    
    // Angular Acceleration
    
    public static final Unit radian_per_square_second = nonSI(new Unit("rad/s²", UnitType.AngularAcceleration, 1));
    public static final Unit radian_per_square_minute = nonSI(new Unit("rad/min²", UnitType.AngularAcceleration, 3600));
    public static final Unit revolution_per_square_second = nonSI(new Unit("r/s²",UnitType.AngularAcceleration,0.159154943));
    public static final Unit revolution_per_square_minute = nonSI(new Unit("", UnitType.AngularAcceleration, 572.9577952));
    
    // Angular Acceleration
    
    public static final Unit radian_per_second = nonSI(new Unit("rad/s",UnitType.AngularVelocity,1));
    public static final Unit radian_per_minute = nonSI(new Unit("rad/min",UnitType.AngularVelocity,60));
    public static final Unit radian_per_hour = nonSI(new Unit("rad/hr", UnitType.AngularVelocity,3600));
    public static final Unit radian_per_day = nonSI(new Unit("rad/d", UnitType.AngularVelocity,86400));
    public static final Unit degree_per_second = nonSI(new Unit("°/s",UnitType.AngularVelocity,57.295779513));
    public static final Unit degree_per_minute = nonSI(new Unit("°/min",UnitType.AngularVelocity,3437.746770785));
    public static final Unit degree_per_hour = nonSI(new Unit("°/hr", UnitType.AngularVelocity,206264.8062471));
    public static final Unit degree_per_day = nonSI(new Unit("°/d", UnitType.AngularVelocity,4950355.3499303));
    public static final Unit revolution_per_second = nonSI(new Unit("r/s",UnitType.AngularVelocity,0.159154943));
    public static final Unit revolution_per_minute = nonSI(new Unit("r/min",UnitType.AngularVelocity,9.549296586));
    public static final Unit revolution_per_hour = nonSI(new Unit("r/hr", UnitType.AngularVelocity,572.957795131));
    public static final Unit revolution_per_day = nonSI(new Unit("r/d", UnitType.AngularVelocity,13750.98708314));
    
    // Aera
    
    public static final Unit square_meter = nonSI(new Unit("m²",UnitType.Area,1));
    public static final Unit square_centimeter = nonSI(new Unit("cm²",UnitType.Area,10000));
    public static final Unit square_millimeter  = nonSI(new Unit("mm²",UnitType.Area,1000000));
    public static final Unit square_kilometer = nonSI(new Unit("km²", UnitType.Area, 0.000001));
    public static final Unit acre = nonSI(new Unit("acre",UnitType.Area,0.0002471053814672));
    public static final Unit square_inch = nonSI(new Unit("in²", UnitType.Area, 1550.003100006));
    public static final Unit square_foot = nonSI(new Unit("ft²", UnitType.Area, 10.76391041671));
    public static final Unit square_yard = nonSI(new Unit("yd²", UnitType.Area, 1.195990046301));
    public static final Unit square_mile = nonSI(new Unit("mi²", UnitType.Area, 3.861021585425e-7));
    
    // Blood Suger
    
    public static final Unit mmol_per_l = nonSI(new Unit("mmol / l",UnitType.BloodSuger,1));
    public static final Unit mg_per_dl = nonSI(new Unit("mg%",UnitType.BloodSuger,18));

    // Capacitance
    
    public static final Unit farad = nonSI(new Unit("F", UnitType.Capacitance, 1));
    public static final Unit microfarads  = nonSI(new Unit("µF", UnitType.Capacitance, 1000000));
    public static final Unit nanofarad = nonSI(new Unit("nF", UnitType.Capacitance, 1000000000));
    
    // DataAmount
    
    public static final Unit megabyte = nonSI(new Unit("MB", UnitType.DataAmount, 1));
    public static final Unit bit = nonSI(new Unit("bit",UnitType.DataAmount,8388608));
    public static final Unit byte_ = nonSI(new Unit("B", UnitType.DataAmount, 1048576)); 
    public static final Unit kilobit = nonSI(new Unit("Kb", UnitType.DataAmount, 8192)); 
    public static final Unit kilobyte = nonSI(new Unit("KB", UnitType.DataAmount, 1024)); 
    public static final Unit megabit = nonSI(new Unit("Mb", UnitType.DataAmount, 8)); 
    public static final Unit gigabut = nonSI(new Unit("Gb", UnitType.DataAmount, 0.0078125)); 
    public static final Unit gigabyte = nonSI(new Unit("GB", UnitType.DataAmount, 0.0009765625));
    public static final Unit terabut = nonSI(new Unit("Tb", UnitType.DataAmount, 0.00000762939453125));
    public static final Unit terabyte = nonSI(new Unit("TB", UnitType.DataAmount, 9.537109375e-7));
    
    // Data rate converstions
    
    public static final Unit megabyte_per_second = nonSI(new Unit("MB/s", UnitType.DataRate, 1));
    public static final Unit kilobyte_per_second = nonSI(new Unit("KB/s", UnitType.DataRate, 1000));
    public static final Unit byte_per_second = nonSI(new Unit("B/s", UnitType.DataRate, 1000000));
    public static final Unit gigabyte_per_second = nonSI(new Unit("GB/s", UnitType.DataRate, 0.001));
    public static final Unit terabyte_per_second = nonSI(new Unit("TB/s", UnitType.DataRate, 0.000001));
    
    //Density
    
    public static final Unit gram_per_liter = nonSI(new Unit("g/L", UnitType.Density, 1));
    public static final Unit gram_per_cubic_meter = nonSI(new Unit("g/m³", UnitType.Density, 1000));
    public static final Unit milligram_per_liter = nonSI(new Unit("mg/L", UnitType.Density, 1000));
    public static final Unit pounds_per_gallon = nonSI(new Unit("lb/gal", UnitType.Density, 0.0083454044873));
    public static final Unit pounds_per_cubic_foot = nonSI(new Unit("lb/ft³", UnitType.Density, 0.62427960841));
    
    //Dimensionless
    
    public static final Unit one = nonSI(new Unit("", UnitType.Dimensionless, 1));
    
    
    
    
}