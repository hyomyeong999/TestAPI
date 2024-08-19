package com.ohgiraffer.testapi.repository;

import com.ohgiraffer.testapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
