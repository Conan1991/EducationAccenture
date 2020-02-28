package se_Doronin.module9.activity;

import java.util.Comparator;

/**
 * Comparator used to compare the distance attributes of two RadarContacts.  If the
 * first parameter is closer than the second, the compare() method will return a negative
 * number.  If the two parameters are of the same distance, it will return 0.  If
 * the first parameter is farther away than the second, it will return a postive number
 *
 * @author John Doe
 */
public class DistanceComparator implements Comparator<RadarContact> {

    public int compare(RadarContact c1, RadarContact c2) {

        if (c1 == c2) return 0;
        if (c1.getDistance() == c2.getDistance()) return 0;
        if (c1.getDistance() - c2.getDistance() < 0) return -1;
        return 1;
    }
}
