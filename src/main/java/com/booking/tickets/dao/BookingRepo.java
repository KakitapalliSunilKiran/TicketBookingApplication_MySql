package com.booking.tickets.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.tickets.model.Ticket;

@Repository
public interface BookingRepo extends CrudRepository<Ticket,Integer>
{

	//findALl
	//findAllById
	//SaveAll
	

}
