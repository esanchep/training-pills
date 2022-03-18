package withoptionals.value.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Friends {

    private final List<String> value;

    public Friends(final List<String> value) {
        this.value = Optional.of(value)
                .orElseGet(ArrayList::new);
    }

    public List<String> value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
