/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Listeners.EMeasureListener;
import Models.EMeasure;
import SupportClasses.EMeasureFormat;
import SupportClasses.EMeasureViewState;
import Views.EMeasureBasicView;
import Views.EMeasureFullView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private EMeasureViewState viewState;
    private EMeasureBasicView eMeasureBasicView;
    private EMeasureFullView eMeasureFullView;
    private List<EMeasureListener> listeners;

    public EMeasureController(EMeasure entity) {
        this.entity = entity;
        this.listeners = new ArrayList<EMeasureListener>();
        this.viewState = new EMeasureViewState();
    }

    public EMeasure getEntity() {
        return entity;
    }

    public void setEntity(EMeasure entity) {
        this.entity = entity;
        this.eMeasureBasicView.initMyComponents();
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

    public void setMinimum(String minimum) {
        double number = 0.0;
        try {
            number = Double.parseDouble(minimum);
            this.setMinimum(number);
        } catch (NumberFormatException nfe) {
            this.fireUpdate();
        }
    }

    public double getNominal() {
        return this.entity.getNominal();
    }

    public void setNominal(double nominal) {
        this.entity.setNominal(nominal);
        this.fireUpdate();
    }

    public void setNominal(String nominal) {
        double number = 0.0;
        try {
            number = Double.parseDouble(nominal);
            this.setNominal(number);
        } catch (NumberFormatException nfe) {
            this.fireUpdate();
        }
    }

    public double getMaximun() {
        return entity.getMaximun();
    }

    public void setMaximun(double maximun) {
        this.entity.setMaximun(maximun);
        this.fireUpdate();
    }

    public void setMaximun(String maximun) {
        double number = 0.0;
        try {
            number = Double.parseDouble(maximun);
            this.setMaximun(number);
        } catch (NumberFormatException nfe) {
            this.fireUpdate();
        }
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
    
    public EMeasureFullView getEMeasureFullView() {
        if (this.eMeasureFullView == null) {
            this.eMeasureFullView = new EMeasureFullView(this);
        }
        registerListeners();
        return eMeasureFullView;
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
        if (eMeasureFullView != null) {
            if (!listeners.contains(eMeasureFullView)) {
                listeners.add(eMeasureFullView);
            }
        }
    }

    private void unregisterListeners() {
        if(eMeasureBasicView == null) {
            if (listeners.contains(eMeasureBasicView)) {
                listeners.remove(eMeasureBasicView);
            }
        }
        
        if(eMeasureFullView == null) {
            if (listeners.contains(eMeasureFullView)) {
                listeners.remove(eMeasureFullView);
            }
        }
    }
    
    public void fireUpdate() {
        if (listeners != null) {
            unregisterListeners();
            for (EMeasureListener listener : listeners) {
                listener.EMeasureChangeResponce();
            }
        }
    }

    public String getEMeasure() {
        String eMeasure = null;
        switch (this.getFlavor()) {
            case Nominal:
                eMeasure = EMeasureFormat.format(entity.getNominal(), entity.getPrecision()) + "";
                break;
            case Minimum_Maximun:
                if (entity.getLowerEnd() == EMeasureInterval.exclusive) {
                    eMeasure = "( ";
                } else {
                    eMeasure = "[ ";
                }
                eMeasure += EMeasureFormat.format(entity.getMinimum(), entity.getPrecision()) + " ";
                eMeasure += EMeasureFormat.format(entity.getMaximun(), entity.getPrecision()) + " ";
                if (entity.getUpperEnd() == EMeasureInterval.exclusive) {
                    eMeasure += ")";
                } else {
                    eMeasure += "]";
                }
                break;
            case Minimum_Nominal_Maximun:
                if (entity.getLowerEnd() == EMeasureInterval.exclusive) {
                    eMeasure = "( ";
                } else {
                    eMeasure = "[ ";
                }
                eMeasure += EMeasureFormat.format(entity.getMinimum(), entity.getPrecision()) + " ";
                eMeasure += EMeasureFormat.format(entity.getNominal(), entity.getPrecision()) + " ";
                eMeasure += EMeasureFormat.format(entity.getMaximun(), entity.getPrecision()) + " ";
                if (entity.getUpperEnd() == EMeasureInterval.exclusive) {
                    eMeasure += ")";
                } else {
                    eMeasure += "]";
                }
                break;
        }
        return eMeasure;
    }

    public void openFullView() {
        JFrame editor = new JFrame();
        editor.add((this.getEMeasureFullView()));
        editor.pack();
        editor.setLocation(200, 200);
        editor.setVisible(true);
        editor.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
                eMeasureFullView = null;
                fireUpdate();
            }           
        });
    }

    
    public void setViewState(boolean label, boolean textfield, boolean combobox, boolean button) {
        this.viewState.setName(label);
        this.viewState.setTextfield(textfield);
        this.viewState.setComboBox(combobox);
        this.viewState.setButton(button);
    }

    public EMeasureInterval getLowerEnd() {
        return this.entity.getLowerEnd();
    }

    public void setLowerEnd(EMeasureInterval lowerEnd) {
        this.entity.setLowerEnd(lowerEnd);
    }

    public EMeasureInterval getUpperEnd() {
        return this.entity.getUpperEnd();
    }

    public void setUpperEnd(EMeasureInterval upperEnd) {
        this.entity.setUpperEnd(upperEnd);
    }
    
    public boolean isLowerInclusive() {
        if(this.entity.getLowerEnd()== EMeasureInterval.inclusive) {
            return true;
        }
        return false;
    }
    
    public boolean isUpperInclusive() {
        if(this.entity.getUpperEnd() == EMeasureInterval.inclusive) {
            return true;
        }
        return false;
    }
    
    public enum EMeasureFlavor {

        Nominal,
        Minimum_Maximun,
        Minimum_Nominal_Maximun;
    }

    public enum EMeasureInterval {

        inclusive,
        exclusive;
    }
}
