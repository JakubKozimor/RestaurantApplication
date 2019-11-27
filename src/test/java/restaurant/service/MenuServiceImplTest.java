package restaurant.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import restaurant.components.DateComponent;
import restaurant.components.DaySummaryComponent;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {

    @Autowired
    MenuServiceImpl menuService = new MenuServiceImpl();

    @MockBean
    DateComponent thDateComponent;

    @MockBean
    DaySummaryComponent theDaySummaryComponent;

    private LocalDate date;

    @Before
    public void setUp() {
        this.date = LocalDate.now();
        Map<LocalDate, HashMap<Integer, Integer>> day = new HashMap<>();
        HashMap<Integer, Integer> summary = new HashMap<>();
        summary.put(1, 3);
        summary.put(2, 7);
        summary.put(3, 2);
        summary.put(4, 9);
        day.put(date, summary);

        when(menuService.theDaySummaryComponent.getDay()).thenReturn(day);
        when(menuService.thDateComponent.getDate()).thenReturn(date);
    }

    @After
    public void tearDown() {
        this.date = null;
    }


    @Test
    public void TestGetListOfDishWithQuantity() {
        HashMap<Integer, Integer> summaryOfDay;
        summaryOfDay = menuService.getListOfDishWithQuantity();

        assertThat("failure: summary of day is not empty", summaryOfDay.isEmpty(), is(false));
        assertThat("failure: size is equal to 4", summaryOfDay.size(), is(equalTo(4)));
        assertThat("failure: quantity product witch id 1 is 3", summaryOfDay.get(1), is(equalTo(3)));
        assertThat("failure: quantity product witch id 2 is 7", summaryOfDay.get(2), is(equalTo(7)));
        assertThat("failure: quantity product witch id 3 is 2", summaryOfDay.get(3), is(equalTo(2)));
        assertThat("failure: quantity product witch id 4 is 9", summaryOfDay.get(4), is(equalTo(9)));
    }
}
