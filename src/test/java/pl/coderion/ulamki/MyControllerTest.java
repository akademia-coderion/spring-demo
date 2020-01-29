package pl.coderion.ulamki;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.coderion.Ulamek;
import pl.coderion.springdemo.SpringDemoApplication;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SpringDemoApplication.class)
@AutoConfigureMockMvc
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        this.mockMvc
                .perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello world")));
    }

    @Test
    public void shouldUproscGet() throws Exception {
        this.mockMvc
                .perform(get("/uprosc/12/18"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[2/3]")));
    }

    @Test
    public void shouldUproscPost() throws Exception {
        Ulamek ulamek = new Ulamek(12, 18);

        this.mockMvc
                .perform(post("/uprosc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ulamek)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.licznik").value(2))
                .andExpect(jsonPath("$.mianownik").value(3));
    }
}
