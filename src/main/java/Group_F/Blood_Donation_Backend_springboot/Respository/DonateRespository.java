package Group_F.Blood_Donation_Backend_springboot.Respository;

import Group_F.Blood_Donation_Backend_springboot.Model.Donatebl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateRespository extends JpaRepository<Donatebl ,Integer> {
}
