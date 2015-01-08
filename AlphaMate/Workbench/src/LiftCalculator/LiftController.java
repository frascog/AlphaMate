/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiftCalculator;

import Controllers.EMeasureController;
import Models.EMeasure;
import Unit.SystemOfUnits;
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
        shape = Shape.Cylinder;
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

    public LiftCalcaulatorView getLiftView() {
        
    }

}
