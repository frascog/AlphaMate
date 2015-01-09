/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LiftCalculator;

import Unit.SystemOfUnits;
import Unit.Unit;

/**
 *
 * @author Greg
 */
public class LiftAnalyst {

    public static void calcuateSurfaceAera(LiftController controller) {
        double radiusMin = controller.getRadiusController().to(SystemOfUnits.meter).getMinimum();
        double radiusNom = controller.getRadiusController().to(SystemOfUnits.meter).getNominal();
        double radiusMax = controller.getRadiusController().to(SystemOfUnits.meter).getMaximun();

        double heightMin = controller.getHeightController().to(SystemOfUnits.meter).getMinimum();
        double heightNom = controller.getHeightController().to(SystemOfUnits.meter).getNominal();
        double heightMax = controller.getHeightController().to(SystemOfUnits.meter).getMaximun();

        double widthMin = controller.getWidthController().to(SystemOfUnits.meter).getMinimum();
        double widthNom = controller.getWidthController().to(SystemOfUnits.meter).getNominal();
        double widthMax = controller.getWidthController().to(SystemOfUnits.meter).getMaximun();

        double lengthMin = controller.getLengthController().to(SystemOfUnits.meter).getMinimum();
        double lengthNom = controller.getLengthController().to(SystemOfUnits.meter).getNominal();
        double lengthMax = controller.getLengthController().to(SystemOfUnits.meter).getMaximun();

        double surfaceMin = 0;
        double surfaceNom = 0;
        double surfaceMax = 0;

        switch (controller.getShape()) {
            case Capsule:
                //2πr(2r + a)
                surfaceMin = 2 * Math.PI * radiusMin * (2 * radiusMin + heightMin);
                surfaceNom = 2 * Math.PI * radiusNom * (2 * radiusNom + heightNom);
                surfaceMax = 2 * Math.PI * radiusMax * (2 * radiusMax + heightMax);
                break;
            case Cube:
                //6a2
                surfaceMin = 6 * Math.pow(lengthMin, 2);
                surfaceNom = 6 * Math.pow(lengthNom, 2);
                surfaceMax = 6 * Math.pow(lengthMax, 2);
                break;
            case Cuboid:
                //2(lw + lh + wh)
                surfaceMin = 2 * (lengthMin * widthMin + lengthMin * heightMin + widthMin * heightMin);
                surfaceNom = 2 * (lengthNom * widthNom + lengthNom * heightNom + widthNom * heightNom);
                surfaceMax = 2 * (lengthMax * widthMax + lengthMax * heightMax + widthMax * heightMax);
                break;
            case Cylinder:
                //2πrh + 2(πr2)
                surfaceMin = 2 * Math.PI * radiusMin * heightMin + 2 * (Math.PI * radiusMin * 2);
                surfaceNom = 2 * Math.PI * radiusNom * heightNom + 2 * (Math.PI * radiusNom * 2);
                surfaceMax = 2 * Math.PI * radiusMax * heightMax + 2 * (Math.PI * radiusMax * 2);
                break;
            case Sphere:
                //4πr2
                surfaceMin = 4 * Math.PI * Math.pow(radiusMin, 2);
                surfaceNom = 4 * Math.PI * Math.pow(radiusNom, 2);
                surfaceMax = 4 * Math.PI * Math.pow(radiusMax, 2);
                break;
            case Spherical_Cap:
                //2πRh
                surfaceMin = 2 * Math.PI * radiusMin * heightMin;
                surfaceNom = 2 * Math.PI * radiusNom * heightNom;
                surfaceMax = 2 * Math.PI * radiusMax * heightMax;
                break;
        }
        Unit tempUnit = controller.getSurfaceAeraController().getUnit();
        controller.getSurfaceAeraController().setUnit(SystemOfUnits.square_meter);
        controller.getSurfaceAeraController().setEMeasure(surfaceMin, surfaceNom, surfaceMax);
        controller.getSurfaceAeraController().setUnit(tempUnit);
    }
}

