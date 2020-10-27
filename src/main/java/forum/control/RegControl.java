package forum.control;

import forum.model.User;
import forum.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Controller
public class RegControl {
    private final RepositoryService service;

    @Autowired
    public RegControl(@Qualifier("userService") RepositoryService service) {
        this.service = service;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("password") String password) {
        service.add(new User(0, name, password));
        return "redirect:/";
    }
}
