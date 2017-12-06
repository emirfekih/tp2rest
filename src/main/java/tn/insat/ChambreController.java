package tn.insat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ASUS on 06/12/2017.
 */
@RestController
public class ChambreController  {
@Autowired
ChambreRepository chambreRepository;
    @RequestMapping("/add")
    @ResponseBody
    public Chambre addChambre(int id){

        Chambre ch= new Chambre(id);
        chambreRepository.save(ch);

        return(ch);

    }


    @RequestMapping("/getOne")
    @ResponseBody
    public Chambre getChambre(int id){


        return(chambreRepository.findOne(id));

    }


}
