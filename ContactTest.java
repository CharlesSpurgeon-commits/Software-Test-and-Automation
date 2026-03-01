import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testCreateContactSuccess() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        assertNotNull(contact);
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testCreateContactContactIdTooLongFails() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testCreateContactFirstNameNullFails() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testCreateContactLastNameTooLongFails() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }

    @Test
    void testCreateContactPhoneTooShortFails() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "12345", "123 Main St"));
    }

    @Test
    void testCreateContactAddressTooLongFails() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "1234567890",
                        "This address is definitely longer than thirty characters"));
    }

    @Test
    void testUpdateContactSuccess() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak St", contact.getAddress());
    }
}
