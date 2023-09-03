package com.booking.tickets.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.tickets.model.Ticket;
import com.booking.tickets.service.BookingService;
//CRUD

@RestController
@RequestMapping("api/v2")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping(value="storetodb")
	public void doSave(@RequestBody Ticket ticket) {
		bookingService.saveTicketData(ticket);
	}
	
	@GetMapping(value= "getTicket/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		System.out.println("Ticket id is"+ticketId);
		return bookingService.getTicket(ticketId);
		
	}
	
	@PutMapping(value="updateTicket/{ticketId}/{email}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("email") String email) {
		return bookingService.updateTicket(ticketId, email);
	}
	
	@DeleteMapping("deleteTicket/{ticketId}")
	public Ticket deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		return bookingService.deleteTicket(ticketId);
	}
	
	@GetMapping("findAll")
	public Iterable<Ticket> getAllTickets(){
		System.out.println("Get all controller layer");
		return bookingService.getAll();
	}
	
	@GetMapping("findAllbyId")
	public Iterable<Ticket> findAllByIDS(){
		ArrayList<Integer> al=new ArrayList<>();
		al.add(101);
		al.add(102);
		al.add(103);
		al.add(110);
		return bookingService.findAllByIdss(al);
		//return null;
	}
	
	@PostMapping("SaveAllRecords")
	public Iterable<Ticket> saveAll(@RequestBody Iterable<Ticket> tickets){
		ArrayList<Ticket> al=new ArrayList<>();
		System.out.println("I am in controller layer");
//		al.add(new Ticket(101,"sunil","something@gmail.com","Amadalavalsa","Hyderabad"));
//		al.add(new Ticket(102,"sunil","something@gmail.com","Amadalavalsa","Hyderabad"));
//		al.add(new Ticket(103,"sunil","something@gmail.com","Amadalavalsa","Hyderabad"));
//		al.add(new Ticket(104,"sunil","something@gmail.com","Amadalavalsa","Hyderabad"));
		return bookingService.saveALL(tickets);
		
	}
	
}
