package restaurant.rest;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurant.service.ReportService;
import restaurant.service.SummaryService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;
    @Autowired
    SummaryService summaryService;

    @GetMapping("/generateReport")
    public void generateReport(@RequestParam("year") int year,
                               @RequestParam("month") int month,
                               @RequestParam("day") int day,
                               HttpServletResponse response) throws IOException, JRException {
        reportService.exportReport(year,month,day);
        StringBuffer redirect = new StringBuffer("/summary/getDays")
                .append("?year=").append(year).append("&month=").append(month);
        response.sendRedirect(redirect.toString());
    }
}
