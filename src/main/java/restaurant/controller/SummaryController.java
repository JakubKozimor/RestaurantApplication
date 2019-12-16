package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.Entity.Summary;
import restaurant.service.SummaryService;

import java.util.List;

@Controller
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @GetMapping("/allSummary")
    public String getAllSummary(Model model) {

        // get list summary
        List<Summary> listOfSummary = summaryService.getListOfSummary();

        // add list of summary to model
        model.addAttribute("listOfSummary", listOfSummary);

        return "summary-list";
    }
}