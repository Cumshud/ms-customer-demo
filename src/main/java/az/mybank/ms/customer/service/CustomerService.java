package az.mybank.ms.customer.service;

import az.mybank.ms.customer.dto.request.CreateCustomerRequest;
import az.mybank.ms.customer.mapper.CustomerMapper;
import az.mybank.ms.customer.model.Customer;
import az.mybank.ms.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public Customer getCustomerWithId(String username, String password, Long id) {
        log.info("username: " + username);
        log.info("password: " + password);

        return customerRepository.findCustomerWithId(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not defined, id: " + id));
    }

    public void createCustomer(CreateCustomerRequest request) {
        customerRepository.createCustomer(request);
    }

}
