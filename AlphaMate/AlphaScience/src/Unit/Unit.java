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
public class Unit {
    
    private final String symbol;
    private final UnitType unitType;
    private final double converstionFactor;

    public Unit(String symbol, UnitType unitType, double converstionFactor) {
        this.symbol = symbol;
        this.unitType = unitType;
        this.converstionFactor = converstionFactor;
    }

    public String getSymbol() {
        return symbol;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public double getConverstionFactor() {
        return converstionFactor;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public boolean isCompatible(Unit unit) {
        if(this.unitType.equals(unit.getUnitType())) {
            return true;
        }
        return false;
    }   
}
