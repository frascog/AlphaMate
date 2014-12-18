/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;

import java.util.HashMap;

/**
 *
 * @author frascog
 */
public class NonSI {
    
     /**
     * Holds the standard gravity constant: 9.80665 m/s² exact.
     */
    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;
    private static final int STANDARD_GRAVITY_DIVISOR  = 100000;

    /**
     * Holds the international foot: 0.3048 m exact.
     */
    private static final int INTERNATIONAL_FOOT_DIVIDEND =  3048;
    private static final int INTERNATIONAL_FOOT_DIViSOR  = 10000;

    /**
     * Holds the avoirdupois pound: 0.45359237 kg exact
     */
    private static final int AVOIRDUPOIS_POUND_DIVIDEND =  45359237; 
    private static final int AVOIRDUPOIS_POUND_DIVISOR  = 100000000; 

    /**
     * Holds the Avogadro constant.
     */
    private static final double AVOGADRO_CONSTANT = 6.02214199e23; // (1/mol).

    /**
     * Holds the electric charge of one electron.
     */
    private static final double ELEMENTARY_CHARGE = 1.602176462e-19; // (C).
    
    private static HashMap UNITS;
    
    
    
}
