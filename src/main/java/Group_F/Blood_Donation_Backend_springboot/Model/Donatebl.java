package Group_F.Blood_Donation_Backend_springboot.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "donate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Donatebl{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    private String bloodtype;
    private Date Tariikh;
    private String message;

}
