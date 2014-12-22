/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Controllers.FluidController;
import Models.EMeasure;
import Unit.SystemOfUnits;
/**
 *
 * @author frascog
 */
public class FluidAnalysist {
    
    public static EMeasure calculateDesnisty(FluidController controller) {
        //d = P x MW / (R x T)
        EMeasure density = new EMeasure("Density", SystemOfUnits.gram_per_cubic_meter);
        EMeasure pressure = new EMeasure("Pressure", controller.getPressureController().getUnit());
        EMeasure temperature = new EMeasure("Temperature", controller.getTemperatureController().getUnit());
        EMeasureCalculator.eMeasuretoUnit(controller.getPressureController().getEntity(), pressure, SystemOfUnits.atmosphere);
        EMeasureCalculator.eMeasuretoUnit(controller.getTemperatureController().getEntity(), temperature, SystemOfUnits.kelvin);
        EMeasureCalculator.times(pressure, pressure, MolecularWeight.getMolecularWeight(controller.getFluidKind()));
        EMeasureCalculator.times(temperature, 0.0821);
        EMeasureCalculator.divide(density, pressure, temperature);
        return density;
    }
}
