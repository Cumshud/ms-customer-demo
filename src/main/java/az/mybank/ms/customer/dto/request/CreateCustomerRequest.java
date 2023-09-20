package az.mybank.ms.customer.dto.request;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private Integer id;
    private String name;
    private String surname;
    private String cif;
    private String address;
    private String pin;

}
