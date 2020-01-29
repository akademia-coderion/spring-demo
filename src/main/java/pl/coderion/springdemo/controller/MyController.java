package pl.coderion.springdemo.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderion.Euklides;
import pl.coderion.Ulamek;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/uprosc/{licznik}/{mianownik}")
    public String uproscUlamek(@PathVariable("licznik") int licznik,
                               @PathVariable("mianownik") int mianownik,
                               HttpServletRequest request) {

        Ulamek ulamek = new Ulamek(licznik, mianownik);
        System.out.println(String.format("[%s] %s %s", new Date(), request.getRemoteAddr(), ulamek));
        return Euklides.uprosc(ulamek).toString();
    }

    @PostMapping("/uprosc")
    public Ulamek uproscUlamekJson(@RequestBody Ulamek ulamek) {
        return Euklides.uprosc(ulamek);
    }
}