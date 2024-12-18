package com.fernando.investimento_simplificado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "tb_billingAddress")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillingAddress {
    @Id
    @Column(name = "account_id")
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;


    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;
}
