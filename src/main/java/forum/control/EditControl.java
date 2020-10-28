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
import java.util.Optional;

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

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "edit";
    }

    @PostMapping("/createPost")
    public String createPost(@RequestParam("name") String name,
                             @RequestParam("description") String desc,
                             @RequestParam(name = "id", required = false) Optional<Integer> boxID) {
        boxID.ifPresentOrElse(id -> {
            Post post = (Post) service.findById(id).get();
            post.setDesc(desc);
            post.setName(name);
            service.update(post);
        }, () -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            Post post = new Post(0, name, desc, calendar);
            service.add(post);
        });
        return "redirect:/";
    }
}
