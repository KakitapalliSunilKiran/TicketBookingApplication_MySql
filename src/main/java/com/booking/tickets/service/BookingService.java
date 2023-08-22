package com.booking.tickets.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.tickets.dao.BookingRepo;
import com.booking.tickets.model.Ticket;

@Service
public class BookingService {

	@Autowired
	BookingRepo bookingrepo;
	public void saveTicketData(Ticket ticket) {
		bookingrepo.save(ticket);
	}
	
	public Ticket getTicket(int ticketId) {
		return bookingrepo.findById(ticketId).orElse(new Ticket());
		//return null;
		
	}
	
	public Ticket updateTicket(int ticketId,String email) {
		Ticket obj= getTicket(ticketId);
		obj.setEmail(email);
		bookingrepo.save(obj);
		return obj;
		
	}
	
	
	public Ticket deleteTicket(int ticketId) {
		Ticket obj= getTicket(ticketId);
		bookingrepo.deleteById(ticketId);
		return obj;
	}
	
	public Iterable<Ticket> getAll(){
		return bookingrepo.findAll();
		//return null;	
	}
	
	public Iterable<Ticket> findAllByIdss(ArrayList<Integer> al){
		return bookingrepo.findAllById(al);
	}
	
	public Iterable<Ticket> saveALL(Iterable<Ticket> tickets){
		return bookingrepo.saveAll(tickets);
	}
}
