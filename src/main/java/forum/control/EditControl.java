package forum.control;

import forum.model.Post;
import forum.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping({"/edit?id={id}", "/edit"})
    public String edit(@PathVariable(value = "id", required = false) int id, Model model) {
        model.addAttribute("post", service.findById(id).get());
        return "edit";
    }

    @PostMapping("/create")
    public String create(@RequestParam("name") String name,
                         @RequestParam("description") String desc,
                         Model model) {
        Post post = (Post) model.getAttribute("post");
        post.setName(name);
    }
}
