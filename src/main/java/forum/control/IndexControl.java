package forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Controller
public class IndexControl {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
