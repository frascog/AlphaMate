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
    public static final Unit centimeter_per_second_second = nonSI(new Unit("cm/s²", UnitType.Acceleration, 100));
    public static final Unit foot_per_square_second = nonSI(new Unit("ft/sec²", UnitType.Acceleration, 3.280839895));
    public static final Unit standard_gravity = nonSI(new Unit("grav", UnitType.Acceleration, 0.1019716213));
    public static final Unit mile_per_square_second = nonSI(new Unit("mi/sec²", UnitType.Acceleration, 0.00062137119225));
    public static final Unit inch_per_square_second = nonSI(new Unit("in/s²", UnitType.Acceleration, 39.37007874));

    // Amount of Substance
    public static final Unit mol = nonSI(new Unit("mol", UnitType.Amount_Of_Substance, 1));
    public static final Unit atom = nonSI(new Unit("atom", UnitType.Amount_Of_Substance, AVOGADRO_CONSTANT));

    // Angle
    public static final Unit radians = nonSI(new Unit("rad", UnitType.Angle, 1));
    public static final Unit degrees = nonSI(new Unit("°", UnitType.Angle, 57.29577951308));

    // Angular Acceleration
    public static final Unit radian_per_square_second = nonSI(new Unit("rad/s²", UnitType.Angular_Acceleration, 1));
    public static final Unit radian_per_square_minute = nonSI(new Unit("rad/min²", UnitType.Angular_Acceleration, 3600));
    public static final Unit revolution_per_square_second = nonSI(new Unit("r/s²", UnitType.Angular_Acceleration, 0.159154943));
    public static final Unit revolution_per_square_minute = nonSI(new Unit("", UnitType.Angular_Acceleration, 572.9577952));

    // Angular Acceleration
    public static final Unit radian_per_second = nonSI(new Unit("rad/s", UnitType.Angular_Velocity, 1));
    public static final Unit radian_per_minute = nonSI(new Unit("rad/min", UnitType.Angular_Velocity, 60));
    public static final Unit radian_per_hour = nonSI(new Unit("rad/hr", UnitType.Angular_Velocity, 3600));
    public static final Unit radian_per_day = nonSI(new Unit("rad/d", UnitType.Angular_Velocity, 86400));
    public static final Unit degree_per_second = nonSI(new Unit("°/s", UnitType.Angular_Velocity, 57.295779513));
    public static final Unit degree_per_minute = nonSI(new Unit("°/min", UnitType.Angular_Velocity, 3437.746770785));
    public static final Unit degree_per_hour = nonSI(new Unit("°/hr", UnitType.Angular_Velocity, 206264.8062471));
    public static final Unit degree_per_day = nonSI(new Unit("°/d", UnitType.Angular_Velocity, 4950355.3499303));
    public static final Unit revolution_per_second = nonSI(new Unit("rps", UnitType.Angular_Velocity, 0.159154943));
    public static final Unit revolution_per_minute = nonSI(new Unit("rpm", UnitType.Angular_Velocity, 9.549296586));
    public static final Unit revolution_per_hour = nonSI(new Unit("r/hr", UnitType.Angular_Velocity, 572.957795131));
    public static final Unit revolution_per_day = nonSI(new Unit("r/d", UnitType.Angular_Velocity, 13750.98708314));

    // Aera
    public static final Unit square_meter = nonSI(new Unit("m²", UnitType.Area, 1));
    public static final Unit square_centimeter = nonSI(new Unit("cm²", UnitType.Area, 10000));
    public static final Unit square_millimeter = nonSI(new Unit("mm²", UnitType.Area, 1000000));
    public static final Unit square_kilometer = nonSI(new Unit("km²", UnitType.Area, 0.000001));
    public static final Unit acre = nonSI(new Unit("acre", UnitType.Area, 0.0002471053814672));
    public static final Unit square_inch = nonSI(new Unit("in²", UnitType.Area, 1550.003100006));
    public static final Unit square_foot = nonSI(new Unit("ft²", UnitType.Area, 10.76391041671));
    public static final Unit square_yard = nonSI(new Unit("yd²", UnitType.Area, 1.195990046301));
    public static final Unit square_mile = nonSI(new Unit("mi²", UnitType.Area, 3.861021585425e-7));

    // Blood Suger
    public static final Unit mmol_per_l = nonSI(new Unit("mmol / l", UnitType.Blood_Suger, 1));
    public static final Unit mg_per_dl = nonSI(new Unit("mg%", UnitType.Blood_Suger, 18));

    // DataAmount
    public static final Unit megabyte = nonSI(new Unit("MB", UnitType.Data_Amount, 1));
    public static final Unit bit = nonSI(new Unit("bit", UnitType.Data_Amount, 8388608));
    public static final Unit byte_ = nonSI(new Unit("B", UnitType.Data_Amount, 1048576));
    public static final Unit kilobit = nonSI(new Unit("Kb", UnitType.Data_Amount, 8192));
    public static final Unit kilobyte = nonSI(new Unit("KB", UnitType.Data_Amount, 1024));
    public static final Unit megabit = nonSI(new Unit("Mb", UnitType.Data_Amount, 8));
    public static final Unit gigabut = nonSI(new Unit("Gb", UnitType.Data_Amount, 0.0078125));
    public static final Unit gigabyte = nonSI(new Unit("GB", UnitType.Data_Amount, 0.0009765625));
    public static final Unit terabut = nonSI(new Unit("Tb", UnitType.Data_Amount, 0.00000762939453125));
    public static final Unit terabyte = nonSI(new Unit("TB", UnitType.Data_Amount, 9.537109375e-7));

    // Data rate converstions
    public static final Unit megabyte_per_second = nonSI(new Unit("MB/s", UnitType.Data_Rate, 1));
    public static final Unit kilobyte_per_second = nonSI(new Unit("KB/s", UnitType.Data_Rate, 1000));
    public static final Unit byte_per_second = nonSI(new Unit("B/s", UnitType.Data_Rate, 1000000));
    public static final Unit gigabyte_per_second = nonSI(new Unit("GB/s", UnitType.Data_Rate, 0.001));
    public static final Unit terabyte_per_second = nonSI(new Unit("TB/s", UnitType.Data_Rate, 0.000001));

    //Density
    public static final Unit gram_per_liter = nonSI(new Unit("g/L", UnitType.Density, 1));
    public static final Unit gram_per_cubic_meter = nonSI(new Unit("g/m³", UnitType.Density, 1000));
    public static final Unit milligram_per_liter = nonSI(new Unit("mg/L", UnitType.Density, 1000));
    public static final Unit pounds_per_gallon = nonSI(new Unit("lb/gal", UnitType.Density, 0.0083454044873));
    public static final Unit pounds_per_cubic_foot = nonSI(new Unit("lb/ft³", UnitType.Density, 0.62427960841));

    //Dimensionless
    public static final Unit one = nonSI(new Unit("", UnitType.Dimensionless, 1));

    //Duration
    public static final Unit nanosecond = nonSI(new Unit("ns", UnitType.Duration, 1000000000));
    public static final Unit microsecond = nonSI(new Unit("μs", UnitType.Duration, 1000000));
    public static final Unit millisecond = nonSI(new Unit("ms", UnitType.Duration, 1000));
    public static final Unit second = nonSI(new Unit("s", UnitType.Duration, 1));
    public static final Unit minute = nonSI(new Unit("min", UnitType.Duration, 0.0166666666666666666666666666666666666666666));
    public static final Unit hour = nonSI(new Unit("hr", UnitType.Duration, 0.000277777777777777777777777777777777777777777));
    public static final Unit day = nonSI(new Unit("d", UnitType.Duration, 0.0000115740740740740740740740740740740740740740));
    public static final Unit week = nonSI(new Unit("wk", UnitType.Duration, 0.000001653439153439));
    public static final Unit month = nonSI(new Unit("mt", UnitType.Duration, 3.802537330419e-7));
    public static final Unit year = nonSI(new Unit("y", UnitType.Duration, 3.170979198377e-8));

    //Dynamic Viscosity
    public static final Unit pascal_second = nonSI(new Unit("Pa · s", UnitType.Dynamic_Viscosity, 1));
    public static final Unit centipoise = nonSI(new Unit("cP", UnitType.Dynamic_Viscosity, 1000));

    // Electrical Capacitance
    public static final Unit farad = nonSI(new Unit("F", UnitType.Electric_Capacitance, 1));
    public static final Unit microfarads = nonSI(new Unit("µF", UnitType.Electric_Capacitance, 1000000));
    public static final Unit nanofarad = nonSI(new Unit("nF", UnitType.Electric_Capacitance, 1000000000));

    // Electrical Charge
    public static final Unit coulomb = nonSI(new Unit("C", UnitType.Electric_Charge, 1));
    public static final Unit elementary_charge = nonSI(new Unit("e", UnitType.Electric_Charge, 624150947415.4e7));
    public static final Unit faraday = nonSI(new Unit("F", UnitType.Electric_Charge, 0.00001036426864904));
    public static final Unit franklin = nonSI(new Unit("Fr", UnitType.Electric_Charge, 2997961386.257));

    // Electrical Conductance
    public static final Unit siemens = nonSI(new Unit("S", UnitType.Electric_Conductance, 1));
    public static final Unit megasiemens = nonSI(new Unit("MS", UnitType.Electric_Conductance, 0.000001));
    public static final Unit kilosiemens = nonSI(new Unit("kS", UnitType.Electric_Conductance, 0.001));
    public static final Unit millisiemens = nonSI(new Unit("mS", UnitType.Electric_Conductance, 1000));
    public static final Unit microsiemens = nonSI(new Unit("µS", UnitType.Electric_Conductance, 1000000));

    // Electric_Current
    public static final Unit Ampere = nonSI(new Unit("A", UnitType.Electric_Current, 1));

    // Electrical_Inductance
    public static final Unit henry = nonSI(new Unit("H", UnitType.Electric_Inductance, 1));
    public static final Unit kilohenry = nonSI(new Unit("kH", UnitType.Electric_Inductance, 0.001));
    public static final Unit millihenry = nonSI(new Unit("mH", UnitType.Electric_Inductance, 1000));
    public static final Unit microhenry = nonSI(new Unit("µH", UnitType.Electric_Inductance, 1000000));

    // Electric_Potential
    public static final Unit volt = nonSI(new Unit("V", UnitType.Electric_Potential, 1));

    // Electrical_Resistance
    public static final Unit ohm = nonSI(new Unit("Ω", UnitType.Electric_Resistance, 1));
    public static final Unit megaohm = nonSI(new Unit("MΩ", UnitType.Electric_Resistance, 0.000001));
    public static final Unit kiloohm = nonSI(new Unit("kΩ", UnitType.Electric_Resistance, 0.001));
    public static final Unit milliohm = nonSI(new Unit("mΩ", UnitType.Electric_Resistance, 1000));

    //Energy
    public static final Unit joule = nonSI(new Unit("J", UnitType.Energy, 1));
    public static final Unit foot_pound = nonSI(new Unit("ft·lbf", UnitType.Energy, 0.7375621492773));
    public static final Unit electronvolt = nonSI(new Unit("eV", UnitType.Energy, 6241509744511524.9e3));
    public static final Unit erg = nonSI(new Unit("erg", UnitType.Energy, 10000000));

    // Force
    public static final Unit newton = nonSI(new Unit("N", UnitType.Force, 1));
    public static final Unit dyne = nonSI(new Unit("dyn", UnitType.Force, 100000));
    public static final Unit kilonewton = nonSI(new Unit("kN", UnitType.Force, 0.001));
    public static final Unit kip = nonSI(new Unit("kip", UnitType.Force, 0.0002248));
    public static final Unit kilogram_force = nonSI(new Unit("kgf", UnitType.Force, 0.1019716));
    public static final Unit pound_force = nonSI(new Unit("lbf", UnitType.Force, 0.22480894387));

    //Frequency
    public static final Unit hertz = nonSI(new Unit("Hz", UnitType.Frequency, 1));
    public static final Unit curie = nonSI(new Unit("Ci", UnitType.Frequency, 3.7e10));
    public static final Unit rutherford = nonSI(new Unit("Rd", UnitType.Frequency, .000001));

    // Lux
    public static final Unit lux = nonSI(new Unit("lx", UnitType.Illuminance, 1));
    public static final Unit foot_candle = nonSI(new Unit("fc", UnitType.Illuminance, 0.09290304));
    public static final Unit kilolux = nonSI(new Unit("klx", UnitType.Illuminance, 0.001));
    public static final Unit microlux = nonSI(new Unit("µlx", UnitType.Illuminance, 1000000));
    public static final Unit millilux = nonSI(new Unit("mlux", UnitType.Illuminance, 1));
    public static final Unit phot = nonSI(new Unit("ph", UnitType.Illuminance, 0.0001));
    public static final Unit nox = nonSI(new Unit("nox", UnitType.Illuminance, 1000));

    // Kinematic_Viscosity
    public static final Unit square_meter_per_unit = nonSI(new Unit("m²/s", UnitType.Kinematic_Viscosity, 1));
    public static final Unit square_centimeter_per_second = nonSI(new Unit("cm²/s", UnitType.Kinematic_Viscosity, 1000000));
    public static final Unit stokes = nonSI(new Unit("St", UnitType.Kinematic_Viscosity, 10000));

    // Length
    public static final Unit meter = nonSI(new Unit("m", UnitType.Length, 1));
    public static final Unit angstrom = nonSI(new Unit("å", UnitType.Length, 1));
    public static final Unit astronomical_unit = nonSI(new Unit("au", UnitType.Length, 6.684587122671e-12));
    public static final Unit centimeter = nonSI(new Unit("cm", UnitType.Length, 100));
    public static final Unit chain = nonSI(new Unit("ch", UnitType.Length, 0.04970969537899));
    public static final Unit decimeter = nonSI(new Unit("dm", UnitType.Length, 10));
    public static final Unit fathom = nonSI(new Unit("ftm", UnitType.Length, 0.5468066491689));
    public static final Unit foot = nonSI(new Unit("ft", UnitType.Length, 3.280839895013));
    public static final Unit furlong = nonSI(new Unit("furlong", UnitType.Length, 0.004970969537899));
    public static final Unit inch = nonSI(new Unit("in", UnitType.Length, 39.37007874016));
    public static final Unit kilometer = nonSI(new Unit("km", UnitType.Length, 0.001));
    public static final Unit lightyear = nonSI(new Unit("ly", UnitType.Length, 1.057000834025e-16));
    public static final Unit mile = nonSI(new Unit("mi", UnitType.Length, 0.0006213711922373));
    public static final Unit millimeter = nonSI(new Unit("mm", UnitType.Length, 1000));
    public static final Unit micrometer = nonSI(new Unit("µm", UnitType.Length, 1000000));
    public static final Unit micron = nonSI(new Unit("µ", UnitType.Length, 1000000));
    public static final Unit nanometer = nonSI(new Unit("nm", UnitType.Length, 1000000000));
    public static final Unit nautical_mile = nonSI(new Unit("nmi", UnitType.Length, 0.0005399568034557));
    public static final Unit parsec = nonSI(new Unit("nm", UnitType.Length, 3.240779289639e-17));
    public static final Unit rod = nonSI(new Unit("rod", UnitType.Length, 0.198838781516));
    public static final Unit yard = nonSI(new Unit("yd", UnitType.Length, 1.093613298338));

    //Luminous_Flux
    public static final Unit lumen_hour = nonSI(new Unit("lm·h", UnitType.Luminous_Flux, 1));
    public static final Unit lumen_minute = nonSI(new Unit("lm·min", UnitType.Luminous_Flux, 60));
    public static final Unit lumen_second = nonSI(new Unit("lm·s", UnitType.Luminous_Flux, 3600));
    public static final Unit talbot = nonSI(new Unit("hp", UnitType.Luminous_Flux, 3600));

    //Luminous_Intensity
    public static final Unit lumen_per_steradian  = nonSI(new Unit("lm/sr", UnitType.Luminous_Intensity, 1));
    public static final Unit candela = nonSI(new Unit("cd", UnitType.Luminous_Intensity, 1));
    public static final Unit hefnerkerze  = nonSI(new Unit("HK", UnitType.Luminous_Intensity, 1.106967615309));
    public static final Unit candlepower = nonSI(new Unit("hp", UnitType.Luminous_Intensity, 1.019367991845));

    //Magnetic Flux
    public static final Unit weber = nonSI(new Unit("Wb", UnitType.Magnetic_Flux, 1));
    public static final Unit maxwell = nonSI(new Unit("Mx", UnitType.Magnetic_Flux, 10000000));

    //Magnetic Flux Density
    
    public static final Unit tesla = nonSI(new Unit("T", UnitType.Magnetic_Flux_Density, 1));
    public static final Unit gauss = nonSI(new Unit("G", UnitType.Magnetic_Flux_Density, 10000));
    public static final Unit weber_per_square_metre = nonSI(new Unit("Wb/m²", UnitType.Magnetic_Flux_Density, 10000));

    //Magnetic Flux Density Strength
    
    public static final Unit ampere_per_meter = nonSI(new Unit("A/m", UnitType.Magnetic_Flux_Density_Strength, 1));
    public static final Unit ampere_turn_per_meter = nonSI(new Unit("AT/m", UnitType.Magnetic_Flux_Density_Strength, 1));
    public static final Unit gilbert_per_meter = nonSI(new Unit("Gi/m", UnitType.Magnetic_Flux_Density_Strength, 1.256637061436));
    public static final Unit oersted  = nonSI(new Unit("Oe", UnitType.Magnetic_Flux_Density_Strength, 0.01256637061436));
      
    //Magnetomotive Force
    
    public static final Unit ampere_turn = nonSI(new Unit("AT", UnitType.Magnetomotive_Force, 1));
    public static final Unit gilbert  = nonSI(new Unit("Gi", UnitType.Magnetomotive_Force, 1.256637061436));
    
    // Mass
}
