package Restfulwebservices.Restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class HelloWorldController {

        @GetMapping("/users")
        public String helloWorld() {
            return "Hello  world";
        }

        @GetMapping("/usersBean")
        public helloWorldBean helloWorldBean() {
            return new helloWorldBean("Hello world bean");
        }

        @GetMapping("/usersBean/patha-variable/{name}")
        public helloWorldBean helloWorldPathVariable (@PathVariable String name) {
            return new helloWorldBean(String.format("Hello world bean, %s",name));
        }
    }