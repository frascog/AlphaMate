/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Listeners.FluidListener;
import Models.Fluid;
import SupportClasses.FluidKind;
import Views.FluidBasicView;
import java.util.ArrayList;

/**
 *
 * @author frascog
 */
public class FluidController {
    
    private Fluid fluid;
    private EMeasureController temperatureController; 
    private EMeasureController pressureController;
    private ArrayList<FluidListener> listeners;
    private FluidBasicView fluidBasicView;
    
    public FluidController(Fluid fluid) {
        this.fluid = fluid;
        temperatureController = new EMeasureController(fluid.getTemperature());
        pressureController = new EMeasureController(fluid.getPressure());
        this.listeners = new ArrayList<FluidListener>();
    }
    
    public FluidKind getFluidKind() {
        return this.fluid.getFluidKind();
    }
    
    public void setFluidKind(FluidKind fluidKind) {
        this.fluid.setFluidKind(fluidKind);
    }

    public EMeasureController getTemperatureController() {
        return temperatureController;
    }

    public EMeasureController getPressureController() {
        return pressureController;
    }

    public Fluid getFluid() {
        return fluid;
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }
    
    public ArrayList<FluidListener> getListeners() {
        return listeners;
    }

    public FluidBasicView getFluidBasicView() {
        if (fluidBasicView == null) {
            this.fluidBasicView = new FluidBasicView(this);
        }
        return fluidBasicView;
    }

    private void registerListeners() {
        if (fluidBasicView != null) {
            if (!listeners.contains(fluidBasicView)) {
                listeners.add(fluidBasicView);
            }
        }
    }
    
}
