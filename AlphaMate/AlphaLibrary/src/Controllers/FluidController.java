/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Listeners.FluidListener;
import Models.EMeasure;
import Models.Fluid;
import SupportClasses.FluidKind;
import Views.FluidBasicView;
import Views.FluidFullView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.swing.JFrame;

/**
 *
 * @author frascog
 */
public class FluidController {
    
    private Fluid fluid;
    private EMeasureController temperatureController; 
    private EMeasureController pressureController;
    private ArrayList<FluidListener> listeners;
    private ArrayList<FluidBasicView> fluidBasicViews;
    private ArrayList<FluidFullView> fluidFullViews;
    
    private EMeasureController volumeController;
    private EMeasureController weightCintroller;
    
    public FluidController(Fluid fluid) {
        this.fluid = fluid;
        temperatureController = new EMeasureController(fluid.getTemperature());
        pressureController =  new EMeasureController(fluid.getPressure());
        this.listeners = new ArrayList<FluidListener>();
        volumeController = new EMeasureController(new EMeasure("Volume", SI.CUBIC_METRE));
        volumeController.setEMeasure(1, 1, 1);
        weightCintroller = new EMeasureController(new EMeasure("Weight", NonSI.POUND));
    }
    
    public FluidKind getFluidKind() {
        return this.fluid.getFluidKind();
    }
    
    public void setFluidKind(FluidKind fluidKind) {
        this.fluid.setFluidKind(fluidKind);
        this.fireUpdate();
    }

    public EMeasureController getTemperatureController() {
        return temperatureController;
    }

    public void setTemperatureController(EMeasureController temperatureController) {
        this.temperatureController = temperatureController;
    }

    public EMeasureController getPressureController() {
        return pressureController;
    }

    public void setPressureController(EMeasureController pressureController) {
        this.pressureController = pressureController;
    }

    public Fluid getFluid() {
        return fluid;
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
        this.fireUpdate();
    }
    
    public ArrayList<FluidListener> getListeners() {
        return listeners;
    }

    public FluidBasicView getFluidBasicView() {
        if (fluidBasicViews == null) {
            this.fluidBasicViews = new ArrayList<FluidBasicView>();
        }
        fluidBasicViews.add(new FluidBasicView(this));
        registerListeners();
        return fluidBasicViews.get(fluidBasicViews.size()-1);
    }
    
    public List<FluidBasicView> getEMeasureBasicViewSet() {
        return fluidBasicViews;
    }

    public FluidBasicView getEMeasureBasicView(int index) {
        return fluidBasicViews.get(index);
    }
    
    public FluidFullView getFluidFullView() {
        if (fluidFullViews == null) {
            this.fluidFullViews = new ArrayList<FluidFullView>();
        }
        fluidFullViews.add(new FluidFullView(this));
        registerListeners();
        return fluidFullViews.get(fluidFullViews.size()-1);
    }

    public List<FluidFullView> getEMeasureFullViewSet() {
        return fluidFullViews;
    }

    public FluidFullView getEMeasureFullView(int index) {
        return fluidFullViews.get(index);
    }
    
    public void fireUpdate() {
        if (listeners != null) {
            unregisterListeners();
            for (FluidListener listener : listeners) {
                listener.FluidChangeResponce();
            }
        }
    }
    
    private void registerListeners() {
        if (fluidBasicViews != null) {
            for (FluidBasicView view : fluidBasicViews) {
                if (!listeners.contains(view)) {
                    listeners.add(view);
                }
            }
        }

        if (fluidFullViews != null) {
            for (FluidFullView view : fluidFullViews) {
                if (!listeners.contains(view)) {
                    listeners.add(view);
                }
            }
        }
    }
    
    
    
    private void unregisterListeners() {
        if (fluidBasicViews != null) {
            for (FluidBasicView view : fluidBasicViews) {
                if (listeners.contains(view)) {
                    if (view == null) {
                        listeners.remove(view);
                    }
                }
            }
        }

        if (fluidFullViews != null) {
            for (FluidFullView view : fluidFullViews) {
                if (listeners.contains(view)) {
                    if (view == null) {
                        listeners.remove(view);
                    }
                }
            }
        }
    }

    public void openFullView() {
        JFrame editor = new JFrame();
        editor.add((this.getFluidFullView()));
        editor.pack();
        editor.setLocation(200, 200);
        editor.setVisible(true);
        editor.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                fluidFullViews = null;
                fireUpdate();
            }           
        });
    }
    
    public void calcuate() {
        //(cubic inches) x (specific gravity) x (0.0361) = (pounds)
        volumeController.toUnit(NonSI.CUBIC_INCH);
        weightCintroller.setMinimum(volumeController.getMinimum());
    }
}
