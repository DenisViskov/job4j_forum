package forum.control;

import forum.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class is index controller
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Controller
public class IndexControl {
    /**
     * Service
     */
    private final RepositoryService service;

    @Autowired
    public IndexControl(@Qualifier("postService") RepositoryService service) {
        this.service = service;
    }

    /**
     * Method mapped by / and /index request
     * put to model all posts and return target jsp
     *
     * @param model
     * @return index jsp
     */
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", service.findAll());
        return "index";
    }
}
