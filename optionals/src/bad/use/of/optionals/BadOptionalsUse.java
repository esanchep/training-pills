package bad.use.of.optionals;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class BadOptionalsUse {

    public void asSubstituteForNullChecks(final String value) {
        // The null check
        if (null != value) {
            doSomething(value);
        }

        // The ugly optionals use
        Optional<String> optionalValue = Optional.ofNullable(value);
        if (optionalValue.isPresent()) {
            doSomething(optionalValue.get());
        }

        // Correct use of optional
        Optional.ofNullable(value)
                .ifPresent(this::doSomething);
    }

    public void asListMembers() {
        // Incorrect use
        Instant start1 = Instant.now();
        List<Optional<String>> optionalContacts = OptionalContacts.contacts();
        System.out.println("Number of optional contacts: " + optionalContacts.size());
        List<String> filteredContacts = optionalContacts.stream()
                .filter(this::contactExists)
                .map(Optional::get)
                .map(this::addContactPrefix)
                .toList();
        System.out.println("Number of existing contacts: " + filteredContacts.size());
        Instant end1 = Instant.now();


        System.out.println("\n\n");


        // Correct use
        Instant start2 = Instant.now();
        List<String> nonOptionalContacts = NonOptionalContacts.contacts();
        System.out.println("Number of optional non contacts: " + optionalContacts.size());
        nonOptionalContacts = nonOptionalContacts.stream()
                .map(this::addContactPrefix)
                .toList();
        System.out.println("Number of existing contacts: " + nonOptionalContacts.size());
        Instant end2 = Instant.now();


        System.out.println("Duration of optional contacts operations: " + Duration.between(start1, end1).getNano());
        System.out.println("Duration of optional contacts operations: " + Duration.between(start2, end2).getNano());
        System.out.println("With optionals took " + Duration.between(start1, end1).getNano() / Duration.between(start2, end2).getNano() + " more times to execute than With non optionals");
    }

    private void doSomething(final String value) {
        // Do something
    }

    private boolean contactExists(final Optional<String> contact) {
        boolean contactExists = contact.isPresent();
        System.out.println("Contact present: " + contactExists);
        return contactExists;
    }

    private String addContactPrefix(final String contact) {
        System.out.println("Prefixing contact: " + contact);
        return "[Contact] " + contact;
    }

}
