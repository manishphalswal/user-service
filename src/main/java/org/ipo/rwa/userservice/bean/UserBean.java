package org.ipo.rwa.userservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserBean {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String phone;
    private String email;

    private AddressBean addressBean;

    private String occupation;
    private String website;

    private CompanyBean company;

}
