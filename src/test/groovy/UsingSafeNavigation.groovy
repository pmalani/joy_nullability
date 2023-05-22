class UsingSafeNavigation {

    class ProductType {

    }

    class Product {
        ProductType productType
    }

    class LineItem {
        Product product
    }

    /**
     * Code is similar to
     * @see UsingOptional#getProductType2(UsingOptional.LineItem)
     */
    ProductType getProductType(LineItem lineItem) {
        return lineItem?.getProduct()?.getProductType()
    }

}
