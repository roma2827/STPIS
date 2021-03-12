package com.stpis.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stpis.backend.entity.BO.UserBO;
import com.stpis.backend.entity.ServiceEntity;
import com.stpis.backend.entity.SubscriptionsEntity;
import com.stpis.backend.entity.UserEntity;
import com.stpis.backend.repository.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void getUserByLogin() throws Exception {
        this.mockMvc.perform(get("/api/user/login/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void createUser() throws Exception {
        UserBO userBO = new UserBO();
        userBO.setLogin("login"); userBO.setPassword("password");
        MockHttpServletResponse response = this.mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userBO)))
                .andExpect(status().isOk()).andReturn().getResponse();
        UserEntity user = objectMapper.readValue(response.getContentAsString(), UserEntity.class);
        userRepo.deleteById(user.getUserId());
    }

    @Test
    public void subscribe() throws Exception {
        SubscriptionsEntity subscriptionsEntity = new SubscriptionsEntity();
        subscriptionsEntity.setUserId(2L); subscriptionsEntity.setServiceId(1L);
        this.mockMvc.perform(post("/api/subscription")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(subscriptionsEntity)))
                .andExpect(status().isOk()).andReturn().getResponse();
    }

    @Test
    public void getAll() throws Exception {
        this.mockMvc.perform(get("/api/service"))
                .andExpect(status().isOk());
    }

    @Test
    public void create() throws Exception {
        ServiceEntity request = new ServiceEntity();
        request.setCoast(BigDecimal.ONE);
        request.setName("test"); request.setDescription("test");
        this.mockMvc.perform(post("/api/service")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/service/1"))
                .andExpect(status().isOk());
    }
}
