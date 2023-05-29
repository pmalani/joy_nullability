import javax.annotation.Nonnull;

// whose nonnull? jsr305, lombok, spring, etc.
// who enforces? ide, findbugs, checker, lombok, etc.
// when compile-time (✅), run-time(❌)?
class UsingAnnotations {

    class ProductType {

    }

    class Product {

        @Nonnull
        ProductType productType;

        public Product(@Nonnull ProductType productType) {
            this.productType = productType;
        }
    }

    class LineItem {

        @Nonnull
        Product product;

        public LineItem(@Nonnull Product product) {
            this.product = product;
        }
    }

    @Nonnull
    ProductType getProductType(@Nonnull LineItem lineItem) {
        return lineItem.product.productType;
    }

}
