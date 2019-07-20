package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation3;
import model.exceptions.DomainException;

public class Program3 {

	public static void main(String[] args) {
		// Primeira Solução BOA com tratamento de Exceções
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			
			System.out.print("Room Number: ");
			int number = sc.nextInt();

			System.out.print("Check In (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check Out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation3 reserv = new Reservation3(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserv.toString());

			System.out.print("\nEnter data to update the reservation: ");
			System.out.print("\nCheck In (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check Out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserv.updateDates(checkIn, checkOut);

			System.out.println("Reservation: " + reserv.toString());
			
		} catch (ParseException e) {
			System.out.println("INVALID DATE FORMAT");
						
		}catch (DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("unexpected error");
		}
		
		

		sc.close();

	}

}
