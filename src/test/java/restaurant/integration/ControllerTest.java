package restaurant.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.controller.RestaurantController;
import restaurant.data.DishRepository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    RestaurantController restaurantController;

    @Autowired
    DishRepository dishRepository;

    @Autowired
    TablesComponent tablesComponent;

    @Test
    public void testGetOrder() {

        // given
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));

        // when
        restaurantController.getOrder(1, list);

        // then
        assertThat(2, is(equalTo(tablesComponent.getMyRestaurant(1).size())));
    }
}
