package sef.module9.activity;

import java.util.*;

/**
 * Implementation of a Radar
 */
public class RadarImpl implements Radar {

    List<RadarContact> contacts;


    /**
     * Constructs a new Radar
     */
    public RadarImpl() {
        contacts = new ArrayList<>();
    }


    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
     */
    public RadarContact addContact(RadarContact contact) {
        contacts.add(contact);
        return contact;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#getContact(java.lang.String)
     */
    public RadarContact getContact(String id) {
        for (RadarContact contact : contacts)
            if (contact.getContactID().equals(id))
                return contact;
        return null;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#getContactCount()
     */
    public int getContactCount() {
        return contacts.size();
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#removeContact(java.lang.String)
     */
    public RadarContact removeContact(String id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactID().equals(id))
                return contacts.remove(i);
        }
        return null;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts()
     */
    public List<RadarContact> returnContacts() {
        List<RadarContact> list = new ArrayList<>(contacts);
        return list;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
     */
    public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
        Collections.sort(contacts, new DistanceComparator());
        List<RadarContact> list = new ArrayList<>(contacts);
        return list;
//
    }


}
