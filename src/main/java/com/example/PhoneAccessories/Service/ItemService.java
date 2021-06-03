package com.example.PhoneAccessories.Service;

import com.example.PhoneAccessories.Dto.ItemDto;
import com.example.PhoneAccessories.Model.Item;
import com.example.PhoneAccessories.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public void save(@NotNull Item item) {
        itemRepository.save(item);
    }
    public Set<ItemDto> returnAllCases() {
        List<Item> items = itemRepository.findAll();
        Set<ItemDto> collection =new HashSet<>();
        for(Item item : items) {
            ItemDto itemDto = new ItemDto();
            itemDto.setHeader(item.getHeader());
            itemDto.setPrice(item.getPrice());
            itemDto.setPcs(item.getPiece().getPieces());
            collection.add(itemDto);
        }
        return collection;
    }
    public void deleteById(@NotNull Long id) {
        itemRepository.deleteById(id);
    }
}
