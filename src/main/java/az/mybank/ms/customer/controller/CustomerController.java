package az.mybank.ms.customer.controller;

import az.mybank.ms.customer.dto.request.CreateCustomerRequest;
import az.mybank.ms.customer.model.Customer;
import az.mybank.ms.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomerWithId(@RequestHeader(value = "user", required = false) String username,
                                      @RequestHeader(value = "password", required = false) String password,
                                      @PathVariable Long id) {
        return customerService.getCustomerWithId(username, password, id);
    }

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }


}
