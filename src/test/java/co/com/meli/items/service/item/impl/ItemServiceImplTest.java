package co.com.meli.items.service.item.impl;

import co.com.meli.items.model.item.Item;
import co.com.meli.items.repository.item.ItemRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ItemServiceImplTest {

  @InjectMocks
  private ItemServiceImpl itemService;

  @Mock
  private ItemRepository itemRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void findByIdReturnItemWhenExistTest() {
    String itemId = "MLA1";

    Mockito.doReturn(Optional.of(Item.builder()
        .id(itemId)
        .build()))
        .when(itemRepository)
        .findById(itemId);

    Optional<Item> item = itemService.findById(itemId);
    Assertions.assertThat(item).isPresent();
    Assertions.assertThat(item.get().getId()).isEqualTo(itemId);
  }

  @Test
  public void findByIdReturnEmptyWhenNotExistTest() {
    String itemId = "MLA1";

    Mockito.doReturn(Optional.empty())
        .when(itemRepository)
        .findById(itemId);

    Optional<Item> item = itemService.findById(itemId);
    Assertions.assertThat(item).isNotPresent();
  }

  @Test
  public void saveTest() {
    Item item = Item.builder()
        .id("MLA1")
        .build();

    itemService.save(item);
    Mockito.verify(itemRepository, Mockito.times(1))
        .save(item);
  }


}