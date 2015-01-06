/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Listeners.EMeasureListener;
import Models.EMeasure;
import Views.EMeasureSetView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author frascog
 */
public class EMeasureSetController {
    
    private List<EMeasureController> eMeasureSet;
    private List<EMeasureListener> listeners;
    private List<EMeasureSetView> eMeasureSetViews;

    public EMeasureSetController() {
        this.eMeasureSet = new LinkedList<EMeasureController>();
        this.listeners = new ArrayList<EMeasureListener>();
    }
    
    public void addEMeasure(EMeasure eMeasure) {
        this.eMeasureSet.add(new EMeasureController(eMeasure));
    }
    
    public void addEMeasure(EMeasureController eMeasure) {
        this.eMeasureSet.add(eMeasure);
    }
    
    public void removeEMeasure(EMeasure eMeasure) {
        for (EMeasureController eMeasureController : eMeasureSet) {
            if(eMeasureController.getEntity().equals(eMeasure)) {
                eMeasureSet.remove(eMeasureController);
                break;
            }
        }
    }
    
    public void removeEMeasure(EMeasureController controller) {
        this.eMeasureSet.remove(controller);
    }
    
    public List<EMeasureController> getEMeasureSet() {
        return this.eMeasureSet;
    }

    public List<EMeasureController> geteMeasureSet() {
        return eMeasureSet;
    }

    public EMeasureController getEMeasure(String name) {
        for (EMeasureController eMeasure : eMeasureSet) {
            if(eMeasure.getName().equals(name))
                return eMeasure;
        }
        return null;
    }
    
    public List<EMeasureListener> getListeners() {
        return listeners;
    }

    public List<EMeasureSetView> geteMeasureSetViews() {
        return eMeasureSetViews;
    }
    
    public EMeasureSetView getEMeasureSetView() {
        if (this.eMeasureSetViews == null) {
            this.eMeasureSetViews = new ArrayList<EMeasureSetView>();
        }
        eMeasureSetViews.add(new EMeasureSetView(this));
        registerListeners();
        return eMeasureSetViews.get(eMeasureSetViews.size()-1);
    }
  
    
    public void fireUpdate() {
        if (listeners != null) {
            unregisterListeners();
            for (EMeasureListener listener : listeners) {
                listener.EMeasureChangeResponce(this.eMeasureSet.get(1).getEntity());
            }
        }
    }

    private void registerListeners() { 
        if (eMeasureSetViews != null) {
            for (EMeasureSetView view : eMeasureSetViews) {
                if (!listeners.contains(view)) {
                    listeners.add(view);
                }
            }
        }
    }
    
    private void unregisterListeners() {
        if (eMeasureSetViews != null) {
            for (EMeasureSetView view : eMeasureSetViews) {
                if (listeners.contains(view)) {
                    if (view == null) {
                        listeners.remove(view);
                    }
                }
            }
        }
    }
}
