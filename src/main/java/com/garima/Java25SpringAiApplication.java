package com.garima;// Java 25 Compact Source File Demo (we'll evolve this)
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Java25SpringAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java25SpringAiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ChatClient.Builder chatClientBuilder) {
        return args -> {
            System.out.println("🚀 Java 25 + Spring AI Starter is running!");
            System.out.println("Make sure Ollama is running with: ollama run mistral");
        };
    }
}

// Simple REST Controller
@RestController
class HelloAIController {

    private final ChatClient chatClient;

    HelloAIController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ai/hello")
    String hello() {
        return chatClient.prompt()
                .user("Say hello in a fun way to Garima's GitHub followers learning Spring AI!")
                .call()
                .content();
    }
}