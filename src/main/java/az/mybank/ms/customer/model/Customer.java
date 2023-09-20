package az.mybank.ms.customer.model;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private String surname;
    private String cif;
    private String pin;

}
