package withoutoptionals.value.object;

import java.util.regex.Pattern;

public class Username {

    private final String value;

    public Username(final String value) {
        if (null == value || !Pattern.matches(".*", value)) {
            throw new IllegalArgumentException(String.format("Invalid username: %s", value));
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

}
