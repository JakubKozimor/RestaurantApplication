package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Products;
import restaurant.components.DateComponent;
import restaurant.components.DaySummaryComponent;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    DateComponent thDateComponent;

    @Autowired
    DaySummaryComponent theDaySummaryComponent;

    @Override
    public HashMap<Integer, Integer> getListOfProductsWithQuantity() {

        // get day by date
        Map<LocalDate, HashMap<Integer, Integer>> day = theDaySummaryComponent.getDay();

        // return map by day
        return day.get(thDateComponent.getDate());
    }
}
