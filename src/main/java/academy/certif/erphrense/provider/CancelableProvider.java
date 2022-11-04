package academy.certif.erphrense.provider;

import java.util.ArrayList;
import java.util.Collection;

import academy.certif.erphrense.domain.Cancelable;

public abstract class CancelableProvider {

	protected Collection<Cancelable> data;
	
	public boolean delete(int reference) {
		
		Collection<Cancelable> results = new ArrayList<Cancelable>();
		
		boolean found = false;
		for (Cancelable element : this.data) {
			if (element.getReference() != reference) {
				results.add(element);
			} else {
				found = true;
			}
		}
		
		this.data = results;
		return found;
	}
	
	public void persist(Cancelable cancelable) {
		this.data.add(cancelable);
	}
	
}
