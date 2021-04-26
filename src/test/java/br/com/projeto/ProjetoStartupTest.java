package br.com.projeto;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProjetoStartupTest {
    @Test
    @DisplayName("Testando todo o contexto do projeto")
    public void contextLoads() {
    }
}
