/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Controllers.EMeasureController;
import Controllers.FluidController;
import Models.EMeasure;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
public class FluidAnalysist {
    
    public static EMeasure calculateDesnisty(FluidController controller) {
        //d = P x MW / (R x T)
        EMeasure density = new EMeasure("Density", SI.GRAM.divide(SI.CUBIC_METRE));
        EMeasure pressure = new EMeasure("Pressure", controller.getPressureController().getUnit());
        EMeasure temperature = new EMeasure("Temperature", controller.getTemperatureController().getUnit());
        EMeasureCalculator.eMeasuretoUnit(controller.getPressureController().getEntity(), pressure, NonSI.ATMOSPHERE);
        EMeasureCalculator.eMeasuretoUnit(controller.getTemperatureController().getEntity(), temperature, SI.KELVIN);
        EMeasureCalculator.times(pressure, pressure, MolecularWeight.getMolecularWeight(controller.getFluidKind()));
        EMeasureCalculator.times(temperature, 0.0821);
        EMeasureCalculator.divide(density, pressure, temperature);
        return density;
    }
}
