package tn.insat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.entities.Chambre;
import tn.insat.services.ChambreService;

import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
@RestController
public class ChambreController  {
@Autowired
ChambreService chambreService;
    @RequestMapping("/add")
    @ResponseBody
    public Chambre addChambre(Integer id){

        return(chambreService.add(id));


    }


    @RequestMapping("/chambres/getAll")
    @ResponseBody
    public List<Chambre> getChambre(){


        return(chambreService.getAll());

    }




}
