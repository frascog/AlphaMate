/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Listeners.EMeasureListener;
import Models.EMeasure;
import SupportClasses.EMeasureFlavor;
import java.util.ArrayList;
import java.util.List;
import javax.measure.unit.Unit;

/**
 *
 * @author frascog
 */
public class EMeasureController {

    private EMeasure entity;
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
    }

    public String getName() {
        return entity.getName();
    }

    public void setName(String name) {
        this.entity.setName(name);
    }

    public String getDescription() {
        return entity.getDescription();
    }

    public void setDescription(String description) {
        this.entity.setDescription(description);
    }

    public double getMinimum() {
        return this.entity.getMinimum();
    }

    public void setMinimum(double minimum) {
        this.entity.setMinimum(minimum);
    }

    public double getNominal() {
        return this.entity.getNominal();
    }

    public void setNominal(double nominal) {
        this.entity.setNominal(nominal);
    }

    public double getMaximun() {
        return entity.getMaximun();
    }

    public void setMaximun(double maximun) {
        this.entity.setMaximun(maximun);
    }

    @SuppressWarnings("rawtypes")
    public Unit getUnit() {
        return entity.getUnit();
    }

    @SuppressWarnings("rawtypes")
    public void setUnit(Unit unit) {
        this.entity.setUnit(unit);
    }

    public EMeasureFlavor getFlavor() {
        return entity.getFlavor();
    }

    public void setFlavor(EMeasureFlavor flavor) {
        this.entity.setFlavor(flavor);
    }

    public int getPrecision() {
        return this.entity.getPrecision();
    }

    public void setPrecision(int precision) {
        if(precision >= 0 && precision <=9) {
            this.entity.setPrecision(precision);
        }
    }
    
    public List getListeners() {
        return this.listeners;
    }
        
    public void fireUpdate() {
        for (EMeasureListener listener : listeners) {
            listener.EMeasureChangeResponce();
        }
    }
}
