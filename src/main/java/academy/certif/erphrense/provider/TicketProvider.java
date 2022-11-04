package academy.certif.erphrense.provider;

import java.util.ArrayList;
import academy.certif.erphrense.domain.Cancelable;

public class TicketProvider extends CancelableProvider {

	public TicketProvider() {
		this.data = new ArrayList<Cancelable>();
	}

}
