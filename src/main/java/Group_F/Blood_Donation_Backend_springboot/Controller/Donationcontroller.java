package Group_F.Blood_Donation_Backend_springboot.Controller;

import Group_F.Blood_Donation_Backend_springboot.Model.Donatebl;
import Group_F.Blood_Donation_Backend_springboot.Model.Donationbl;
import Group_F.Blood_Donation_Backend_springboot.Respository.DonationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class Donationcontroller {
    @Autowired
    private DonationRespository donationRespository;

    @PostMapping("/adddonation")
    Donationbl adddon(@RequestBody  Donationbl adddon ){
        return donationRespository.save(adddon);
    }
    @GetMapping("/alldonations")
    List<Donationbl>getAlldonations(){
        return donationRespository.findAll();
    }

    @GetMapping("/single/{id}")
    Donationbl getdonationById(@PathVariable int id){
        return donationRespository.findById(id).orElse(null);
    }
    @PutMapping("/isbadal/{id}")
   Donationbl updateDonation(@RequestBody Donationbl updateDonation,@PathVariable int id){
        return donationRespository.findById(id)
                .map(doner ->{
                    doner.setName(updateDonation.getName());
                    doner.setAge(updateDonation.getAge());
                    doner.setBloodgroup(updateDonation.getBloodgroup());
                    doner.setNumber(updateDonation.getNumber());
                    doner.setTariikh(updateDonation.getTariikh());
                    doner.setHospital(updateDonation.getHospital());

                    return donationRespository.save(doner);
                }).orElseGet(() ->{
                    updateDonation.setId(id);
                    return donationRespository.save(updateDonation);
                });
    }

    @DeleteMapping("/donDelete/{id}")
    void Deletedonation(@PathVariable int id){
        donationRespository.deleteById(id);
    }
}
