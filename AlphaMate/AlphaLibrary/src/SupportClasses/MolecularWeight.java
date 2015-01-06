/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Models.EMeasure;
import Unit.SystemOfUnits;

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
            case H2:
                molecularWeight = 2.016;
                break;
            case Nitrogen:
                molecularWeight = 14.01;
                break;
            case N2:
                molecularWeight = 28.0134;
                break;
            case Oxygen:
                molecularWeight = 15.9994;
                break;
            case O2:
                molecularWeight = 31.9988;
                break;
            case Water:
                molecularWeight = 18.015;
                break;
        }
        EMeasure eMeasure = new EMeasure("Molecular Weight", SystemOfUnits.grams_per_mole);
        eMeasure.setMinimum(molecularWeight);
        eMeasure.setNominal(molecularWeight);
        eMeasure.setMaximun(molecularWeight);
        return eMeasure;
    }
}
