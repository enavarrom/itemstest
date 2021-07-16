package co.com.meli.items.repository.item;

import co.com.meli.items.model.item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
