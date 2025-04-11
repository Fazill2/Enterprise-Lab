package pl.lab.bookings.dao;

import org.springframework.data.repository.CrudRepository;
import pl.lab.bookings.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
