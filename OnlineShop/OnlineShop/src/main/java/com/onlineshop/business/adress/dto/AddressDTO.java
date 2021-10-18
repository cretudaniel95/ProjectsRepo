package com.onlineshop.business.adress.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddressDTO {

    private String firstName;
    private String lastName;
    private String firstLineAddress;
    private String secondLineAddress;
    private String postcode;
    private String city;
    private Integer phoneNumber;
    private String email;
    private String additionalInformation;
}
