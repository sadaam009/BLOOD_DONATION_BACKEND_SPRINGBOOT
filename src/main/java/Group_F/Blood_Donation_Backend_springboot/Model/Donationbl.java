package Group_F.Blood_Donation_Backend_springboot.Model;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Donation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Donationbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String bloodgroup;
    private String number;
    private String hospital;
    private LocalDate Tariikh;
}
