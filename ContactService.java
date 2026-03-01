import java.util.HashMap;
import java.util.Map;

/**
 * The ContactService class manages Contact objects using an in-memory data structure.
 * It supports adding, deleting, and updating contacts while enforcing unique IDs.
 */
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact if the ID is unique.
     * @param contact Contact object to add
     * @throws IllegalArgumentException if contact is null or duplicate
     */
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid or duplicate contact");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by ID.
     * @param contactId ID of the contact
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        getContactOrThrow(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getContactOrThrow(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getContactOrThrow(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getContactOrThrow(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    private Contact getContactOrThrow(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contact;
    }
}
