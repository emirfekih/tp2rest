package tn.insat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.entities.Option;
import tn.insat.repositories.OptionRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
@RestController
public class OptionController {


    @Autowired
    OptionRepository optionRepository;

    @RequestMapping("/options/add")
    @ResponseBody()
    public Option add(String prix,String description){
        Option o = new Option(new BigDecimal(prix),description);
        return(optionRepository.save(o));
    }

    @RequestMapping("/options/getAll")
    @ResponseBody()
    public List<Option> getAll(){

        return(optionRepository.findAll());
    }
}
