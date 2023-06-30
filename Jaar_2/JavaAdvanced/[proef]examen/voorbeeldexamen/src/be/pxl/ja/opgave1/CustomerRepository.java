package be.pxl.ja.opgave1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
	private Map<String, Customer> customers = new HashMap<>();
	
	public CustomerRepository() {
		for (Customer customer : Customers.customers) {
			customers.put(customer.getCustomerNumber(), customer);
		}
	}
	
	public Customer getByCustomerNumber(String customerNumber) {
		return customers.get(customerNumber) == null ? null : customers.get(customerNumber);
	}
	
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		for (Map.Entry<String, Customer> entry : customers.entrySet()) {
			customerList.add(entry.getValue());
		}
		return  customerList;
	}
}
