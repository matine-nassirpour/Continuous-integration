package academy.certif.erphrense.provider;

import java.util.Collection;

import academy.certif.erphrense.domain.Bookable;

public abstract class BookableProvider {

	protected Collection<Bookable> bookables;
	
	public Iterable<Bookable> list() {
		return this.bookables;
	}
	
}
