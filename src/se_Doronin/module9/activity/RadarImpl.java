package se_Doronin.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public RadarContact addContact(RadarContact contact) {
        contacts.add(contact);
        return contact;
    }

    public RadarContact getContact(String id) {
        for (RadarContact contact : contacts)
            if (contact.getContactID().equals(id))
                return contact;
        return null;
    }

    public int getContactCount() {
        return contacts.size();
    }

    public RadarContact removeContact(String id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactID().equals(id))
                return contacts.remove(i);
        }
        return null;
    }

    public List<RadarContact> returnContacts() {
        List<RadarContact> list = new ArrayList<>(contacts);
        return list;
    }

    public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
        Collections.sort(contacts, new DistanceComparator());
        List<RadarContact> list = new ArrayList<>(contacts);
        return list;
    }
}
