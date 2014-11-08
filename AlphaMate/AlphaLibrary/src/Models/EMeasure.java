/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import SupportClasses.EMeasureFlavor;
import SupportClasses.EMeasureInterval;
import java.math.BigDecimal;
import javax.measure.DecimalMeasure;
import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
public class EMeasure {
    
    private String name;
    private String description = "...";
    private Measure minimum;
    private Measure nominal;
    private Measure maximun;
    private Unit unit;
    private EMeasureFlavor flavor = EMeasureFlavor.nominal;
    private EMeasureInterval lowerEnd = EMeasureInterval.inclusive;
    private EMeasureInterval upperEnd = EMeasureInterval.inclusive;
    
    public EMeasure(String name,Unit unit){
        this.name = name;
        this.unit = unit;
        this.minimum = new DecimalMeasure(BigDecimal.valueOf(-1.0), this.unit);
        this.nominal = new DecimalMeasure(BigDecimal.valueOf(-1.0), this.unit);
        this.maximun = new DecimalMeasure(BigDecimal.valueOf(-1.0), this.unit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public EMeasureFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(EMeasureFlavor flavor) {
        this.flavor = flavor;
    }

    public EMeasureInterval getLowerEnd() {
        return lowerEnd;
    }

    public void setLowerEnd(EMeasureInterval lowerEnd) {
        this.lowerEnd = lowerEnd;
    }

    public EMeasureInterval getUpperEnd() {
        return upperEnd;
    }

    public void setUpperEnd(EMeasureInterval upperEnd) {
        this.upperEnd = upperEnd;
    }
    
}
