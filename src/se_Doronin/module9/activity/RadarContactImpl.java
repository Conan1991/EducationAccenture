package se_Doronin.module9.activity;

/**
 * Implementation of a RadarContact
 *
 * @author John Doe
 */
public class RadarContactImpl implements RadarContact {

    String contactID;
    double bearing;
    double distance;


    /**
     * Creates a RadarContact with the specified ID, bearing and distance.
     *
     * @param contactID the contact's ID
     * @param bearing   the contact's bearing
     * @param distance  the contact's distance
     */
    public RadarContactImpl(String contactID, double bearing, double distance) {
        setContactID(contactID);
        setBearing(bearing);
        setDistance(distance);

    }

    public final double getBearing() {
        return bearing;
    }

    public final void setBearing(double bearing) {

        double temp;
        while (bearing >= 360) {
            bearing -= 360.0;
        }
        while (bearing < 0) {
            bearing = 360 + bearing;
        }
        this.bearing = bearing;


    }

    public final double getDistance() {
        return distance;
    }

    public final void setDistance(double distance) {
        if (distance < 0) {
            this.distance = 0.0;
            return;
        }
        this.distance = distance;
    }

    public final String getContactID() {
        return contactID;
    }

    public final void setContactID(String contactID) {

        this.contactID = contactID;
    }

    @Override
    public String toString() {
        return "RadarContactImpl{" +
                "contactID='" + contactID + '\'' +
                ", bearing=" + bearing +
                ", distance=" + distance +
                '}';
    }

}
