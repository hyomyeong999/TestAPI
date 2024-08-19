package com.ohgiraffer.testapi.service;

import com.ohgiraffer.testapi.model.Item;
import com.ohgiraffer.testapi.model.dto.UpdateRequestDTO;
import com.ohgiraffer.testapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    public Optional<Item> getOneItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public boolean updateItem(long id, UpdateRequestDTO updateItemInfo) {
        Optional<Item> findedItem = itemRepository.findById(id);
        if (findedItem.isPresent()) {
            Item updatedItem = findedItem.get();
            updatedItem = Item.builder()
                    .name(updateItemInfo.getName())
                    .itemType(updateItemInfo.getItemType())
                    .description(updateItemInfo.getDescription())
                    .price(updateItemInfo.getPrice())
                    .build();

            itemRepository.save(updatedItem);
            return true;
        }
        return false;
    }

    public boolean deleteItem(long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
