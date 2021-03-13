package org.ipo.rwa.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class User {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String phone;
    private String email;

    private Address address;

    private String occupation;
    private String website;

    private Company company;

}
