import java.util.Objects;

class Yoda {

    // ❌
    // NPE if name is null!
    boolean isBart1(String name) {
        return name.equals("Bart");
    }

    // ✅
    boolean isBart2(String name) {
        return name != null && name.equals("Bart");
    }

    // ✅
    boolean yoda(String name) {
        return "Bart".equals(name);
    }

    // ✅✅
    boolean objectsEquals(String name) {
        return Objects.equals(name, "Bart");
    }

}
