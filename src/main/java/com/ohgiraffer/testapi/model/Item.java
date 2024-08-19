package com.ohgiraffer.testapi.model;

import com.ohgiraffer.testapi.model.enumtype.ItemType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private String description;

    private int price;

    @Builder
    public Item(String name, ItemType itemType, String description, int price) {
        this.name = name;
        this.itemType = itemType;
        this.description = description;
        this.price = price;
    }
}
