package Nhom4.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import Nhom4.Dto.ItemReport;

public interface DashBoardService {

	int getOrder(Date from, Date to);

	Float getRevenue(Date from, Date to);

	int getCustomer(Date from, Date to);

	int comparedCustomer(Date from1, Date to1, Date from2, Date to2);

	int comparedOrder(Date from1, Date to1, Date from2, Date to2);

	int comparedRevenue(Date from1, Date to1, Date from2, Date to2);

	

	

}
