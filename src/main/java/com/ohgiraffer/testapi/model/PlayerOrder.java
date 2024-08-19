package com.ohgiraffer.testapi.model;

import com.ohgiraffer.testapi.model.enumtype.MethodOfPurchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerOrderId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private MethodOfPurchase methodOfPurchase;

    private LocalDate orderDate;
}
