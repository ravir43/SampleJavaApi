package com.ravi.DatabaseAPI.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.DatabaseAPI.CustomerEntity;
import com.ravi.DatabaseAPI.CustomerService;

@RestController
@RequestMapping("/")
public class ServiceController {

	@Autowired
	private CustomerService customerService;

	/*
	 * @GetMapping("getName") public String getDataByName(HttpServletResponse
	 * response ,@RequestParam String name) {
	 * 
	 * response.setContentType("application/octet-stream");
	 * 
	 * response.setHeader("Content-Disposition", "attachment;filename=user.xlsx");
	 * 
	 * 
	 * try { customerService.retriveDataByName(response,name); } catch (Exception e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } return
	 * "excel file is downloaded"; }
	 */
	@GetMapping("getName")
	public String getDataByName(HttpServletResponse response)  {
		
		response.setContentType("application/octet-stream");
		
		response.setHeader("Content-Disposition", "attachment;filename=user.xlsx");
		

		try {
			customerService.retriveData(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "excel file is downloaded";
	}

	@DeleteMapping("delete/{id1}")
	public String deleteById(@PathVariable("id1") int id) {
		customerService.deleteById(id);
		return "deleted Sucessfully";
	}

	@GetMapping("get")
	public List<CustomerEntity> getData() {
		return customerService.retriveData();
	}

	
	@PostMapping("post")
	public CustomerEntity postData(@RequestBody CustomerEntity customer) {
		return customerService.saveData(customer);

	}

}
