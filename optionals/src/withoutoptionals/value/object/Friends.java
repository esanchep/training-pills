package withoutoptionals.value.object;

import java.util.List;

public class Friends {

    private final List<String> value;

    public Friends(final List<String> value) {
        this.value = value;
    }

    public List<String> value() {
        return value;
    }

    @Override
    public String toString() {
        if (null == value) {
            return "";
        }
        return value.toString();
    }

}
