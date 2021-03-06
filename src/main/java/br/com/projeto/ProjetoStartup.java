package br.com.projeto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"br.com.projeto"})
public class ProjetoStartup {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoStartup.class,args);
    }
}
