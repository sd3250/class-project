package ro.siit.concedii.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import ro.siit.concedii.domain.User;
import ro.siit.concedii.service.UserServiceIMPL;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/users/")
public class UserRestController {

    @Autowired
    private UserServiceIMPL userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<User> list() {
        return userService.listAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable ("id") Long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveUser(@RequestBody User user) {
        userService.save(user);
        return true;
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable ("id") Long id, @RequestBody User user) {
        userService.update(user, id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void deleteUser(@RequestBody User user, @PathVariable ("id") Long id) {
        userService.delete(id);
    }

}
