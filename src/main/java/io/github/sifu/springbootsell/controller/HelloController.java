package io.github.sifu.springbootsell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello
 *
 * @author sifu
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld!";
    }
}
