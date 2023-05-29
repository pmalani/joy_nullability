import java.util.List;
import java.util.Optional;

public class DeclaringOptional {

    // ❌
    Person getPerson1() {
        return null;
    }

    // ✅
    // Don't return nullable type; wrap them in Optional
    Optional<Person> getPerson2() {
        return Optional.empty();
    }

    // ❌❌
    Optional<Person> getPerson3() {
        return null;
    }

    // ❌
    // Don't pass Optional as parameter
    Optional<String> getName(Optional<Person> person) {
        return Optional.empty();
    }

    // ✅
    Optional<String> getName(Person person) {
        return Optional.empty();
    }

    static class Customer1 {
        // ❌
        // Don't use optional as field
        // (Okay in unit tests when testing an optional return value)
        Optional<Person> person;
    }

    static class Customer2 {
        // ✅
        Person person;
    }

    // ❌
    // Don't wrap collection types with Optional
    Optional<List<Person>> getPersons1() {
        return Optional.empty();
    }

    // ✅
    List<Person> getPersons2() {
        return List.of();
    }

}
