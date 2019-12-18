package restaurant.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.service.RestaurantServiceImpl;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Autowired
    TablesComponent tablesComponent;

    private List<Dish> before = new ArrayList<>();
    private List<Dish> after = new ArrayList<>();
    private Dish dish1 = new Dish(1,"coffee", BigDecimal.valueOf(2),BigDecimal.valueOf(5));
    private Dish dish2 = new Dish(2,"tea",BigDecimal.valueOf(1),BigDecimal.valueOf(3));
    private BigDecimal toPay = BigDecimal.valueOf(0);

    @Test
    public void testAddOrder() {

        // given
        before = tablesComponent.getMyRestaurant(1);
        List<Dish> listOfOrder = new ArrayList<>();
        listOfOrder.add(dish1);
        listOfOrder.add(dish2);
        after = new ArrayList<>();
        after.addAll(before);
        after.addAll(listOfOrder);

        // when
        restaurantService.addOrder(1, listOfOrder);

        //then
        assertThat(after, is(equalTo(tablesComponent.getMyRestaurant(1))));
    }

    @Test
    public void testRemoveElementFromOrder() {

        // given
        before = tablesComponent.getMyRestaurant(1);
        after.addAll(before);
        before.add(dish1);
        before.add(dish1);
        before.add(dish2);
        List<Dish> listToRemove = new ArrayList<>();
        listToRemove.add(dish1);
        listToRemove.add(dish2);
        after.add(dish1);

        // when
        restaurantService.removeElementFromOrder(1,listToRemove);

        // then
        assertThat(after,is(equalTo(tablesComponent.getMyRestaurant(1))));
    }

    @Test
    public void testRemoveOrderWithoutAcceptPayment() {

        // given
        before = tablesComponent.getMyRestaurant(1);
        before.add(dish1);
        before.add(dish2);
        before.add(dish2);
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
        before.add(dish1);
        before.add(dish1);
        before.add(dish2);
        tablesComponent.setMyRestaurant(1, before);
        toPay = toPay.add(dish1.getPriceSell());
        toPay = toPay.add(dish1.getPriceSell());
        toPay = toPay.add(dish2.getPriceSell());

        //when
        BigDecimal toPayFromService = restaurantService.acceptPaymentAndCleanOrder(1);

        //then
        assertThat(toPay, is(equalTo(toPayFromService)));
        assertThat(tablesComponent.getMyRestaurant(1).size(),is(equalTo(0)));
    }
}
