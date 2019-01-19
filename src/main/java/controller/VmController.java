package controller;

import model.Vm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.VmService;

import java.util.List;

@Controller
public class VmController {
    @Autowired
    private VmService vmService;
    @RequestMapping("/showVm")
    public String showVm(Model model){
        List<Vm> vms = vmService.findAllVm();
        model.addAttribute("name","vm");
        return "ShowVm";
    }

}
