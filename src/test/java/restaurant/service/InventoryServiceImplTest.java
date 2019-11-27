package restaurant.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Entity.Inventory;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class InventoryServiceImplTest {

    private List<Inventory> listOfProductsFromService;
    private InventoryServiceImpl theInventoryService;

    @Before
    public void setUp() {
        System.out.println("InventoryServiceImplTest.setUp");
        this.theInventoryService = new InventoryServiceImpl();
        this.listOfProductsFromService = theInventoryService.getListOfProducts();

    }

    @After
    public void tearDown() {
        System.out.println("InventoryServiceImplTest.tearDown");
        this.theInventoryService = null;
        this.listOfProductsFromService = null;
    }

    @Test
    public void TestGetListOfProducts() {

        assertThat("failure: size should be 2", listOfProductsFromService.size(), is(equalTo(2)));
        assertThat("failure: list should not be null", listOfProductsFromService, is(notNullValue()));

    }

    @Test
    public void TestRemoveFromInventory() {
        theInventoryService.removeFromInventory(1, 2);
        theInventoryService.removeFromInventory(2, 4);

        assertThat("failure: quantity should be 1", listOfProductsFromService.get(0).getQuantity(), is(1));
        assertThat("failure: quantity should be 2", listOfProductsFromService.get(1).getQuantity(), is(2));

        theInventoryService.removeFromInventory(1, 1);
        theInventoryService.removeFromInventory(2, 1);

        assertThat("failure: quantity should be 0", listOfProductsFromService.get(0).getQuantity(), is(0));
        assertThat("failure: quantity should be 1", listOfProductsFromService.get(1).getQuantity(), is(1));
    }

    @Test
    public void TestAddToInventory() {
        theInventoryService.addToInventory(1, 3);
        theInventoryService.addToInventory(1, 2);
        theInventoryService.addToInventory(2, 1);
        theInventoryService.addToInventory(2, 6);

        assertThat("failure: quantity should be 8", listOfProductsFromService.get(0).getQuantity(), is(8));
        assertThat("failure: quantity should be 13", listOfProductsFromService.get(1).getQuantity(), is(13));

        theInventoryService.addToInventory(1, 55);
        theInventoryService.addToInventory(2, 38);

        assertThat("failure: quantity should be 8", listOfProductsFromService.get(0).getQuantity(), is(63));
        assertThat("failure: quantity should be 13", listOfProductsFromService.get(1).getQuantity(), is(51));
    }
}
