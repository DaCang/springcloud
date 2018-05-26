package com.feiyangedu.springcloud.hello;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot Application.
 * 
 * @author Michael Liao
 */
@Controller
@EnableAutoConfiguration
@SpringBootApplication
@RestController
@EnableSwagger2
public class HelloApplication {

    /**
     * http://localhost:9090/
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String home() {
        return "<h1>Hello World!</h1>";
    }

    /**
     * http://localhost:9090/api/
     * @return
     */
    @RequestMapping(value = "/api", method = RequestMethod.GET)
	public String[] api(@RequestParam(value="name") String name,@RequestParam(value="age", required=false) Integer age) {
		return ("你好 name:"+name+" age:"+(age==null?0:age)+" 欢迎学习 Spring Boot Application").split(" ");
	}

    /**
     * 第一个springCloud App
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloApplication.class, args);
	}
}
