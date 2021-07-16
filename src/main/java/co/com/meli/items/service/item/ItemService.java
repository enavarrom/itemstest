package co.com.meli.items.service.item;

import co.com.meli.items.model.item.Item;
import java.util.Optional;

public interface ItemService {

  Optional<Item> findById(String id);

  void save(Item item);

}
