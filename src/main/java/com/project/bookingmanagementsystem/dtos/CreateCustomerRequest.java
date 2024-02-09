package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCustomerRequest {
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
}
