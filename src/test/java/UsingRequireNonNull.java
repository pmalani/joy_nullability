import java.util.Objects;

class UsingRequireNonNull {

    class ProductType {

    }

    class Product {
        ProductType productType;
    }

    class LineItem {
        Product product;
    }

    // Hmm...
    // Since the check versus the usage are right after each other;
    // this doesn't add any value IMHO
    // may be except for the custom message
    // And, what happened to good-old assertions?
    ProductType getProductType(LineItem lineItem) {
        Objects.requireNonNull(lineItem, "line item must not be null");
        Objects.requireNonNull(lineItem.product, "product must not be null");
        return lineItem.product.productType;
    }

}
