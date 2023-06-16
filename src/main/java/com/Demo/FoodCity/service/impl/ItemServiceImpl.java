package com.Demo.FoodCity.service.impl;

import com.Demo.FoodCity.dto.RequestItemDto;
import com.Demo.FoodCity.dto.response.ResponseItemDto;
import com.Demo.FoodCity.entity.Item;
import com.Demo.FoodCity.paginated.PaginatedItemResponseDto;
import com.Demo.FoodCity.repo.ItemRepo;
import com.Demo.FoodCity.service.ItemService;
import com.Demo.FoodCity.util.IdManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    final ItemRepo itemRepo;
    final IdManager idManager;

    public ItemServiceImpl(ItemRepo itemRepo, IdManager idManager) {
        this.itemRepo = itemRepo;
        this.idManager = idManager;
    }

    @Override
    public void saveItem(RequestItemDto dto) {
        Item i = new Item(
                idManager.generate(5,"I"),
                dto.getItemName(),
                dto.getDescription(),
                dto.getQtyOnHand(),
                dto.getPrice()
        );
        itemRepo.save(i);
    }

    @Override
    public void updateItem(RequestItemDto dto, String code) {
        Optional<Item> selectedItem = itemRepo.findById(code);
        if (selectedItem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        Item item = selectedItem.get();
        item.setItemName(dto.getItemName());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setQtyOnHand(dto.getQtyOnHand());
        itemRepo.save(item);
    }

    @Override
    public void deleteItem(String code) {
        itemRepo.deleteById(code);
    }

    @Override
    public ResponseItemDto findItem(String code) {
        Optional<Item> selectedItem = itemRepo.findById(code);
        if (selectedItem.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        Item item = selectedItem.get();
        return new ResponseItemDto(
                item.getItem_code(),
                item.getItemName(),
                item.getDescription(),
                item.getQtyOnHand(),
                item.getPrice()
        );
    }

    @Override
    public PaginatedItemResponseDto findAllItems(int page, int size) {
        long count = itemRepo.count();
        Page<Item> all = itemRepo.findAll(PageRequest.of(page, size));
        List<ResponseItemDto> dtos = new ArrayList<>();
        for (Item i : all
        ) {
            dtos.add(
                    new ResponseItemDto(
                           i.getItem_code(),
                            i.getItemName(),
                            i.getDescription(),
                            i.getQtyOnHand(),
                            i.getPrice()
                    )
            );
        }
        return new PaginatedItemResponseDto(
                count,dtos
        );
    }

    @Override
    public PaginatedItemResponseDto SearchItem(String text, int page, int size) {
        text="%"+text+"%";
        long count = itemRepo.getCountWithSearchText(text);

        Page<Item> all = itemRepo.findAllWithSearchText(text,PageRequest.of(page, size));
        List<ResponseItemDto> dtos = new ArrayList<>();
        for (Item i : all
        ) {
            dtos.add(
                    new ResponseItemDto(
                            i.getItemName(),
                            i.getItemName(),
                            i.getDescription(),
                            i.getQtyOnHand(),
                            i.getPrice()
                    )
            );
        }
        return new PaginatedItemResponseDto(
                count,dtos
        );
    }

}
