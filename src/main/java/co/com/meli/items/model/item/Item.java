package co.com.meli.items.model.item;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

  @Id
  private String id;

  private String title;

  private Float price;

  private String site_id;

}
