package com.Demo.FoodCity.controller;

import com.Demo.FoodCity.dto.RequestItemDto;
import com.Demo.FoodCity.dto.response.ResponseItemDto;
import com.Demo.FoodCity.paginated.PaginatedItemResponseDto;
import com.Demo.FoodCity.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public String saveItem(RequestItemDto dto) {
        itemService.saveItem(dto);
        return "Saved";
    }

    @GetMapping("/{code}")
    public ResponseItemDto findItem(@PathVariable String code) {
        return itemService.findItem(code);

    }

    @DeleteMapping(params = "code")
    public String deleteItem(@RequestParam String code) {
        itemService.deleteItem(code);
        return "Item delete ";
    }

    @PutMapping(params = "code")
    public String updateItem(@RequestBody RequestItemDto dto, @RequestParam String code) {
        itemService.updateItem(dto, code);
        return "Item update ";
    }

    @GetMapping(path = "/all", params = {"page", "size"})
    public PaginatedItemResponseDto findAllItem(@RequestParam int page, @RequestParam int size) {
        return itemService.findAllItems(page, size);

    }
    @GetMapping(path = "/search", params = {"page", "size","text"})
    public PaginatedItemResponseDto SearchItem(@RequestParam int page, @RequestParam int size, @RequestParam String text) {
        return itemService.SearchItem(text,page, size);

    }
}
