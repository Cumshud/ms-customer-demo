package az.mybank.ms.customer.mapper;

import az.mybank.ms.customer.model.Customer;
import az.mybank.ms.customer.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static az.mybank.ms.customer.config.properties.ApplicationConstants.COMPONENT_MODEL_SPRING;

@Mapper(componentModel = COMPONENT_MODEL_SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toCustomerDto(Customer customerDto);

    List<CustomerDto> toCustomerDtos(List<Customer> customerDto);

}