package Nhom4.Controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import Nhom4.Service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	ReportService reportService;
//	@RequestMapping("")
//	public String report(Model model) {
//		Date date = new Date();
//		List<ItemReport> itemReports=reportService.reportRecentProductsSoldByDate(date, 7);
//		model.addAttribute("itemReports", itemReports);
//		return "index";
//	}
//	private static final Random RANDOM = new Random(System.currentTimeMillis());

    
    
    @RequestMapping("/sales")
	public String barChart(Model model)
	{
    	Map<String, Integer> dataDay2 = reportService.reportTotalSalesAmountByDate(new Date(), 7);
		Map<String, Integer> dataDay1 = reportService.reportRecentDailySalesQuantity(new Date(), 7);
		Map<String, Integer> dataMonth1 = reportService.reportRecentMonthlySalesQuantity(new Date(), 12);
		Map<String, Integer> dataMonth2 = reportService.reportTotalSalesAmountByMonth(new Date(), 12);
		model.addAttribute("keySet1", dataDay1.keySet());
		model.addAttribute("values1", dataDay1.values());
		model.addAttribute("keySet2", dataDay2.keySet());
		model.addAttribute("values2", dataDay2.values());
		model.addAttribute("keySet3", dataMonth1.keySet());
		model.addAttribute("values3", dataMonth1.values());
		model.addAttribute("keySet4", dataMonth2.keySet());
		model.addAttribute("values4", dataMonth2.values());
		
		Map<String, Integer> dataSalesQuantity = reportService.reportSalesQuantity();
		model.addAttribute("salesQuantityKey", dataSalesQuantity.keySet());
		model.addAttribute("salesQuantityValue", dataSalesQuantity.values());
		
		String timeReport="";
		model.addAttribute("timeReport", timeReport);
		return "htttql/index3";
		
	}
    @RequestMapping("/2")
	public String barChart2(Model model)
	{
		Map<String, Integer> data2 = reportService.reportTotalSalesAmountByDate(new Date(), 7);
		Map<String, Integer> data1 = reportService.reportRecentDailySalesQuantity(new Date(), 7);
		model.addAttribute("keySet1", data1.keySet());
		model.addAttribute("values1", data1.values());
		model.addAttribute("keySet2", data2.keySet());
		model.addAttribute("values2", data2.values());
		return "htttql/test";
		
	}
    @RequestMapping("/3")
	public String barChart3(Model model)
	{
		
		return "htttql/general_elements";
		
	}
	
	
}
