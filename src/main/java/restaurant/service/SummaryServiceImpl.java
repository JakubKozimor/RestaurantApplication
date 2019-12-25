package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Dish;
import restaurant.Entity.Summary;
import restaurant.components.TablesComponent;
import restaurant.data.SummaryRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class SummaryServiceImpl implements SummaryService {

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
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);
        List<Summary> listOfSummaryToday = summaryRepository.findAllByDate(LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        // todo fix changing data
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
