package com.onlineshop.business.adress.domain;

import com.onlineshop.business.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String firstLineAddress;

    @Column
    private String secondLineAddress;

    @Column
    private String postcode;

    @Column
    private String city;

    @Column
    private Integer phoneNumber;

    @Column
    private String email;

    @Column
    private String additionalInformation;

    @OneToOne()
    private Order order;
}
