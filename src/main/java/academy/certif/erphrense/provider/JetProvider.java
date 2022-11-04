package academy.certif.erphrense.provider;

import java.util.ArrayList;

import academy.certif.erphrense.domain.Bookable;
import academy.certif.erphrense.domain.Jet;

public class JetProvider extends BookableProvider {

	public JetProvider() {
		this.bookables = new ArrayList<Bookable>();
		this.bookables.add(new Jet());
	}
	
}
