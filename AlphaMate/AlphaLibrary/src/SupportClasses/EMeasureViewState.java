/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

/**
 *
 * @author frascog
 */
public class EMeasureViewState {
    
    private boolean name = false;
    private boolean textfield = false;
    private boolean comboBox = false;
    private boolean button = false;

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isTextfield() {
        return textfield;
    }

    public void setTextfield(boolean textfield) {
        this.textfield = textfield;
    }

    public boolean isComboBox() {
        return comboBox;
    }

    public void setComboBox(boolean comboBox) {
        this.comboBox = comboBox;
    }

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }
    
    
}
