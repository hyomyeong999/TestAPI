package com.ohgiraffer.testapi.controller;

import com.ohgiraffer.testapi.model.Item;
import com.ohgiraffer.testapi.model.dto.UpdateRequestDTO;
import com.ohgiraffer.testapi.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/*
    swagger-ui 3.x 버젼 이상
        http://localhost:8080/swagger-ui/index.html
    swagger-ui 3.x 버젼 미만
        http://localhost:8080/swagger-ui.html
 */

@Tag(name="Item", description = "Item CRUD 관련 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;


    @Operation(
            summary = "아이템 전체 조회",
            description = "아이템을 전체 조회합니다."
    )
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItem();
    }

    @Operation(
            summary = "아이디에 해당하는 아이템 한 개 조회",
            description = "아이디에 해당하는 아이템을 조회합니다."
    )
    @ApiResponse(
            responseCode = "200",
            description = ""
    )
    // 특정 아이템 조회
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> oneItemById = itemService.getOneItemById(id);

        return oneItemById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 새로운 아이템 생성
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    // 아이템 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody UpdateRequestDTO updateItemInfo) {
        if (itemService.updateItem(id, updateItemInfo)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 아이템 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemService.deleteItem(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
