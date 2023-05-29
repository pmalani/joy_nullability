import java.util.NoSuchElementException;
import java.util.Optional;

public class UsingOptionalOrElse {

    Optional<Person> getPerson(int id) {
        return Optional.empty();
    }

    void processPerson(Person person) {

    }

    void processPersonIfPresent(int id) {
        Optional<Person> optionalPerson = getPerson(id);
        optionalPerson.ifPresent(this::processPerson);
    }

    void processPersonOrElse1(int id) {
        processPerson(getPerson(id).orElse(null));
    }

    // ❌
    // we don't want to create a new person everytime
    void processPeronOrElse2(int id) {
        processPerson(getPerson(id).orElse(new Person()));
    }

    // ✅
    void processPersonOrElseGet(int id) {
        processPerson(getPerson(id).orElseGet(Person::new));
    }

    // not appropriate here IMHO
    void processPersonOrElseThrow1(int id) {
        processPerson(getPerson(id).orElseThrow());
    }

    // not appropriate here IMHO
    void processPersonElseThrow2(int id) {
        processPerson(getPerson(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "no person found with id:" + id)));
    }

}
