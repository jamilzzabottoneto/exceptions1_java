package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation3 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation3() {
		// TODO Auto-generated constructor stub
	}

	public Reservation3(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		if (!checkOut.after(checkIn)) {

			throw new DomainException("Check-Out date must be after Check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {

		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {

			throw new DomainException("Reservation dates for update must be future dates");

		}
		if (!checkOut.after(checkIn)) {

			throw new DomainException("Check-Out date must be after Check-in date");
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room: " + getRoomNumber() + ", check in: " + sdf.format(getCheckIn()) + ", check out: "
				+ sdf.format(getCheckOut()) + ", " + duration() + " nights";

	}

}
