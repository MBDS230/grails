package vsjoueur

import org.springframework.web.servlet.ModelAndView


class TestController {

    def index() {
        return "wawa";
    }

    def lista() {
        def textko = params.getProperty("textko");
        def testVariable = "adalabe";
        String miverina = textko.toString();
        Joueur j = new Joueur(1, "Kevin Jonathan");
        Joueur j2 = new Joueur(2, miverina);
        List<Joueur> listJ = new ArrayList(2);
        listJ.add(j);
        listJ.add(j2);
        return new ModelAndView("/test/vuako", [testVar: listJ , testa : "adala oa"])
    }
}
