package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation2;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		// Primeira Solução RUIM

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();

		System.out.print("Check In (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check Out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {

			System.out.println("Error in reservation: Check-Out date must be after Check-in date");
		} else {

			Reservation2 reserv = new Reservation2(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserv.toString());

			System.out.print("\nEnter data to update the reservation: ");
			System.out.print("\nCheck In (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check Out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reserv.updateDates(checkIn, checkOut);
			if (error != null) {

				System.out.println("Error in reservation: " + error);
			} else {

				System.out.println("Reservation: " + reserv.toString());
			}

		}

		sc.close();

	}

}
