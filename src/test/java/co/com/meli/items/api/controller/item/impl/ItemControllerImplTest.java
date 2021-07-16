package co.com.meli.items.api.controller.item.impl;

import co.com.meli.items.api.controller.item.ItemController;
import co.com.meli.items.api.resource.ItemResource;
import co.com.meli.items.model.item.Item;
import co.com.meli.items.repository.item.ItemRepository;
import co.com.meli.items.service.item.ItemService;
import com.google.gson.Gson;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest({ItemController.class, ItemService.class})
class ItemControllerImplTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ItemRepository itemRepository;

  @Test
  public void findByIdTest() throws Exception {
    String item1 = "MLA1";

    Item item = new Item();
    item.setId(item1);

    Mockito.doReturn(Optional.of(item))
        .when(itemRepository)
        .findById(item1);

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/items/".concat(item1)))
    .andReturn();

    Gson gson = new Gson();
    ItemResource itemResource = gson.fromJson(mvcResult.getResponse().getContentAsString(), ItemResource.class);
    Assertions.assertEquals(itemResource.getId(), item1);
  }

  @Test
  public void saveTest() throws Exception {
    String itemId = "MLA1";

    ItemResource itemResource = ItemResource.builder()
        .id(itemId)
        .build();

    Gson gson = new Gson();
    String inputJson = gson.toJson(itemResource);

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/items/")
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

    String content = mvcResult.getResponse().getContentAsString();
    Boolean result = gson.fromJson(content, Boolean.class);
    Assertions.assertTrue(result);

    Mockito.verify(itemRepository, Mockito.times(1))
        .save(Mockito.any(Item.class));
  }

  @Test
  public void mapperItemTest() {
    ModelMapper mapper = new ModelMapper();
    Item item = Item.builder()
        .id("MLA1")
        .title("MLA1")
        .site_id("MLA")
        .price(200f)
        .build();

    ItemResource itemResource = mapper.map(item, ItemResource.class);
    Assertions.assertEquals(itemResource.getId(), item.getId());
    Assertions.assertEquals(itemResource.getTitle(), item.getTitle());
    Assertions.assertEquals(itemResource.getSite_id(), item.getSite_id());
    Assertions.assertEquals(itemResource.getPrice(), item.getPrice());
  }

  @Test
  public void mapperItemResourceTest() {
    ModelMapper mapper = new ModelMapper();
    ItemResource itemResource = ItemResource.builder()
        .id("MLA1")
        .title("MLA1")
        .site_id("MLA")
        .price(200f)
        .build();

    Item item = mapper.map(itemResource, Item.class);
    Assertions.assertEquals(itemResource.getId(), item.getId());
    Assertions.assertEquals(itemResource.getTitle(), item.getTitle());
    Assertions.assertEquals(itemResource.getSite_id(), item.getSite_id());
    Assertions.assertEquals(itemResource.getPrice(), item.getPrice());
  }
}