/**
 * Represents a Contact with validated fields.
 * Ensures all data meets requirements before allowing creation or updates.
 */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
/**
 * Constructs a Contact object.
 * @param contactId Unique ID (max 10 characters)
 * @param firstName First name (max 10 characters)
 * @param lastName Last name (max 10 characters)
 * @param phone Phone number (exactly 10 digits)
 * @param address Address (max 30 characters)
 */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    private static void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10 || contactId.isEmpty()) {
            throw new IllegalArgumentException("Invalid contactId");
        }
    }

    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10 || firstName.isEmpty()) {
            throw new IllegalArgumentException("Invalid firstName");
        }
    }

    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10 || lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid lastName");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone");
        }
    }

    private static void validateAddress(String address) {
        if (address == null || address.length() > 30 || address.isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
