package forum.control;

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
public class EditControl {
    private final RepositoryService service;

    @Autowired
    public EditControl(@Qualifier("postService") RepositoryService service) {
        this.service = service;
    }

    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping({"/create?id={id}", "/create"})
    public String create(@PathVariable(value = "id", required = false)
                         @RequestParam("name") String name,
                         @RequestParam("description") String desc) {

    }
}
