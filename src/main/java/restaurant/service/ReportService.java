package restaurant.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportService {

    void exportReport(int year, int month, int day) throws FileNotFoundException, JRException;
}
