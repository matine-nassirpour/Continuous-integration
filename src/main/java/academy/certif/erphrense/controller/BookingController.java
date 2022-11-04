package academy.certif.erphrense.controller;

import academy.certif.erphrense.domain.Cancelable;
import academy.certif.erphrense.domain.Ticket;
import academy.certif.erphrense.dto.TicketRequest;
import academy.certif.erphrense.service.BookingService;

public class BookingController {

	private BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	public Cancelable book(TicketRequest request) {
		Ticket ticket = new Ticket(request.getPerson(), request.getDeparture(), request.getFrom(), request.getTo(), 0);
		return this.bookingService.book(null, ticket);
	}
	
	public boolean cancel(String reference) {
		return this.bookingService.cancel(Integer.parseInt(reference));
	}
	
}
