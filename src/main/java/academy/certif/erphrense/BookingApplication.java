package academy.certif.erphrense;

import java.util.Scanner;

import academy.certif.erphrense.controller.BookingController;
import academy.certif.erphrense.domain.Cancelable;
import academy.certif.erphrense.dto.TicketRequest;
import academy.certif.erphrense.provider.CancelableProvider;
import academy.certif.erphrense.provider.TicketProvider;
import academy.certif.erphrense.service.BookingService;

public class BookingApplication {
	public static void main(String[] args) {
		
		CancelableProvider ticketProvider = new TicketProvider();
		BookingService service = new BookingService(ticketProvider);
		BookingController controller = new BookingController(service);
		
		Scanner scanner = new Scanner(System.in); 
		while (true) {
			System.out.print("Que souhaitez-vous faire ? [1: reserver, 2: annuler une reservation] : ");
			String text = scanner.nextLine();
			if (text.equals("1")) {
				TicketRequest dto = new TicketRequest();
				
				System.out.print("Veuillez saisir le nom complet du passager : ");
				text = scanner.nextLine();
				dto.setPerson(text);
				System.out.print("Veuillez saisir la date et heure de d�part : ");
				text = scanner.nextLine();
				dto.setDeparture(text);
				System.out.print("Veuillez saisir la ville de d�part : ");
				text = scanner.nextLine();
				dto.setFrom(text);
				System.out.print("Veuillez saisir la ville d'arriv�e : ");
				text = scanner.nextLine();
				dto.setTo(text);
				
				Cancelable cancelable = controller.book(dto);
				System.out.println(cancelable.toString());
				
			} else if (text.equals("2")) {
				
				System.out.print("Veuillez saisir la r�f�rence de la reservation : ");
				text = scanner.nextLine();
				boolean result = controller.cancel(text);
				if (result) {
					System.out.println("Votre billet " + text + " a bien ete annule.");
				} else {
					System.out.println("La reservation n'existe pas.");
				}
				
			} else {
				break;
			}
		}
		
	}
}
