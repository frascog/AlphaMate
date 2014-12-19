/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import SupportClasses.FluidKind;
import javax.measure.unit.NonSI;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
public class Fluid {
    
    private FluidKind fluidKind;
    private EMeasure pressure;
    private EMeasure temperature;

    public Fluid(FluidKind fluidKind) {
        this.fluidKind = fluidKind;
        this.pressure = new EMeasure("Pressure", NonSI.ATMOSPHERE);
        this.temperature = new EMeasure("Temperature", NonSI.FAHRENHEIT);
    }
    
    public Fluid(FluidKind fluidKind, EMeasure pressure, EMeasure temperature) {
        this.fluidKind = fluidKind;
        this.pressure = pressure;
        this.temperature = temperature;
    }

    public FluidKind getFluidKind() {
        return fluidKind;
    }

    public void setFluidKind(FluidKind fluidKind) {
        this.fluidKind = fluidKind;
    }

    public EMeasure getPressure() {
        return pressure;
    }

    public void setPressure(EMeasure pressure) {
        this.pressure = pressure;
    }

    public EMeasure getTemperature() {
        return temperature;
    }

    public void setTemperature(EMeasure temperature) {
        this.temperature = temperature;
    }  

}
