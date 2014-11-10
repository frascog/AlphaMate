/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitConvertor;

import Controllers.EMeasureController;
import Models.EMeasure;
import java.util.ArrayList;
import java.util.List;
import javax.measure.unit.SI;

/**
 *
 * @author frascog
 */
class UnitConverterController {

    private EMeasureController controllerA;
    private EMeasureController controllerB;
    private UnitConverterView unitConverterView;
    private List<UnitConverterListener> listeners;

    public UnitConverterController() {
        controllerA = new EMeasureController(new EMeasure("", SI.METER));
        controllerB = new EMeasureController(new EMeasure("", SI.METER));
        controllerA.setViewState(false, true, true, false);
        controllerB.setViewState(false, false, true, false);
    }

    public EMeasureController getControllerA() {
        return controllerA;
    }

    public EMeasureController getControllerB() {
        return controllerB;
    }

    public UnitConverterView getUnitConverterView() {
        if (unitConverterView == null) {
            this.unitConverterView = new UnitConverterView(this);
        }
        return unitConverterView;
    }

    public List<UnitConverterListener> getListeners() {
        if (listeners == null) {
            listeners = new ArrayList<UnitConverterListener>();
        }
        return listeners;
    }

    public void fireUpdate() {
        if (listeners != null) {
            for (UnitConverterListener listener : listeners) {
                listener.UnitConverterChangeresponce();
            }
        }
    }
}
