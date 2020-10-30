package forum.control;

import forum.model.User;
import forum.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Class is a registration controller
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Controller
public class RegControl {
    /**
     * Service
     */
    private final RepositoryService service;

    @Autowired
    public RegControl(@Qualifier("userService") RepositoryService service) {
        this.service = service;
    }

    /**
     * @return target page
     */
    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    /**
     * Method of creation new user
     *
     * @param user
     * @return redirect to main page
     */
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        service.add(user);
        return "redirect:/";
    }
}
