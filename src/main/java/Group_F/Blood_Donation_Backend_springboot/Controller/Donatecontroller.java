package Group_F.Blood_Donation_Backend_springboot.Controller;

import Group_F.Blood_Donation_Backend_springboot.Model.Donatebl;

import Group_F.Blood_Donation_Backend_springboot.Model.User;
import Group_F.Blood_Donation_Backend_springboot.Respository.DonateRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class Donatecontroller {
    @Autowired
    private DonateRespository donateRespository;

    @PostMapping("/adddonate")
   Donatebl newdonate(@RequestBody Donatebl newdonate){
      return donateRespository.save(newdonate);
    }

    @GetMapping("/donars")
    List<Donatebl>getAlldoners(){
        return donateRespository.findAll();
    }


    @GetMapping("/singledoner/{id}")
    Donatebl getdonerById(@PathVariable int id){
        return donateRespository.findById(id).orElse(null);
    }
    @PutMapping("/updater/{id}")
    Donatebl updateDoner(@RequestBody Donatebl updateDoner,@PathVariable int id){
        return donateRespository.findById(id)
                .map(doner ->{
                    doner.setName(updateDoner.getName());
                    doner.setEmail(updateDoner.getEmail());
                    doner.setPhone(updateDoner.getPhone());
                    doner.setBloodtype(updateDoner.getBloodtype());
                    doner.setTariikh(updateDoner.getTariikh());
                    doner.setMessage(updateDoner.getMessage());
                    return donateRespository.save(doner);
                }).orElseGet(() ->{
                    updateDoner.setId(id);
                    return donateRespository.save(updateDoner);
                });
    }

    @DeleteMapping("/donerDelete/{id}")
    void Deletedoner(@PathVariable int id){
        donateRespository.deleteById(id);
    }

}
