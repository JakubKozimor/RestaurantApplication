package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Date;
import restaurant.Entity.Dish;
import restaurant.Entity.Summary;
import restaurant.components.DateComponent;
import restaurant.components.TablesComponent;
import restaurant.data.Restaurant;
import restaurant.data.SummaryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    DateComponent theDateComponent;

    @Autowired
    TablesComponent theTablesComponent;

    @Autowired
    SummaryRepository summaryRepository;

    @Override
    public List<Summary> getListOfSummary() {

        return summaryRepository.findAll();
    }

    @Override
    public void updateSummary(int theNumberOfTable) {

        // get table
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        // get summary of today
        List<Summary> listOfSummaryToday = summaryRepository.findAllByDate(LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(), LocalDate.now().getYear());

        // update quantity
        for (Summary tempProduct : listOfSummaryToday) {
            for (Dish tempDish : theTable) {
                if (tempDish.getDishId() == tempProduct.getdish().getDishId()) {
                    int newQuantity = tempProduct.getQuantity() + 1;
                    tempProduct.setQuantity(newQuantity);
                    summaryRepository.save(tempProduct);
                }
            }
        }
    }
}
