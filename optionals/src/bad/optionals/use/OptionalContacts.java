package bad.optionals.use;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalContacts {
    public static List<Optional<String>> contacts() {
        List<Optional<String>> contacts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            String contact = null;
            if (i < 500) {
                contact = "Contact " + i;
            }
            contacts.add(Optional.ofNullable(contact));
        }
        return contacts;
    }
}
