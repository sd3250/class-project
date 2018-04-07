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

import java.util.List;

@RestController
@RequestMapping("users")
public class UserRestController {

    User user = new User();

    @Autowired
    private UserServiceIMPL userService;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody User getUserById(@PathVariable long id) {
        return userService.get(id);
    }
}
