package javax.measure.SupportClasses;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.measure.quantity.Area;
import javax.measure.unit.SI;
import javax.measure.unit.SystemOfUnits;
import javax.measure.unit.Unit;

public class MyUnits extends SystemOfUnits {

    private static HashSet<Unit<?>> UNITS = new HashSet();

    private static final MyUnits INSTANCE = new MyUnits();

    public static final Unit<Area> ACRE = myUnits((SI.METER.pow(2)).times(4046.8564224).asType(Area.class));

    public static MyUnits getInstance() {
        return INSTANCE;
    }

    @Override
    public Set<Unit<?>> getUnits() {
        return Collections.unmodifiableSet(UNITS);
    }

    private static <U extends Unit<?>> U myUnits(U unit) {
        
        UNITS.add(unit);
        return unit;
    }
    
    
}
