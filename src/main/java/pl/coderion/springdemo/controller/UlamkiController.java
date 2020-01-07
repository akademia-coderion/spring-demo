package pl.coderion.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderion.Euklides;
import pl.coderion.Ulamek;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UlamkiController {

    @GetMapping("/simplify/{licznik}/{mianownik}")
    public String uproscUlamekSzablon(@PathVariable("licznik") int licznik,
                                      @PathVariable("mianownik") int mianownik,
                                      HttpServletRequest request,
                                      Model model) {

        Ulamek ulamek = new Ulamek(licznik, mianownik);
        Ulamek ulamekUproszczony = Euklides.uprosc(ulamek);

        model.addAttribute("licznik", licznik);
        model.addAttribute("mianownik", mianownik);
        model.addAttribute("licznikUproszczony", ulamekUproszczony.getLicznik());
        model.addAttribute("mianownikUproszczony", ulamekUproszczony.getMianownik());

        System.out.println(String.format("[%s] %s %s", new Date(), request.getRemoteAddr(), ulamek));

        return "simplify";
    }
}
