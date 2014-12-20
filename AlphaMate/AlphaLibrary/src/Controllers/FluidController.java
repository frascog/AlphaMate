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
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import javax.swing.JFrame;

/**
 *
 * @author frascog
 */
public class FluidController {
    
    private Fluid fluid;
    private EMeasureController temperatureController; 
    private EMeasureController pressureController;
    private List<FluidListener> listeners;
    private List<FluidBasicView> fluidBasicViews;
    private List<FluidFullView> fluidFullViews;
    private EMeasureSetController eMeasureSetController;
    
    
    public FluidController(Fluid fluid) {
        this.fluid = fluid;
        temperatureController = new EMeasureController(fluid.getTemperature());
        pressureController =  new EMeasureController(fluid.getPressure());
        this.listeners = new ArrayList<FluidListener>();
        this.eMeasureSetController = new EMeasureSetController();
        initCalculations();
    }
    
    private void initCalculations() {
        eMeasureSetController.addEMeasure(new EMeasure("Desnisty", SI.KILOGRAM.divide(SI.CUBIC_METRE)));
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
    
    public List<FluidListener> getListeners() {
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
    
    public List<FluidBasicView> getFluidBasicViewSet() {
        return fluidBasicViews;
    }

    public FluidBasicView getFluidBasicView(int index) {
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

    public List<FluidFullView> getFluidFullViewSet() {
        return fluidFullViews;
    }

    public FluidFullView getFluidFullView(int index) {
        return fluidFullViews.get(index);
    }

    public EMeasureSetController geteMeasureSetController() {
        return eMeasureSetController;
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
        //d = P x MW / (R x T)
        
    }
}
