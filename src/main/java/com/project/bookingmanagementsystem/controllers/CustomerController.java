package controllers;

import Models.Customer;
import Models.User;
import dtos.CreateCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest request){
        return customerService.createCustomer(request);
    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
}
