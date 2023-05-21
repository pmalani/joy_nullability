import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

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

    // ✅
    void process1(Collection<Person> persons) {
        Optional<Collection<Person>> optional = Optional.ofNullable(persons);
    }

    // ✅✅
    void process2(Collection<Person> persons) {
        Stream<Person> stream = Stream.ofNullable(persons)
                .flatMap(Collection::stream);
    }

}
