import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    Optional<Person> getPerson(long id) {
        return Optional.empty();
    }

    List<Person> usingOptionalInAStream(Collection<Long> ids) {
        return Stream.ofNullable(ids)
                .flatMap(Collection::stream)
                .map(this::getPerson)
                .filter(Optional::isPresent) // ✅
                .map(Optional::get) // ✅
                .collect(Collectors.toList());
    }

    class ProductType {

    }

    class Product {
        ProductType productType;
    }

    class LineItem {
        Product product;

        Optional<ProductType> getProductType() {
            return Optional.ofNullable(product)
                    .map(p -> p.productType);
        }
    }

    //region violates Law of Demeter
    // ❌❌
    // safe navigation the old-fashioned way
    ProductType getProductType1(LineItem lineItem) {
        return lineItem.product.productType;
    }

    // ❌
    // should return optional
    ProductType getProductType2(LineItem lineItem) {
        if (lineItem == null) {
            return null;
        }
        Product product = lineItem.product;
        if (product == null) {
            return null;
        }
        return product.productType;
    }

    // ✅
    Optional<ProductType> getProductType3(LineItem lineItem) {
        return Optional.ofNullable(lineItem)
                .map(lineItem1 -> lineItem1.product)
                .map(product -> product.productType);
    }
    //endregion

    // ✅✅
    // In many (if not most) cases this method can be inlined
    Optional<ProductType> getProductType4(LineItem lineItem) {
        return Optional.ofNullable(lineItem)
                .flatMap(LineItem::getProductType); // map will not work; why?
    }

}
