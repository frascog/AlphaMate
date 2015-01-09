/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiftCalculator;

import Controllers.EMeasureController;
import Models.EMeasure;
import Unit.SystemOfUnits;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frascog
 */
public class LiftController {
    
    private EMeasureController volumeController;
    private EMeasureController radiusController;
    private EMeasureController diameterController;
    private EMeasureController lengthController;
    private EMeasureController widthController;
    private EMeasureController heightController;
    private EMeasureController surfaceAeraController;
    private List<LiftCalcaulatorView> listCalculatorViews;
    private List<LiftListener> listeners;
    private Shape shape;

    public LiftController() {
        volumeController = new EMeasureController(new EMeasure("Volume", SystemOfUnits.cubic_meter));
        radiusController = new EMeasureController(new EMeasure("Radius", SystemOfUnits.meter));
        diameterController = new EMeasureController(new EMeasure("Diameter", SystemOfUnits.meter));
        lengthController = new EMeasureController(new EMeasure("Length", SystemOfUnits.meter));
        widthController = new EMeasureController(new EMeasure("Width", SystemOfUnits.meter));
        heightController = new EMeasureController(new EMeasure("Height", SystemOfUnits.meter));
        surfaceAeraController = new EMeasureController(new EMeasure("Surface Aera", SystemOfUnits.square_meter));
        shape = Shape.Cylinder;
        listeners = new ArrayList<LiftListener>();
    }

    public EMeasureController getVolumeController() {
        return volumeController;
    }

    public EMeasureController getRadiusController() {
        return radiusController;
    }

    public EMeasureController getDiameterController() {
        return diameterController;
    }

    public EMeasureController getLengthController() {
        return lengthController;
    }

    public EMeasureController getWidthController() {
        return widthController;
    }

    public EMeasureController getHeightController() {
        return heightController;
    }

    public EMeasureController getSurfaceAeraController() {
        return surfaceAeraController;
    }
    
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
        fireUpdate(null);
    }
        
    public LiftCalcaulatorView getLiftView() {
         if (this.listCalculatorViews == null) {
            this.listCalculatorViews = new ArrayList<LiftCalcaulatorView>();
        }
        listCalculatorViews.add(new LiftCalcaulatorView(this));
        registerListeners();
        return listCalculatorViews.get(listCalculatorViews.size() - 1);
    }

    private void registerListeners() {
        if (listCalculatorViews != null) {
            for (LiftCalcaulatorView view : listCalculatorViews) {
                if (!listeners.contains(view)) {
                    listeners.add(view);
                }
            }
        }
    }
    
    private void unregisterListeners() {
        if (listCalculatorViews != null) {
            for (LiftCalcaulatorView view : listCalculatorViews) {
                if (listeners.contains(view)) {
                    if (view == null) {
                        listeners.remove(view);
                    }
                }
            }
        }
    }
    
    public void fireUpdate(EMeasure e) {
        if (listeners != null) {
            unregisterListeners();
            for (LiftListener listener : listeners) {
                listener.LiftCalcualtorChangeResponce(e);
            }
        }
    }
    
    public void calculate() {
        LiftAnalyst.calcuateSurfaceAera(this);
        LiftAnalyst.calcuateVolume(this);
    }

}
