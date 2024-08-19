package com.ohgiraffer.testapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerOrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_order_id")
    private PlayerOrder playerOrder;

    // 구매 순번
    private long PurchaseOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item item;

    // 구매 수량
    private int quantity;
}
