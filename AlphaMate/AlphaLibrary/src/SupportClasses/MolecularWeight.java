/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Models.EMeasure;
import javax.measure.unit.SI;

/**
 *
 * @author frascog
 */
public class MolecularWeight {

    public static EMeasure getMolecularWeight(FluidKind fluid) {
        double molecularWeight = 0;
        switch (fluid) {
            case Air:
                molecularWeight = 28.97;
                break;
            case Carbon_Dioxide:
                molecularWeight = 44.01;
                break;
            case Helium:
                molecularWeight = 4.00;
                break;
            case Hydrogen:
                molecularWeight = 1.01;
                break;
            case Nitrogen:
                molecularWeight = 14.01;
                break;
            case Water:
                molecularWeight = 18.02;
                break;
            case SO2:
                molecularWeight = 64.1;
                break;
        }
        EMeasure eMeasure = new EMeasure("Molecular Weight", SI.GRAM.divide(SI.MOLE));
        eMeasure.setMinimum(molecularWeight);
        eMeasure.setNominal(molecularWeight);
        eMeasure.setMaximun(molecularWeight);
        return eMeasure;
    }
}
