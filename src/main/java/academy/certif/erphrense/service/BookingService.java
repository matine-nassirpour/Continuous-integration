package academy.certif.erphrense.service;

import academy.certif.erphrense.domain.Bookable;
import academy.certif.erphrense.domain.Cancelable;
import academy.certif.erphrense.provider.CancelableProvider;

public class BookingService {
	
	private int counter;
	private CancelableProvider cancelableProvider;
	
	public BookingService(CancelableProvider cancelableProvider) {
		this.cancelableProvider = cancelableProvider;
		this.counter = 0;
	}

	public Cancelable book(Bookable item, Cancelable cancelable) {
		this.counter = this.counter + 1;
		cancelable.setReference(this.counter);
		this.cancelableProvider.persist(cancelable);
		return cancelable;
	}
	
	public boolean cancel(int reference) {
		return this.cancelableProvider.delete(reference);
	}
}
