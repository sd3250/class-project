package ro.siit.concedii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.concedii.domain.Leave;
import ro.siit.concedii.service.LeaveService;

import java.util.Collection;


@Controller
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "/leave/listLeaves", method = RequestMethod.GET)
    public String listLeaves (Model moldel){
        Collection<Leave> leaves = leaveService.listAll();
        moldel.addAttribute("leaves", leaves);
        moldel.addAttribute("createLeave", new Leave());
        return "listLeaves";
    }
}
