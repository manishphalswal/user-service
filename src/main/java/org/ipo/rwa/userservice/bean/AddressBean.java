package org.ipo.rwa.userservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBean {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer zipcode;
    private String country;

    private GeoLocationBean geoLocation;
}
