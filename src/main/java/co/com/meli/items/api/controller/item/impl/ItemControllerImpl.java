package co.com.meli.items.api.controller.item.impl;

import co.com.meli.items.api.controller.item.ItemController;
import co.com.meli.items.api.resource.ItemResource;
import co.com.meli.items.model.item.Item;
import co.com.meli.items.service.item.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/items", produces = "application/hal+json")
public class ItemControllerImpl implements ItemController {

  @Autowired
  private ItemService itemService;

  private static final ModelMapper MAPPER = new ModelMapper();

  @Override
  @GetMapping(value = "/{id}")
  public ResponseEntity<ItemResource> findById(@PathVariable final String id) {
    return itemService.findById(id)
        .map(item -> ResponseEntity.ok(MAPPER.map(item, ItemResource.class)))
        .orElse(ResponseEntity.notFound().build());
  }

  @Override
  @PostMapping(value = "/")
  public ResponseEntity<Boolean> save(@RequestBody ItemResource itemResource) {
      itemService.save(MAPPER.map(itemResource, Item.class));
      return ResponseEntity.ok(Boolean.TRUE);
  }
}
