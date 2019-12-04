package restaurant.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.Entity.Inventory;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceImplTest {

    @Autowired
    InventoryService inventoryService;

    private List<Inventory> listOfProductFromInventory;

    @Test
    public void testListOfProductsFromInventory() {

        //given
        listOfProductFromInventory = new ArrayList<>();

        //when
        listOfProductFromInventory = inventoryService.getListOfProductsFromInventory();

        //then
        assertThat(listOfProductFromInventory, is(notNullValue()));
    }

    @Test
    public void testAddToInventory() {

        // given
        int forwardedQuantity = 6;
        listOfProductFromInventory = inventoryService.getListOfProductsFromInventory();
        int oldQuantity = inventoryService.getSingleProduct(1).getQuantity();

        // when
        inventoryService.addToInventory(1, forwardedQuantity);

        //then
        assertThat(oldQuantity + forwardedQuantity,
                is(equalTo(inventoryService.getSingleProduct(1).getQuantity())));
    }
    @Test
    public void testRemoveFromInventory() {

        // given
        int forwardedQuantity = 2;
        listOfProductFromInventory = inventoryService.getListOfProductsFromInventory();
        int oldQuantity = inventoryService.getSingleProduct(1).getQuantity();

        // when
        inventoryService.removeFromInventory(1, forwardedQuantity);

        //then
        assertThat(oldQuantity - forwardedQuantity,
                is(equalTo(inventoryService.getSingleProduct(1).getQuantity())));
    }

}
