package Group_F.Blood_Donation_Backend_springboot.Respository;

import Group_F.Blood_Donation_Backend_springboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,Integer> {
}
