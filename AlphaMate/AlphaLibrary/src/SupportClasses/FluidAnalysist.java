/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Controllers.FluidController;
import Models.EMeasure;
import Models.Fluid;
import Unit.SystemOfUnits;
/**
 *
 * @author frascog
 */
public class FluidAnalysist {
    
    public static EMeasure calculateDesnisty(FluidController controller) {
        //d = P x MW / (R x T(K))
        EMeasure density = new EMeasure("Density", SystemOfUnits.gram_per_liter);
        EMeasure pressure = controller.getPressureController().to(SystemOfUnits.kilopascal);
        EMeasure temperature = controller.getTemperatureController().to(SystemOfUnits.kelvin);
        EMeasure molarmass = MolecularWeight.getMolecularWeight(controller.getFluidKind());
        double R = 8.3144621;
        
        double pMin = pressure.getMinimum();
        double pNom = pressure.getNominal();
        double pMax = pressure.getMaximun();
        
        double tMin = temperature.getMinimum();
        double tNom = temperature.getNominal();
        double tMax = temperature.getMaximun();
        
        double mMin = molarmass.getMinimum();
        double mNom = molarmass.getNominal();
        double mMax = molarmass.getMaximun();
        
        double rhoMin = (pMin * mMin) / (R * tMin);
        double rhoNom = (pNom * mNom) / (R * tNom);
        double rhoMax = (pMax * mMax) / (R * tMax);

        density.setMinimum(rhoMin);
        density.setNominal(rhoNom);
        density.setMaximun(rhoMax);
        
        return density;
    }
    
    public static EMeasure calculateLift(FluidController controller){
        EMeasure lift = new EMeasure("Lift", SystemOfUnits.kilogram);
        FluidController air = new FluidController(new Fluid(FluidKind.Dry_Air));
        air.getPressureController().setEMeasure(controller.getPressureController().getMinimum(),controller.getPressureController().getNominal(),controller.getPressureController().getMaximun());
        air.getTemperatureController().setEMeasure(controller.getTemperatureController().getMinimum(),controller.getTemperatureController().getNominal(),controller.getTemperatureController().getMaximun());
        EMeasure densityofAir = FluidAnalysist.calculateDesnisty(air);
        EMeasure densityofFluid = controller.geteMeasureSetController().getEMeasure("Density").to(SystemOfUnits.kilogram_per_cubic_meter);
        
        double airMin = densityofAir.getMinimum();
        double airNom = densityofAir.getNominal();
        double airMax = densityofAir.getMaximun();
        
        double FMin = densityofFluid.getMinimum();
        double FNom = densityofFluid.getNominal();
        double FMax = densityofFluid.getMaximun();
                
        EMeasure volume = controller.geteMeasureSetController().getEMeasure("Volume").to(SystemOfUnits.cubic_meter);
        
        double vMin = volume.getMinimum();
        double vNom = volume.getNominal();
        double vMax = volume.getMaximun();
        
        double airMassMin = airMin * vMin;
        double airMassNom = airNom * vNom;
        double airMassMax = airMax * vMax;
        
        double FMassMin = FMin * vMin;
        double FMassNom = FNom * vNom;
        double FMassMax = FMax * vMax;
        
        double lMin = (airMin - FMin)*vMin;
        double lNom = (airNom - FNom)*vNom;
        double lMax = (airMax - FMax)*vMax;
        
        lift.setMinimum(lMin);
        lift.setNominal(lNom);
        lift.setMaximun(lMax);
        
        return lift;
    }
}
