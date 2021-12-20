package com.luisa;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luisa.domain.Cidade;
import com.luisa.domain.Cliente;
import com.luisa.domain.Endereco;
import com.luisa.domain.Estado;
import com.luisa.domain.enuns.TipoCliente;
import com.luisa.domain.repositories.CidadeRepository;
import com.luisa.domain.repositories.ClienteRepository;
import com.luisa.domain.repositories.EnderecoRepository;
import com.luisa.domain.repositories.EstadoRepository;

@SpringBootApplication
public class LuisaApplication implements CommandLineRunner {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public static void main(String[] args) {
        SpringApplication.run(LealApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");
        estadoRepository.saveAll(Arrays.asList(est1,est2));

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        cidadeRepository.saveAll(Arrays.asList(c1,c2));

        Cliente cli1 = new  Cliente(null, "Luisa Nielsen", "12234578908", "lealthiagom@hotmail.com", 
                TipoCliente.PESSOAFISICA);
        Cliente cli2 = new  Cliente(null, "pessoa2", "33322277790", "pessoa2123@gmail.com",
        		TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("24000002345", "12124354987"));
        cli2.getTelefones().addAll(Arrays.asList("44444567789", "00000987656"));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2));

        Endereco e1 = new Endereco(null, "Rua das Piranhas", "69","", "roosevelt", "38534534",cli1,c1);
        Endereco e2 = new Endereco(null, "Rua Iônica", "99","", "Centro", "06678014",cli2,c2);
        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli2.getEnderecos().addAll(Arrays.asList(e2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));

    }

}

