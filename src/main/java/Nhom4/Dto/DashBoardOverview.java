package Nhom4.Dto;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DashBoardOverview {
	Float revenue;
	int orders;
	int customer;
	int comparedRevenue;
	int comparedOrder;
	int comparedCustomer;
	Set<String> dataKey;
	Collection<Integer> dataValue1;
	Collection<Integer> dataValue2;
	Set<String> dataNvKey;
	Collection<Float> datanNvValue;
	Set<String> dataProductKey;
	Collection<Integer> datanProductValue;
	public DashBoardOverview() {
		super();
	}
	
	public DashBoardOverview(Float revenue, int orders, int customer) {
		super();
		this.revenue = revenue;
		this.orders = orders;
		this.customer = customer;
	}
	
	

	public DashBoardOverview(Float revenue, int orders, int customer, int comparedRevenue, int comparedOrder,
			int comparedCustomer) {
		super();
		this.revenue = revenue;
		this.orders = orders;
		this.customer = customer;
		this.comparedRevenue = comparedRevenue;
		this.comparedOrder = comparedOrder;
		this.comparedCustomer = comparedCustomer;
	}

	public Float getRevenue() {
		return revenue;
	}
	public void setRevenue(Float revenue) {
		this.revenue = revenue;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public int getComparedRevenue() {
		return comparedRevenue;
	}

	public void setComparedRevenue(int comparedRevenue) {
		this.comparedRevenue = comparedRevenue;
	}

	public int getComparedOrder() {
		return comparedOrder;
	}

	public void setComparedOrder(int comparedOrder) {
		this.comparedOrder = comparedOrder;
	}

	public int getComparedCustomer() {
		return comparedCustomer;
	}

	public void setComparedCustomer(int comparedCustomer) {
		this.comparedCustomer = comparedCustomer;
	}

	public DashBoardOverview(Float revenue, int orders, int customer, int comparedRevenue, int comparedOrder,
			int comparedCustomer, Set<String> dataKey, Collection<Integer> dataValue1, Collection<Integer> dataValue2) {
		super();
		this.revenue = revenue;
		this.orders = orders;
		this.customer = customer;
		this.comparedRevenue = comparedRevenue;
		this.comparedOrder = comparedOrder;
		this.comparedCustomer = comparedCustomer;
		this.dataKey = dataKey;
		this.dataValue1 = dataValue1;
		this.dataValue2 = dataValue2;
	}

	public Set<String> getDataKey() {
		return dataKey;
	}

	public void setDataKey(Set<String> dataKey) {
		this.dataKey = dataKey;
	}

	public Collection<Integer> getDataValue1() {
		return dataValue1;
	}

	public void setDataValue1(Collection<Integer> dataValue1) {
		this.dataValue1 = dataValue1;
	}

	public Collection<Integer> getDataValue2() {
		return dataValue2;
	}

	public void setDataValue2(Collection<Integer> dataValue2) {
		this.dataValue2 = dataValue2;
	}

	

	public DashBoardOverview(Float revenue, int orders, int customer, int comparedRevenue, int comparedOrder,
			int comparedCustomer, Set<String> dataKey, Collection<Integer> dataValue1, Collection<Integer> dataValue2,
			Set<String> dataNvKey, Collection<Float> datanNvValue, Set<String> dataProductKey,
			Collection<Integer> datanProductValue) {
		super();
		this.revenue = revenue;
		this.orders = orders;
		this.customer = customer;
		this.comparedRevenue = comparedRevenue;
		this.comparedOrder = comparedOrder;
		this.comparedCustomer = comparedCustomer;
		this.dataKey = dataKey;
		this.dataValue1 = dataValue1;
		this.dataValue2 = dataValue2;
		this.dataNvKey = dataNvKey;
		this.datanNvValue = datanNvValue;
		this.dataProductKey = dataProductKey;
		this.datanProductValue = datanProductValue;
	}
	

	public Collection<Integer> getDatanProductValue() {
		return datanProductValue;
	}

	public void setDatanProductValue(Collection<Integer> datanProductValue) {
		this.datanProductValue = datanProductValue;
	}

	public Set<String> getDataNvKey() {
		return dataNvKey;
	}

	public void setDataNvKey(Set<String> dataNvKey) {
		this.dataNvKey = dataNvKey;
	}

	public Collection<Float> getDatanNvValue() {
		return datanNvValue;
	}

	public void setDatanNvValue(Collection<Float> datanNvValue) {
		this.datanNvValue = datanNvValue;
	}

	public Set<String> getDataProductKey() {
		return dataProductKey;
	}

	public void setDataProductKey(Set<String> dataProductKey) {
		this.dataProductKey = dataProductKey;
	}
	
	

	
	

	

	
	
}
