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
public class Measure {

    private double value;
    private Unit unit;

    public Measure(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measure valueOf(double doubleValue, Unit unit) {
        return new Measure(doubleValue, unit);
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
    
    public Measure to(Unit unit) {
      return MeasureConvertor.convertUnit(this, unit);  
    }

    public double doubleValue(Unit unit) {
        return Measure.valueOf(value, this.unit).to(unit).getValue();
    }

    public String toString() {
        return getValue() + " " + getUnit();
    }

    public int compareTo(Measure that) {
        return java.lang.Double.compare(doubleValue(getUnit()), that
                .doubleValue(getUnit()));
    }
}
