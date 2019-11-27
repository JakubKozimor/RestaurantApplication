package restaurant.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.components.DateComponent;
import restaurant.components.TablesComponent;


import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceRemoveFromOrderTest {

    @Autowired
    RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();

    @MockBean
    TablesComponent theTablesComponent;

    @MockBean
    MenuService theMenuService;

    @MockBean
    DateComponent theDateComponent;

    private LocalDate date = LocalDate.now();
    private TablesComponent tables;
    private HashMap<Integer, Integer> summary;

    @Before
    public void setUp() {
        this.tables = new TablesComponent();
        this.date = LocalDate.now();
        this.summary = new HashMap<>();

        tables.getTable1().addAll(Arrays.asList(1, 3, 6, 3, 3));
        tables.getTable2().addAll(Arrays.asList(1, 4, 3));
        tables.getTable3().addAll(Arrays.asList(3, 1, 7, 1, 7));

        summary.put(1, 3);
        summary.put(2, 7);
        summary.put(3, 2);
        summary.put(4, 9);

        when(restaurantService.theTablesComponent.getMyRestaurant()).thenReturn(tables.getMyRestaurant());
        when(restaurantService.theMenuService.getListOfDishWithQuantity()).thenReturn(summary);
    }

    @After
    public void tearDown() {
        this.tables = null;
        this.date = null;
        this.summary = null;
    }

    @Test
    public void testRemoveElementFromOrder() {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 7, 1));

        restaurantService.removeElementFromOrder(1, list);
        restaurantService.removeElementFromOrder(2, list1);
        restaurantService.removeElementFromOrder(3, list2);

        assertThat("failure: table should be: {6, 3, 3}", tables.getTable1(), is(Arrays.asList(6, 3, 3)));
        assertThat("failure: table should be: {4, 3}", tables.getTable2(), is(Arrays.asList(4, 3)));
        assertThat("failure: table should be: {1, 7}", tables.getTable3(), is(Arrays.asList(1, 7)));

    }

    @Test
    public void testRemoveOrderWithoutAcceptPayment() {
        restaurantService.removeOrderWithoutAcceptPayment(1);
        restaurantService.removeOrderWithoutAcceptPayment(2);
        restaurantService.removeOrderWithoutAcceptPayment(3);

        assertThat("failure: table should be empty", tables.getMyRestaurant().get(1).isEmpty(), is(true));
        assertThat("failure: table should be empty", tables.getMyRestaurant().get(2).isEmpty(), is(true));
        assertThat("failure: table should be empty", tables.getMyRestaurant().get(3).isEmpty(), is(true));

    }

    @Test
    public void testAcceptPaymentAndCleanOrder() {
        restaurantService.acceptPaymentAndCleanOrder(2);

        assertThat("failure: table is not empty", summary.isEmpty(), is(false));
        assertThat("failure: table size is 4", summary.size(), is(equalTo(4)));
        assertThat("failure: quantity product witch id 1 is 4", summary.get(1), is(equalTo(4)));
        assertThat("failure: quantity product witch id 2 is 7", summary.get(2), is(equalTo(7)));
        assertThat("failure: quantity product witch id 3 is 3", summary.get(3), is(equalTo(3)));
        assertThat("failure: quantity product witch id 4 is 10", summary.get(4), is(equalTo(10)));
    }

}
