package forum.control;

import forum.Main;
import forum.model.Post;
import forum.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class EditControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService posts;

    @Test
    @WithMockUser
    public void editTest() throws Exception {
        mockMvc.perform(get("/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void updateTest() throws Exception {
        mockMvc.perform(get("/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void WhenUpdatePostTest() throws Exception {
        Optional<Post> box = Optional.of(new Post());
        when(posts.findById(0)).thenReturn(box);
        mockMvc.perform(post("/createPost")
                .param("name", "name")
                .param("description", "desc")
                .param("id", "0"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(posts).update(any());
    }

    @Test
    @WithMockUser
    public void WhenCreatePostTest() throws Exception {
        mockMvc.perform(post("/createPost")
                .param("name", "name")
                .param("description", "desc"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(posts).add(any());
    }
}