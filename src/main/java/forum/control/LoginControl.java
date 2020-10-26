package forum.control;

import forum.model.User;
import forum.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Controller
public class LoginControl {
    private final Login service;

    @Autowired
    public LoginControl(Login service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/signIn")
    public String singIn(@RequestParam("name") String name,
                         @RequestParam("password") String password) {
        if (service.validate(new User(0, name, password))) {
            return "redirect:/";
        }
        return "login";
    }
}
