import java.util.Optional;

public class CreatingOptional {

    Optional<Person> getPerson1() {
        return Optional.empty();
    }

    // ❌
    // input can be null!
    Optional<Person> getPerson2(Person input) {
        return Optional.of(input);
    }

    // ✅
    Optional<Person> getPerson3(Person input) {
        return Optional.ofNullable(input);
    }

}
