package withoutoptionals.value.object;

public class Email {

    private final String value;

    public Email(final String value) {
        if (null == value) {
            throw new IllegalArgumentException("Email is mandatory");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

}
