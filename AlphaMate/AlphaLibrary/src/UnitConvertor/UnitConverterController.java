/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitConvertor;

import Controllers.EMeasureController;
import Models.EMeasure;
import javax.measure.SupportClasses.MeasureUtilities;
import java.util.ArrayList;
import java.util.List;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
public class UnitConverterController {

    private EMeasureController controllerA;
    private EMeasureController controllerB;
    private UnitConverterView unitConverterView;
    private List<UnitConverterListener> listeners;

    public UnitConverterController() {
        controllerA = new EMeasureController(new EMeasure("", SI.METER));
        controllerB = new EMeasureController(new EMeasure("", SI.METER));
        controllerA.setViewState(false, true, true, false);
        controllerB.setViewState(false, false, true, false);
        this.getListeners();
    }

    public EMeasureController getControllerA() {
        return controllerA;
    }

    public void setControllerA(EMeasureController controllerA) {
        this.controllerA = controllerA;
    }

    public EMeasureController getControllerB() {
        return controllerB;
    }

    public void setControllerB(EMeasureController controllerB) {
        this.controllerB = controllerB;
    }

    public UnitConverterView getUnitConverterView() {
        if (unitConverterView == null) {
            this.unitConverterView = new UnitConverterView(this);
        }
        return unitConverterView;
    }

    public void setUnitConverterView(UnitConverterView unitConverterView) {
        this.unitConverterView = unitConverterView;
    }

    public List<UnitConverterListener> getListeners() {
        if (listeners == null) {
            listeners = new ArrayList<UnitConverterListener>();
        }
        registerListeners();
        return listeners;
    }
    
    public void registerListeners() {
        if (this.unitConverterView != null) {
            if (!this.listeners.contains(this.unitConverterView)) {
                this.listeners.add(unitConverterView);
            }
        }
    }
    
    public void unregisterListeners() {
        if (this.unitConverterView != null) {
            if (this.listeners.contains(this.unitConverterView)) {
                this.listeners.remove(unitConverterView);
            }
        }
    }

    public void fireUpdate() {
        if (listeners != null) {
            for (UnitConverterListener listener : listeners) {
                listener.UnitConverterChangeresponce();
            }
        }
    }

    public void changeUnitType(Object selectedItem) {
        Unit tempUnit = (Unit) MeasureUtilities.unitTypes.get(selectedItem);
        this.controllerA.setEntity(new EMeasure("", tempUnit));
        this.controllerB.setEntity(new EMeasure("", tempUnit));
    }
}
