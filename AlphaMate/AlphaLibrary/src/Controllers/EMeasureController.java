/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Listeners.EMeasureListener;
import Models.EMeasure;
import SupportClasses.EMeasureFlavor;
import SupportClasses.EMeasureInterval;
import SupportClasses.EMeasureViewState;
import Views.EMeasureBasicView;
import java.util.ArrayList;
import java.util.List;
import javax.measure.unit.Unit;
import javax.swing.JFrame;

/**
 *
 * @author frascog
 */
public class EMeasureController {

    private EMeasure entity;
    private EMeasureViewState viewState = new EMeasureViewState();
    private EMeasureBasicView eMeasureBasicView;
    private List<EMeasureListener> listeners;

    public EMeasureController(EMeasure entity) {
        this.entity = entity;
        this.listeners = new ArrayList<EMeasureListener>();
    }

    public EMeasure getEntity() {
        return entity;
    }

    public void setEntity(EMeasure entity) {
        this.entity = entity;
        this.fireUpdate();
    }

    public String getName() {
        return entity.getName();
    }

    public void setName(String name) {
        this.entity.setName(name);
        this.fireUpdate();
    }

    public String getDescription() {
        return entity.getDescription();
    }

    public void setDescription(String description) {
        this.entity.setDescription(description);
        this.fireUpdate();
    }

    public double getMinimum() {
        return this.entity.getMinimum();
    }

    public void setMinimum(double minimum) {
        this.entity.setMinimum(minimum);
        this.fireUpdate();
    }

    public double getNominal() {
        return this.entity.getNominal();
    }

    public void setNominal(double nominal) {
        this.entity.setNominal(nominal);
        this.fireUpdate();
    }

    public double getMaximun() {
        return entity.getMaximun();
    }

    public void setMaximun(double maximun) {
        this.entity.setMaximun(maximun);
        this.fireUpdate();
    }

    @SuppressWarnings("rawtypes")
    public Unit getUnit() {
        return entity.getUnit();
    }

    @SuppressWarnings("rawtypes")
    public void setUnit(Unit unit) {
        this.entity.setUnit(unit);
        this.fireUpdate();
    }

    public EMeasureFlavor getFlavor() {
        return entity.getFlavor();
    }

    public void setFlavor(EMeasureFlavor flavor) {
        this.entity.setFlavor(flavor);
        this.fireUpdate();
    }

    public int getPrecision() {
        return this.entity.getPrecision();
    }

    public void setPrecision(int precision) {
        if (precision >= 0 && precision <= 9) {
            this.entity.setPrecision(precision);
            this.fireUpdate();
        }
    }

    public EMeasureBasicView getEMeasureBasicView() {
        if (this.eMeasureBasicView == null) {
            this.eMeasureBasicView = new EMeasureBasicView(this);
        }
        registerListeners();
        return eMeasureBasicView;
    }

    public EMeasureViewState getViewState() {
        return viewState;
    }
    
    public List getListeners() {
        return this.listeners;
    }

    private void registerListeners() {
        if (eMeasureBasicView != null) {
            if (!listeners.contains(eMeasureBasicView)) {
                listeners.add(eMeasureBasicView);
            }
        }
    }

    public void fireUpdate() {
        if (listeners != null) {
            for (EMeasureListener listener : listeners) {
                listener.EMeasureChangeResponce();
            }
        }
    }

    public String getEMeasure() {
        String eMeasure = null;
        switch (this.getFlavor()) {
            case nominal:
                eMeasure = entity.getNominal() + "";
                break;
            case minimum_maximun:
                if (entity.getLowerEnd() == EMeasureInterval.exclusive) {
                    eMeasure = "( ";
                } else {
                    eMeasure = "[ ";
                }
                eMeasure += entity.getMinimum() + " ";
                eMeasure += entity.getMaximun() + " ";
                if (entity.getUpperEnd() == EMeasureInterval.exclusive) {
                    eMeasure = ")";
                } else {
                    eMeasure = "]";
                }
                break;
            case minimum_nominal_maximun:
                if (entity.getLowerEnd() == EMeasureInterval.exclusive) {
                    eMeasure = "( ";
                } else {
                    eMeasure = "[ ";
                }
                eMeasure += entity.getMinimum() + " ";
                eMeasure += entity.getNominal() + " ";
                eMeasure += entity.getMaximun() + " ";
                if (entity.getUpperEnd() == EMeasureInterval.exclusive) {
                    eMeasure = ")";
                } else {
                    eMeasure = "]";
                }
                break;
        }
        return eMeasure;
    }

    public void openFullView() {
        JFrame editor = new JFrame();
        //editor.add((editor));
        editor.pack();
        editor.setLocation(200, 200);
        editor.setVisible(true);
    }
    
    public void setViewState(boolean label, boolean textfield,boolean combobox,boolean button) {
        this.viewState.setName(label);
        this.viewState.setTextfield(textfield);
        this.viewState.setComboBox(combobox);
        this.viewState.setButton(button);
    }
}