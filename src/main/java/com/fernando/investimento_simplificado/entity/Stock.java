package com.fernando.investimento_simplificado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @OneToOne
    private UUID stockId;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "description")
    private String description;




}
