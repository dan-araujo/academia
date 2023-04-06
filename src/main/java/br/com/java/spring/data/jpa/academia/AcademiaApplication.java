package br.com.java.spring.data.jpa.academia;

import br.com.java.spring.data.jpa.academia.config.utils.DateTimeUtils;
import br.com.java.spring.data.jpa.academia.config.utils.jsonparser.JsonMapperConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademiaApplication.class, args);
    }

}
