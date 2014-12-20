/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controllers.EMeasureController.EMeasureFlavor;
import SupportClasses.EMeasureFormat;
import Controllers.EMeasureController.EMeasureInterval;
import java.math.BigDecimal;
import javax.measure.DecimalMeasure;
import javax.measure.Measure;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
@SuppressWarnings("rawtypes")
public class EMeasure {
    
    private String name;
    private String description = "...";
    private Measure minimum;
    private Measure nominal;
    private Measure maximun;
    private Unit unit;
    private EMeasureFlavor flavor = EMeasureFlavor.Nominal;
    private EMeasureInterval lowerEnd = EMeasureInterval.inclusive;
    private EMeasureInterval upperEnd = EMeasureInterval.inclusive;
    private int precision = 3;
    
    @SuppressWarnings("unchecked")
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
    
    @SuppressWarnings("rawtypes")
    public Unit getUnit() {
        return unit;
    }

    @SuppressWarnings("rawtypes")
    public void setUnit(Unit unit) {
        this.unit = unit;
        this.setMinimum(this.minimum.doubleValue(unit));
        this.setNominal(this.nominal.doubleValue(unit));
        this.setMaximun(this.maximun.doubleValue(unit));
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

    @SuppressWarnings("unchecked")
    public double getMinimum() {
        return minimum.doubleValue(unit);
    }

    @SuppressWarnings("unchecked")
    public void setMinimum(double minimum) {
        this.minimum = Measure.valueOf(minimum, unit);
    }

    @SuppressWarnings("unchecked")
    public double getNominal() {
        return nominal.doubleValue(unit);
    }
    
    @SuppressWarnings("unchecked")
    public void setNominal(double nominal) {
        this.nominal = Measure.valueOf(nominal, unit);
    }

    @SuppressWarnings("unchecked")
    public double getMaximun() {
        return maximun.doubleValue(unit);
    }

    @SuppressWarnings("unchecked")
    public void setMaximun(double maximun) {
        this.maximun = Measure.valueOf(maximun, unit);
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
    
    public void toUnit(Unit unit) {
        minimum = minimum.to(unit);
        nominal = nominal.to(unit);
        maximun = maximun.to(unit);
        this.unit = unit;
    }
}
