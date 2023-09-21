package example.webproject.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "house")
@Getter
@Setter
@NoArgsConstructor
public class House {
    @Id
    @Column(name = "houseId")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "house_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int houseId;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="description")
    private String description;
    @Column(name="image_link")
    private String imageLink;
    @Override
    public String toString() {
        return this.getName();
    }
}
