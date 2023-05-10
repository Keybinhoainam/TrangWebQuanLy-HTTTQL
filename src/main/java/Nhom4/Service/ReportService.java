package Nhom4.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import Nhom4.Dto.ItemReport;

public interface ReportService {

	List<ItemReport> reportTotalPurchaseAmountByDate(Date d, int limit);

	List<ItemReport> reportQuantityProductImportsByDate(Date d, int limit);

	Map<String, Integer> reportRecentDailySalesQuantity(Date d, int limit);

	Map<String, Integer> reportTotalSalesAmountByDate(Date d, int limit);

	Map<String, Integer> reportRecentMonthlySalesQuantity(Date d, int limit);

	Map<String, Integer> reportTotalSalesAmountByMonth(Date d, int limit);

	Map<String, Integer> reportSalesQuantity();

	

	

}
