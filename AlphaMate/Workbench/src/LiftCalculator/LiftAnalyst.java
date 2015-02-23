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
    
    public static void calcuateVolume(LiftController controller) {
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

        double volumeMin = 0;
        double volumeNom = 0;
        double volumeMax = 0;

        switch (controller.getShape()) {
            case Capsule:
                //πr^2((4/3)r + a)
                volumeMin = Math.PI * Math.pow(radiusMin, 2) * ((4.0/3) * radiusMin + heightMin); 
                volumeNom = Math.PI * Math.pow(radiusNom, 2) * ((4.0/3) * radiusNom + heightNom); 
                volumeMax = Math.PI * Math.pow(radiusMax, 2) * ((4.0/3) * radiusMax + heightMax); 
                break;
            case Cube:
                //a^2
                volumeMin = Math.pow(lengthMin, 3);
                volumeNom = Math.pow(lengthNom, 3);
                volumeMax = Math.pow(lengthMax, 3);
                break;
            case Cuboid:
                //lwh
                volumeMin = lengthMin * widthMin * heightMin;
                volumeNom = lengthNom * widthNom * heightNom;
                volumeMax = lengthMax * widthMax * heightMax;
                break;
            case Cylinder:
                //πr^2h
                volumeMin = Math.PI * Math.pow(radiusMin,2) * heightMin; 
                volumeNom = Math.PI * Math.pow(radiusNom,2) * heightNom;
                volumeMax = Math.PI * Math.pow(radiusMax,2) * heightMax;
                break;
            case Sphere:
                //(4/3)πr3
                volumeMin = (4.0/3.0) * Math.PI * Math.pow(radiusMin, 3);
                volumeNom = (4.0/3.0) * Math.PI * Math.pow(radiusNom, 3);
                volumeMax = (4.0/3.0) * Math.PI * Math.pow(radiusMax, 3);
                break;
            case Spherical_Cap:
                //(1/3)πh^2(3R - h)
                volumeMin = (1/3) * Math.PI * Math.pow(heightMin,2) * (3 * radiusMin - heightMin);
                volumeNom = (1/3) * Math.PI * Math.pow(heightNom,2) * (3 * radiusNom - heightNom);
                volumeMax = (1/3) * Math.PI * Math.pow(heightMax,2) * (3 * radiusMax - heightMax);
                break;
        }
        Unit tempUnit = controller.getVolumeController().getUnit();
        controller.getVolumeController().setUnit(SystemOfUnits.cubic_meter);
        controller.getVolumeController().setEMeasure(volumeMin, volumeNom, volumeMax);
        controller.getVolumeController().setUnit(tempUnit);
    }

    public static void calcuateDiameter(LiftController controller) {
        double radiusMin = controller.getRadiusController().to(SystemOfUnits.meter).getMinimum();
        double radiusNom = controller.getRadiusController().to(SystemOfUnits.meter).getNominal();
        double radiusMax = controller.getRadiusController().to(SystemOfUnits.meter).getMaximun();
        
        double diameterMin = radiusMin * 2;
        double diameterNom = radiusNom * 2;
        double diameterMax = radiusMax * 2;
        
        Unit tempUnit = controller.getDiameterController().getUnit();
        controller.getDiameterController().setUnit(SystemOfUnits.meter);
        controller.getDiameterController().setEMeasure(diameterMin, diameterNom, diameterMax);
        controller.getDiameterController().setUnit(tempUnit);
    }

    public static void calcuateRadius(LiftController controller) {
        double diameterMin = controller.getDiameterController().to(SystemOfUnits.meter).getMinimum();
        double diameterNom = controller.getDiameterController().to(SystemOfUnits.meter).getNominal();
        double diameterMax = controller.getDiameterController().to(SystemOfUnits.meter).getMaximun();
        
        double radiusMin = diameterMin / 2.0;
        double radiusNom = diameterNom / 2.0;
        double radiusMax = diameterMax / 2.0;
        
        Unit tempUnit = controller.getRadiusController().getUnit();
        controller.getRadiusController().setUnit(SystemOfUnits.meter);
        controller.getRadiusController().setEMeasure(radiusMin, radiusNom, radiusMax);
        controller.getRadiusController().setUnit(tempUnit);
    }

//    public static void calcuateH2Lift(LiftController controller) {
//        
//        double volumeMin = controller.getVolumeController().to(SystemOfUnits.meter).getMinimum();
//        double volumeNom = controller.getVolumeController().to(SystemOfUnits.meter).getNominal();
//        double volumeMax = controller.getVolumeController().to(SystemOfUnits.meter).getMaximun();
//        
//        double h2LiftMin = volumeMin * 1.20154494;
//        double h2LiftNom = volumeNom * 1.20154494;
//        double h2LiftMax = volumeMax * 1.20154494;
//        
//        Unit tempUnit = controller.getH2liftController().getUnit();
//        controller.getH2liftController().setUnit(SystemOfUnits.kilogram);
//        controller.getH2liftController().setEMeasure(h2LiftMin, h2LiftNom, h2LiftMax);
//        controller.getH2liftController().setUnit(tempUnit);
//    }

//    public static void calcuateHeLift(LiftController controller) {
//        double volumeMin = controller.getVolumeController().to(SystemOfUnits.meter).getMinimum();
//        double volumeNom = controller.getVolumeController().to(SystemOfUnits.meter).getNominal();
//        double volumeMax = controller.getVolumeController().to(SystemOfUnits.meter).getMaximun();
//        
//        double heLiftMin = volumeMin * 1.05433536;
//        double heLiftNom = volumeNom * 1.05433536;
//        double heLiftMax = volumeMax * 1.05433536;
//        
//        Unit tempUnit = controller.getHeliftController().getUnit();
//        controller.getHeliftController().setUnit(SystemOfUnits.kilogram);
//        controller.getHeliftController().setEMeasure(heLiftMin, heLiftNom, heLiftMax);
//        controller.getHeliftController().setUnit(tempUnit);
//    }

}

