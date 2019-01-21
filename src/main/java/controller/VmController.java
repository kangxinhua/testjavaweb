package controller;

import model.Vm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.IVmService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class VmController {
    @Autowired
    private IVmService vmService;
    @RequestMapping("/showVm")
    public String showVm(HttpServletRequest request, HttpServletResponse response,Model model){
       // List<Vm> vms = vmService.findAllVm();
        Vm vm = vmService.findVm("001");
        model.addAttribute("name","vm");
        return "ShowVm";
    }

}
