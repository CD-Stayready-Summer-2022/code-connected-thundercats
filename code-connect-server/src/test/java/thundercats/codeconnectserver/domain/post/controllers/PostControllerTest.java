package thundercats.codeconnectserver.domain.post.controllers;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.post.BaseControllerTest;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.post.services.PostService;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class PostControllerTest {

    @MockBean
    private PostService mockPostService;

    @Autowired
    private MockMvc mockMvc;

    private Post mockPost01;
    private Post savedPost01;
    private Post savedPost02;

    @BeforeEach
    public void setUp() {
        mockPost01 = new Post(null, "This is a post", 5, new ArrayList<>());

        savedPost01 = new Post(null, "This is a post", 5, new ArrayList<>());
        savedPost01.setId(1L);

        savedPost02 = new Post(null, "Postssdsda", 500, new ArrayList<>());
        savedPost02.setId(1L);
    }

    @Test
    @DisplayName("Post POST - success")
    public void createTest01() throws Exception {
        BDDMockito.doReturn(savedPost01).when(mockPostService).create(any(), any());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BaseControllerTest.asJsonString(mockPost01)))

                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publisher", Is.is(null)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("This is a post")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.likes", Is.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.comments", Is.is(null)));
    }

    @Test
    @DisplayName("Post GET by id - success")
    public void getByIdTest01() throws Exception {
        BDDMockito.doReturn(savedPost01).when(mockPostService).getById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/1"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publisher", Is.is(null)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("This is a post")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.likes", Is.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.comments", Is.is(null)));
    }

    @Test
    @DisplayName("Post GET by id - failed")
    public void getByIdTest02() throws Exception {
        BDDMockito.doThrow(new ResourceNotFoundException("Not Found")).when(mockPostService).getById(1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/posts/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Post PUT - success")
    public void updateTest01() throws Exception {
        Post updated = new Post(null, "This is a post", 50000, new ArrayList<>());
        updated.setId(1L);
        BDDMockito.doReturn(updated).when(mockPostService).update(any(), any());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/posts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BaseControllerTest.asJsonString(updated)))

                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publisher", Is.is(null)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Is.is("This is a post")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.likes", Is.is(50000)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.comments", Is.is(null)));
    }

    @Test
    @DisplayName("Post PUT - failed")
    public void updateTest02() throws Exception {
        BDDMockito.doThrow(new ResourceNotFoundException("Not found")).when(mockPostService).update(any(), any());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/posts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(BaseControllerTest.asJsonString(mockPost01)))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Post DELETE - success")
    public void deleteTest01() throws Exception {
        BDDMockito.doNothing().when(mockPostService).delete(any());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/posts/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @DisplayName("Post DELETE - failed")
    public void deleteTest02() throws Exception {
        BDDMockito.doThrow(new ResourceNotFoundException("Not Found")).when(mockPostService).delete(any());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
