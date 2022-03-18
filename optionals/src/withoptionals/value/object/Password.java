package withoptionals.value.object;

import java.util.regex.Pattern;

public class Password {

    private final String value;

    public Password(final String value) {
        validate(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validate(final String value) {
        if (null == value || !Pattern.matches(".*", value)) {
            throw new IllegalArgumentException(String.format("Invalid username: %s", value));
        }
    }

}
