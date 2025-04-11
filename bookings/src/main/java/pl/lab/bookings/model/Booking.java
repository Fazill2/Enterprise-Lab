package pl.lab.bookings.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Apartment apartment;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;
    private LocalDate toDate;
    @Min(value = 1)
    @Max(value = 366)
    private Integer numDays = 1;
    @Min(value = 1)
    private Integer numGuests = 1;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    @PrePersist
    private void onPrePersist() {
        toDate = fromDate.plusDays(numDays);
    }

    public LocalDate getToDate() {
        return fromDate.plusDays(numDays);
    }
}