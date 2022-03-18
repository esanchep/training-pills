package bad.optionals.use;

import java.util.ArrayList;
import java.util.List;

public class NonOptionalContacts {

    public static List<String> contacts() {
        List<String> contacts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (i < 500) {
                contacts.add("Contact " + i);
            }
        }
        return contacts;
    }

}
