package co.com.meli.items.api.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResource {

  private String id;

  private String title;

  private Float price;

  private String site_id;

}
