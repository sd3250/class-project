package ro.siit.concedii.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import ro.siit.concedii.domain.User;
import ro.siit.concedii.service.UserServiceIMPL;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/users", method = RequestMethod.GET)
public class UserRestController {

    User user = new User();

    @Autowired
    private UserServiceIMPL userService;

    @RequestMapping("")
    public Collection<User> list() {
        return userService.listAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable ("id") Long id) {
        return userService.get(id);
    }

}
