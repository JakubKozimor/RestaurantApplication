package restaurant.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportService {

    String exportReport() throws FileNotFoundException, JRException;
}
