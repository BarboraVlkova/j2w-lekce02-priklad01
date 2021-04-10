package cz.czechitas.java2webapps.lekce2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;


/* @Controller rika, ze tahle mnou vytvorena trida je kontroler */
/* rekne Stringu, vem tuhle tridu a chovej se k ni jako ke kontroleru */

@Controller
public class KostkaController {

    /* metoda GET rika,ze chci ziskat tu stranku */
    /* musi to byt trida a verejna */
    /* @GetMapping("/") */


    /* trida Random v balicku UtilRandom a generuje nahodna cisla*/
    private final Random random;

    public KostkaController() {
        random = new Random();
    }

    /* metoda ModelAndView bude vracet tridu typu ModelAndView, ve kterym jsou informace MODEL a VIEW = data, ktera se maji zobrazit */
    /* jaky data se maji zobrazit predam jako paramatr */
    @GetMapping("/")
    public ModelAndView hodKostkou() {
        int nahodneCislo = random.nextInt(6)+1;

        ModelAndView result = new ModelAndView("kostka");
        result.addObject("cislo",nahodneCislo);
        /* ve tride string existuje metoda format */
        /* jako prvni parametr da text (to je sablona) */
        /* ma se vlozit cislo v desitkove soustave */
        /* za carkou je hodnota, ktera se tam ma vlozit */
        result.addObject("obrazek",String.format("/images/kostka-%d.svg", nahodneCislo));
        return result;

    }
}
