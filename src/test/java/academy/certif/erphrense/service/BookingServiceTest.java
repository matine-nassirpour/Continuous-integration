package academy.certif.erphrense.service;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import academy.certif.erphrense.domain.Cancelable;
import academy.certif.erphrense.domain.Ticket;
import academy.certif.erphrense.provider.CancelableProvider;
import academy.certif.erphrense.provider.TicketProvider;

public class BookingServiceTest 
{
    private static CancelableProvider ticketProvider;
    private static BookingService bookingService;

    @BeforeClass
    public static void init() {
        BookingServiceTest.ticketProvider = new TicketProvider();
        BookingServiceTest.bookingService = new BookingService(ticketProvider);
    }

    @Test
    public void book_shoudReturn_aReference()
    {
        Ticket ticket = new Ticket("Annie Versaire", "01/01/2021 16:30", "Paris", "New-York", 0);
        assertTrue(ticket.getReference() == 0);
        Cancelable result = BookingServiceTest.bookingService.book(null, ticket);
        ticket = (Ticket) result;
        assertTrue(ticket.getReference() != 0);
    }
}
