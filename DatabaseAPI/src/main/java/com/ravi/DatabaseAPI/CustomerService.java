package com.ravi.DatabaseAPI;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService  {
	
	@Autowired
	private CustomerDTO customerdto;
    @Autowired
    DataToExcel excel;
	
	public void  retriveDataByName(HttpServletResponse response,String name) {
		List<CustomerEntity> lt = customerdto.findByName(name);
		excel.dataToExcel(response,lt);
	}
	
	public List<CustomerEntity> retriveData() {
		return customerdto.findAll();
	}

	public CustomerEntity saveData(CustomerEntity customer) {
		return customerdto.save(customer);
	}


	public void deleteById(int id) {
		customerdto.deleteById(id);
	}

	public void retriveData(HttpServletResponse response) {
		List<CustomerEntity>lt = customerdto.findAll();
		excel.dataToExcel(response,lt);
	}

}
