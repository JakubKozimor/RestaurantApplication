package restaurant.service;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.components.TablesComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceAddToOrderTest {

    @Autowired
    RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();

    @MockBean
    TablesComponent theTablesComponent;

    private TablesComponent tables;

    @Before
    public void setUp() {
        this.tables = new TablesComponent();

        when(restaurantService.theTablesComponent.getMyRestaurant()).thenReturn(tables.getMyRestaurant());

    }

    @After
    public void tearDown() {
        this.tables = null;
    }

    @Test
    public void addOrderTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 6, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 2));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1, 3));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(3, 2, 1, 3, 4));
        List<Integer> list5 = new ArrayList<>(Arrays.asList(3, 4));

        restaurantService.addOrder(1, list);
        restaurantService.addOrder(2, list1);
        restaurantService.addOrder(3, list2);
        restaurantService.addOrder(4, list3);

        assertThat("failure: table should be: {1, 2, 3}", list, is(tables.getTable1()));
        assertThat("failure: table should be: {1, 2, 6, 3}", list1, is(tables.getTable2()));
        assertThat("failure: table should be: {1, 2, 3, 3, 2}", list2, is(tables.getTable3()));
        assertThat("failure: table should be: {1, 2, 3, 4, 5, 3, 2, 1, 3}", list3, is(tables.getTable4()));

        restaurantService.addOrder(1, list1);
        List<Integer> result = Stream.concat(list.stream(), list1.stream())
                .collect(Collectors.toList());
        restaurantService.addOrder(2, list2);
        List<Integer> result1 = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        restaurantService.addOrder(3, list4);
        List<Integer> result2 = Stream.concat(list2.stream(), list4.stream())
                .collect(Collectors.toList());
        restaurantService.addOrder(4, list5);
        List<Integer> result3 = Stream.concat(list3.stream(), list5.stream())
                .collect(Collectors.toList());

        assertThat("failure: table should be: {1, 2, 3, 1, 2, 6, 3}", result, is(tables.getTable1()));
        assertThat("failure: table should be: {1, 2, 6, 3, 1, 2, 3, 3, 2}", result1, is(tables.getTable2()));
        assertThat("failure: table should be: {1, 2, 3, 3, 2, 3, 2, 1, 3, 4}", result2, is(tables.getTable3()));
        assertThat("failure: table should be: {1, 2, 3, 4, 5, 3, 2, 1, 3, 3, 4)}", result3, is(tables.getTable4()));

    }


}
