/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;

/**
 *
 * @author frascog
 */
public class Unit {
    
    private final String symbol;
    private final UnitType unitType;

    public Unit(UnitType unitType,String symbol) {
        this.symbol = symbol;
        this.unitType = unitType;
    }
    
    public Unit getStanderdUnit() {
        return null;
    }
    
    public void toStandardUnit() {
        
    }
    
    public boolean isCompatible() {
        return false;
    }

    public void add(double offset) {
        
    }
    
    public void subtract(double offset) {
        
    }
    
    public void times(double factor) {
        
    }
    
    public void times(Unit factor) {
        
    }
    
    public void divide(double factor) {
        
    }
    
    public void divide(Unit factor) {
        
    }
    
    public void root(int n) {
        
    }   
    
    public void pow(int n) {
        
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
        
}
