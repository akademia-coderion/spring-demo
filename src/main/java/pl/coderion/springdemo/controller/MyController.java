package pl.coderion.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.coderion.Euklides;
import pl.coderion.Ulamek;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/uprosc/{licznik}/{mianownik}")
    public String uproscUlamek(@PathVariable("licznik") int licznik, @PathVariable("mianownik") int mianownik) {

        Ulamek ulamek = new Ulamek(licznik, mianownik);
        return Euklides.uprosc(ulamek).toString();
    }
}