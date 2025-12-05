package com.starcard.starpeople;

import com.starcard.starpeople.model.Setor;
import com.starcard.starpeople.repository.SetorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarpeopleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarpeopleApplication.class, args);
    }

    // O método @Bean tem que estar DENTRO da classe (antes da última chave)
    @Bean
    public CommandLineRunner demo(SetorRepository repository) {
        return (args) -> {
            System.out.println("----- INICIANDO TESTE DE BANCO -----");

            // 1. Criar objeto
            Setor novoSetor = new Setor();
            novoSetor.setNome("Recursos Humanos");

            // 2. Mandar repositorio salvar (INSERT NO BANCO)
            repository.save(novoSetor);

            System.out.println("✅ SUCESSO! Setor salvo: " + novoSetor.getNome());
            System.out.println("--------------------------------------");
        };
    }

}