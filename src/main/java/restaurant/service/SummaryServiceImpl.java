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
        updateMissingDishesInSummary(theNumberOfTable);
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);
        List<Summary> listOfSummaryToday = summaryRepository.findAllByDate(LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        for (Summary tempProduct : listOfSummaryToday) {
            for (Dish tempDish : theTable) {
                if (tempDish.getDishId() == tempProduct.getdish().getDishId()) {
                    int newQuantity = tempProduct.getQuantity() + 1;
                    tempProduct.setQuantity(newQuantity);
                    tempProduct.setDate(tempProduct.getdate().plusDays(1));
                    summaryRepository.save(tempProduct);
                }
            }
        }
    }

    public void updateMissingDishesInSummary(int theNumberOfTable) {
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);
        List<Summary> listOfSummaryToday = summaryRepository.findAllByDate(LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        for (Dish tempDish : theTable) {
            boolean flag = false;
            for (Summary tempSummary : listOfSummaryToday)
                if (tempDish.getDishId() == tempSummary.getdish().getDishId()) flag = true;
            if (!flag) {
                Summary tempSummary = new Summary(LocalDate.now().plusDays(1), tempDish);
                summaryRepository.save(tempSummary);
            }
        }
    }
}
