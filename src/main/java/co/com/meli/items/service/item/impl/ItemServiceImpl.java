package co.com.meli.items.service.item.impl;

import co.com.meli.items.model.item.Item;
import co.com.meli.items.repository.item.ItemRepository;
import co.com.meli.items.service.item.ItemService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public Optional<Item> findById(String id) {
    return itemRepository.findById(id);
  }

  @Override
  public void save(Item item) {
    itemRepository.save(item);
  }

}
