package com.fernando.investimento_simplificado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "tb_account_stock")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountStock {

    @EmbeddedId
    private AccountStockId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne()
    @Column(name = "stock_id")
    private Stock stock;

    @Column(name = "quantity")
    private Integer quantity;
}
