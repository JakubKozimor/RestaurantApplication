package restaurant.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.components.TablesComponent;
import restaurant.data.Restaurant;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Autowired
    TablesComponent tablesComponent;


    private Restaurant theRestaurant = new Restaurant();

    private List<Integer> before;
    private List<Integer> before1;
    private List<Integer> after;


    @Test
    public void testAddOrder() {

        // given
        before = tablesComponent.getMyRestaurant(1);
        after = new ArrayList<>();
        after.addAll(before);
        after.addAll(theRestaurant.order1);

        // when
        restaurantService.addOrder(1, theRestaurant.order1);

        //then
        assertThat(after, is(equalTo(tablesComponent.getMyRestaurant(1))));

    }

    @Test
    public void testRemoveElementFromOrder() {

        // given
        before = tablesComponent.getMyRestaurant(1);
        before.addAll(theRestaurant.order1);
        after = tablesComponent.getMyRestaurant(1);
        after.addAll(theRestaurant.afterRemove);

        // when
        restaurantService.removeElementFromOrder(1,theRestaurant.order2);

        // then
        assertThat(after,is(equalTo(tablesComponent.getMyRestaurant(1))));

    }

    @Test
    public void testRemoveOrderWithoutAcceptPayment() {

        // given
        tablesComponent.getMyRestaurant(1).addAll(theRestaurant.order1);
        after = new ArrayList<>();

        // when
        restaurantService.removeOrderWithoutAcceptPayment(1);

        // then
        assertThat(tablesComponent.getMyRestaurant(1),is(equalTo(after)));
        assertThat(tablesComponent.getMyRestaurant(1).size(),is(equalTo(0)));
    }

    @Test
    public void testAcceptPaymentAndCleanOrder() {

        // given
        before = new ArrayList<>();
        before1 = Arrays.asList(1, 2);
        tablesComponent.setMyRestaurant(1, before);
        tablesComponent.setMyRestaurant(1, before1);

        //when
        double toPay = restaurantService.acceptPaymentAndCleanOrder(1);

        //then
        assertThat(theRestaurant.getListOfDishes().get(0).getPriceSell()
                + theRestaurant.getListOfDishes().get(1).getPriceSell(),
                is(equalTo(toPay)));
        assertThat(tablesComponent.getMyRestaurant(1).size(),is(equalTo(0)));
    }


}
