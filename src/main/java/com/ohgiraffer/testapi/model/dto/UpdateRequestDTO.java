package com.ohgiraffer.testapi.model.dto;

import com.ohgiraffer.testapi.model.enumtype.ItemType;
import lombok.Data;

@Data
public class UpdateRequestDTO {

    private String name;
    private ItemType itemType;
    private String description;
    private int price;
}
