package ro.siit.concedii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.concedii.domain.Leave;
import ro.siit.concedii.service.LeaveService;

import javax.xml.bind.ValidationException;
import java.util.Collection;

@Controller
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "/leave/listLeaves", method = RequestMethod.GET)
    public String listLeaves(Model moldel) {
        Collection<Leave> leaves = leaveService.listAll();
        moldel.addAttribute("leaves", leaves);
        moldel.addAttribute("createLeave", new Leave());
        return "leave/listLeaves";
    }



    @RequestMapping(value = "/leave/listLeaves/update/{id}", method = RequestMethod.POST)
    public String LeaveeUpdate(Leave leave, @PathVariable long id) throws ValidationException {
        leaveService.update(leave, id);
        return "redirect:/listLeave";
    }



    @RequestMapping(value = "/leave/listLeaves/delete/{id}", method = RequestMethod.POST)
    public String LeaveDelete(@PathVariable long id) {
        leaveService.delete(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/search/{id}", method = RequestMethod.GET)
    public String LeaveSearch(String query) {
        leaveService.search(query);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/validate/{id}", method = RequestMethod.GET)
    public String LeaveSave(Leave leave) throws ValidationException {
        leaveService.save(leave);
        return "redirect:/ListLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/get/{id}", method = RequestMethod.GET)
    public String LeaveGet(Long id) throws ValidationException {
        leaveService.get(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/list/approved/{id}", method = RequestMethod.GET)
    public String ListAllAppoved(Long id) throws ValidationException {
        leaveService.listAllByEmployeeIDApproved(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/list/nonapproved/{id}", method = RequestMethod.GET)
    public String ListAllNonAppoved(Long id) throws ValidationException {
        leaveService.listAllByEmployeeIDNotApproved(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/list/all/{id}", method = RequestMethod.GET)
    public String ListAllEmployees(Long id) throws ValidationException {
        leaveService.listAllByEmployeeID(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/total/employees/available/{id}", method = RequestMethod.GET)
    public String getTotalNumberOfDaysAvailableByEmployeeID(Long id) throws ValidationException {
        leaveService.getTotalNumberOfDaysAvailableByEmployeeID(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/total/employees/used/{id}", method = RequestMethod.GET)
    public String getTotalNumberOfDaysUsedByEmployeeID(Long id) throws ValidationException {
        leaveService.getTotalNumberOfDaysUsedByEmployeeID(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/total/employees/maximum/{id}", method = RequestMethod.GET)
    public String getMaximumNoDaysForEmployeeID(Long id) throws ValidationException {
        leaveService.getMaximumNoDaysForEmployeeID(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/leave/approved/{id}", method = RequestMethod.GET)
    public String approveLeaveByID(Long id) throws ValidationException {
        leaveService.approveLeaveByID(id);
        return "redirect:/listLeave";
    }


    @RequestMapping(value = "/leave/listLeaves/leave/rejected/{id}", method = RequestMethod.GET)
    public String rejectLeaveByID(Long id) throws ValidationException {
        leaveService.rejectLeaveByID(id);
        return "redirect:/listLeave";
    }

}
