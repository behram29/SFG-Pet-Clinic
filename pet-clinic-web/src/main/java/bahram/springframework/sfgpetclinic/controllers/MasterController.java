package bahram.springframework.sfgpetclinic.controllers;

import bahram.springframework.sfgpetclinic.services.MasterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MasterController {

    private final MasterService masterService;

    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @RequestMapping({"/masters","/masters/index", "/masters/index.html"})
    public String listVets(Model model){

        model.addAttribute("masters", masterService.findAll());
        return "masters/index";
    }
}
