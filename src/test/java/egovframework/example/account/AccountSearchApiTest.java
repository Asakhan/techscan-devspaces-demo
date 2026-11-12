package egovframework.example.account;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AccountSearchApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchIsMasked() throws Exception {
        mockMvc.perform(get("/api/accounts/search").param("holderNm", "홍").param("sort", "BALANCE"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(2)))
               .andExpect(jsonPath("$[0].accountNo").value("110-***-***789"));
    }

    @Test
    void injectionInSearchIsTreatedAsText() throws Exception {
        mockMvc.perform(get("/api/accounts/search").param("holderNm", "%' OR '1'='1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void unknownSortFallsBackToDefault() throws Exception {
        mockMvc.perform(get("/api/accounts/search").param("holderNm", "홍").param("sort", "(SELECT 1)"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void detailIsMasked() throws Exception {
        mockMvc.perform(get("/api/accounts/A0003"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.accountNo").value("333-**-****789"));
    }
}
