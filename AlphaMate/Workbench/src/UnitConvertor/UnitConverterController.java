/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitConvertor;

import Controllers.EMeasureController;
import Models.EMeasure;
import Unit.SystemOfUnits;
import Unit.Unit;
import Unit.UnitType;
import java.util.ArrayList;
import java.util.List;

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
        controllerA = new EMeasureController(new EMeasure("", SystemOfUnits.meter));
        controllerB = new EMeasureController(new EMeasure("", SystemOfUnits.meter));
        controllerA.setViewState(false, true, true, true);
        controllerB.setViewState(false, true, true, true);
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
                listener.UnitConverterChangeresponce(null);
            }
        }
    }

    public void changeUnitType(String unitType) {
        Unit tempUnit = getBaseUnit(unitType);
        this.controllerA.setEntity(new EMeasure("", tempUnit));
        this.controllerB.setEntity(new EMeasure("", tempUnit));
    }

    private UnitType getUnitType(String unitType) {
        for (UnitType testType : UnitType.values()) {
            if (testType.toString().equals(unitType)) {
                return testType;
            }
        }
        return null;
    }

    private Unit getUnit(UnitType unitType) {
        for (Object object : SystemOfUnits.getUnits().toArray()) {
            if (object instanceof Unit) {
                Unit unit = (Unit) object;
                if (unit.getUnitType().equals(unitType)) {
                    return unit;
                }
            }
        }
        return null;
    }
    
    private Unit getBaseUnit(Unit unit) {
        for (Object object : SystemOfUnits.getUnits().toArray()) {
            if (object instanceof Unit) {
                Unit newUnit = (Unit) object;
                if (unit.getUnitType() == newUnit.getUnitType()) {
                    if (newUnit.getConverstionFactor() == 1) {
                        return newUnit;
                    }
                }
            }
        }
        return null;
    }
    
    private Unit getBaseUnit(String unitType) {
        UnitType ut = getUnitType(unitType);
        Unit tempUnit = getUnit(ut);
        return getBaseUnit(tempUnit);
    }
    
    
}
