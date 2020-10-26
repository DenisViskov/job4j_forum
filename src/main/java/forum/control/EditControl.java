package forum.control;

import forum.model.Post;
import forum.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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

    @GetMapping(value = {"/edit/{numberID}", "/edit"})
    public String edit(@PathVariable(value = "numberID", required = false) String id, Model model) {
        service.findById(Integer.valueOf(id))
                .ifPresent(post -> model.addAttribute("post", post));
        return "edit";
    }

    @PostMapping("/createPost")
    public String createPost(@RequestParam("name") String name,
                             @RequestParam("description") String desc,
                             Model model) {
        Post post = (Post) model.getAttribute("post");
        if (post != null) {
            post.setName(name);
            post.setDesc(desc);
            service.update(post);
        } else {
            post = Post.of(name);
            post.setDesc(desc);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            post.setCreated(calendar);
            service.add(post);
        }
        return "redirect:/";
    }
}
