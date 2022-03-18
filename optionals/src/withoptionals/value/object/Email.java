package withoptionals.value.object;

import java.util.Optional;

public class Email {

    private final String value;

    public Email(final String value) {
        this.value = Optional.of(value)
                .orElseThrow(() -> new IllegalArgumentException("Email is mandatory"));
    }

    public String value() {
        return value;
    }

}
