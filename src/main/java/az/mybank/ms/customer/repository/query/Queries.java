package az.mybank.ms.customer.repository.query;

public enum Queries {

    FIND_CUSTOMER_BY_ID("findByCustomerId"),
    CREATE_CUSTOMER("createCustomer");


    private final String key;

    Queries(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

}