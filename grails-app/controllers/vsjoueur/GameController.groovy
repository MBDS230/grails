package vsjoueur

import org.springframework.web.servlet.ModelAndView

class GameController {

    def index() {
        if(session.getAttribute("SESSION_JOUEUR") == null)
        {
            redirect(controller: "game", action: "login");
            return;
        }
        String inscription = params.getProperty("inscription");
        boolean inscrit = false;
        if(inscription != null && inscription == 'success')
        {
            inscrit = true;
        }
        return new ModelAndView("/game/index",[inscrit:inscrit])
    }

    def login(){
        if(session.getAttribute("SESSION_JOUEUR") != null)
        {
            redirect(controller: "game", action: "index");
            return;
        }
        return new ModelAndView("/game/login")
    }
}
