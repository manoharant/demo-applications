package com.lhcargo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lhcargo.model.Customers;
import com.lhcargo.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerService customerService; // Service which will do all data
										// retrieval/manipulation work

	// -------------------Retrieve
	// AllCustomers--------------------------------------------------------

	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<Customers>> listAllCustomers() {
		List<Customers> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity<List<Customers>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Customers--------------------------------------------------------

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> getCustomer(@PathVariable("id") int id) {
		System.out.println("Fetching Customers with id " + id);
		Customers customer = customerService.findById(id);
		if (customer == null) {
			System.out.println("Customers with id " + id + " not found");
			return new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customers>(customer, HttpStatus.OK);
	}

	// -------------------Create a
	// Customers--------------------------------------------------------

	@RequestMapping(value = "/customer/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCustomer(@RequestBody Customers customer, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Customers " + customer.getCustomername());

		if (customerService.isCustomerExist(customer)) {
			System.out.println("A Customers with name " + customer.getCustomername() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		customerService.saveCustomer(customer);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getCustomernumber()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Customers
	// --------------------------------------------------------

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customers> updateCustomer(@PathVariable("id") int id, @RequestBody Customers customer) {
		System.out.println("Updating Customers " + id);

		Customers currentCustomer = customerService.findById(id);

		if (currentCustomer == null) {
			System.out.println("Customers with id " + id + " not found");
			return new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
		}

		currentCustomer.setCustomername(customer.getCustomername());
		currentCustomer.setAddressline1(customer.getAddressline1());
		currentCustomer.setCity(customer.getCity());

		customerService.updateCustomer(currentCustomer);
		return new ResponseEntity<Customers>(currentCustomer, HttpStatus.OK);
	}

	// ------------------- Delete a Customers
	// --------------------------------------------------------

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Customers> deleteCustomer(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Customers with id " + id);

		Customers customer = customerService.findById(id);
		if (customer == null) {
			System.out.println("Unable to delete. Customers with id " + id + " not found");
			return new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
		}

		customerService.deleteCustomerById(id);
		return new ResponseEntity<Customers>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete AllCustomers
	// --------------------------------------------------------

	@RequestMapping(value = "/customer/", method = RequestMethod.DELETE)
	public ResponseEntity<Customers> deleteAllCustomers() {
		System.out.println("Deleting AllCustomers");

		customerService.deleteAllCustomers();
		return new ResponseEntity<Customers>(HttpStatus.NO_CONTENT);
	}
}
