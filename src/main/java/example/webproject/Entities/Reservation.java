package example.webproject.Entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="reservation")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @Column(name="reservationId")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "reservation_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int reservationId;


    @Column(name="arrival")
    private Date arrival;
    @Column(name="departure")
    private Date departure;
    @ManyToOne
    @JoinColumn(name="guestId")
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @Column(name="status")
    private ReservationStatus status;
    @Column(name="paid")
    private PaidStatus paid;

}
