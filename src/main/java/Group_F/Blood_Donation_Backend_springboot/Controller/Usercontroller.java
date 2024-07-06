package Group_F.Blood_Donation_Backend_springboot.Controller;

import Group_F.Blood_Donation_Backend_springboot.Model.User;
import Group_F.Blood_Donation_Backend_springboot.Respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")

public class Usercontroller {

@Autowired
    private UserRespository userRespository;

@PostMapping("/adduser")
   User newuser(@RequestBody User newuser){
       return userRespository.save(newuser);
   }
   @GetMapping("/getallusers")
    List<User>getAllUsers(){
       return userRespository.findAll();
   }
   @GetMapping("/singleuserid/{id}")
   User getUserById(@PathVariable int id){
    return userRespository.findById(id).orElse(null);
   }
   @PutMapping("/update/{id}")
   User updateUser(@RequestBody User newuser,@PathVariable int id){
    return userRespository.findById(id)
            .map(user ->{
                user.setName(newuser.getName());
                user.setAddress(newuser.getAddress());
                user.setEmail(newuser.getEmail());
                user.setPassword(newuser.getPassword());
                return userRespository.save(user);
            }).orElseGet(() ->{
                newuser.setId(id);
                return userRespository.save(newuser);
       });
   }

   @DeleteMapping("/userDelete/{id}")
    void Deleteuser(@PathVariable int id){
    userRespository.deleteById(id);
   }

}
