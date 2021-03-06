package org.ipo.rwa.userservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class AddressBean implements Serializable {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer zipcode;
    private String country;

    private GeoLocationBean geoLocation;
}
