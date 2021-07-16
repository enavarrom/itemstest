package co.com.meli.items.api.controller.item;

import co.com.meli.items.api.resource.ItemResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "item-api")
public interface ItemController {

  @ApiOperation(value = "Find a item by id")
  ResponseEntity<ItemResource> findById(@PathVariable final String id);

  @ApiOperation(value = "Save a Item in Database")
  ResponseEntity<Boolean> save(@ApiParam(value = "The Item to Save") @RequestBody ItemResource itemResource);

}
