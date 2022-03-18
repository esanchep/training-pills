package withoutoptionals.value.object;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Id {

    private final String value;

    public Id(final String value) {
        Supplier<String> generateNewId = () -> UUID.randomUUID().toString();

        this.value = Optional.of(value)
                .orElseGet(generateNewId);
    }

    public String value() {
        return value;
    }

}
