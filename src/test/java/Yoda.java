import java.util.Objects;

class Yoda {

    // ❌
    // NPE if name is null!
    boolean isBart1(String name) {
        return name.equals("Bart");
    }

    // ✅
    boolean isBart2(String name) {
        return "Bart".equals(name);
    }

    // ✅✅
    boolean isBart3(String name) {
        return Objects.equals(name, "Bart");
    }

}
