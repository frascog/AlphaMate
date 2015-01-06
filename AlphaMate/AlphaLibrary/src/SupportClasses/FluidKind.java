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
public enum FluidKind {

    Air,
    Carbon_Dioxide,
    Helium,
    Hydrogen,
    H2,
    Nitrogen,
    N2,
    Oxygen,
    O2,
    Water,;

    @Override
    public String toString() {
        return subscript(super.toString());
    }

    public static String subscript(String str) {
        str = str.replaceAll("0", "₀");
        str = str.replaceAll("1", "₁");
        str = str.replaceAll("2", "₂");
        str = str.replaceAll("3", "₃");
        str = str.replaceAll("4", "₄");
        str = str.replaceAll("5", "₅");
        str = str.replaceAll("6", "₆");
        str = str.replaceAll("7", "₇");
        str = str.replaceAll("8", "₈");
        str = str.replaceAll("9", "₉");
        str = str.replaceAll("_", " ");
        return str;
    }
}
