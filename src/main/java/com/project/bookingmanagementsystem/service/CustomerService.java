package service;

import Models.Customer;
import dtos.CreateCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    public Customer createCustomer(CreateCustomerRequest request) {
        String email= request.getEmail();
        Optional<Customer> existingCustomer=customerRepository.findCustomerByEmail(request.getEmail());
        if(existingCustomer.isPresent()){
            throw new RuntimeException("already present");
        }
        Customer customer= Customer.builder()
                .email(request.getEmail())
                .city(request.getCity())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .build();
       return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
       return customerRepository.findById(id)
               .orElseThrow(()->new RuntimeException("no customer"));

    }

    public Customer getCustomerInternal(Long customerId) {
        return customerRepository.findById(customerId)
                .orElse(null);
    }
}
