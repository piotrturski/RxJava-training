package net.piotrturski.rx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    class MyController {

        @GetMapping("/1")
        Object m1() {
            return new SomeObject();
        }

        @GetMapping("/2")
        Object m2() {
            throw new IllegalArgumentException("5xx");
        }

        @GetMapping("/3")
        Object m3() {
            throw new HttpMessageNotReadableException("4xx");
        }

    }

    static class SomeObject {
        public int a = 1;
        public String b = "something";
    }
}
