package az.mybank.ms.customer.repository;

import az.mybank.ms.customer.dto.request.CreateCustomerRequest;
import az.mybank.ms.customer.model.Customer;
import az.mybank.ms.customer.repository.query.Queries;
import az.mybank.ms.customer.repository.query.QueryHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final QueryHolder queryHolder;
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public Optional<Customer> findCustomerWithId(Long id) {
        var results = namedJdbcTemplate.query(
                queryHolder.get(Queries.FIND_CUSTOMER_BY_ID),
                Map.of("id", id),
                new BeanPropertyRowMapper<>(Customer.class));

        return results.stream().findFirst();
    }

    public void createCustomer(CreateCustomerRequest request) {
        var params = Map.of(
                "id", request.getId(),
                "name", request.getName(),
                "surname", request.getSurname(),
                "cif", request.getCif(),
                "address", request.getAddress(),
                "pin", request.getAddress()
        );

        namedJdbcTemplate.update(queryHolder.get(Queries.CREATE_CUSTOMER), params);
    }

}
