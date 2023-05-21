import java.util.Optional;

public class UsingOptional {

    Optional<Person> getPerson() {
        return Optional.empty();
    }

    // ❌
    void incorrectUsage() {
        Optional<Person> optionalPerson = getPerson();
        //don't check optional values against null
        if (optionalPerson == null) {
            return;
        }
    }

    // ✅
    void correctUsage1() {
        Optional<Person> optionalPerson = getPerson();
        if (optionalPerson.isEmpty()) {
            return;
        }
    }

    // ✅
    void correctUsage2() {
        Optional<Person> optionalPerson = getPerson();
        if (optionalPerson.isPresent()) {
            // do actual work!
        }
    }

    // ✅
    Optional<String> incorrectReadUsage() {
        Optional<Person> optionalPerson = getPerson();
        return optionalPerson.isPresent()
                ? Optional.ofNullable(optionalPerson.get().name) : Optional.empty();
    }

    // ✅✅
    // Use Optional.map instead
    Optional<String> correctReadUsage() {
        return getPerson().map(p -> p.name);
    }

    // ✅
    void incorrectWriteUsage(String input) {
        Optional<Person> optionalPerson = getPerson();
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.name = input;
        }
    }

    // ✅✅
    void correctWriteUsage(String input) {
        getPerson().ifPresent(p -> p.name = input);
    }

}
