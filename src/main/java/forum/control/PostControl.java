package forum.control;

import forum.model.Post;
import forum.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class is a post controller
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.10.2020
 */
@Controller
public class PostControl {
    /**
     * Service
     */
    private final RepositoryService service;

    @Autowired
    public PostControl(@Qualifier("postService") RepositoryService service) {
        this.service = service;
    }

    /**
     * Method mapped by /post request
     * find user by given id and put him to model
     *
     * @param id
     * @param model
     * @return target page
     */
    @GetMapping("/post")
    public String post(@RequestParam("id") int id, Model model) {
        Post post = (Post) service.findById(id).get();
        model.addAttribute("post", post);
        return "post";
    }
}
