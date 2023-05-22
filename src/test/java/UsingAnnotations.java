import javax.annotation.Nonnull;

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

    // whose nonnull? jsr305, lombok, spring, etc.
    // who enforces? ide, findbugs, checker, etc.
    // but not runtime!
    @Nonnull
    ProductType getProductType(@Nonnull LineItem lineItem) {
        return lineItem.product.productType;
    }

}
