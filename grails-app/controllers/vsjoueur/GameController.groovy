package vsjoueur

import org.springframework.web.servlet.ModelAndView
import mapping.Joueur

class GameController {

    def index() {
        if(session.getAttribute("SESSION_JOUEUR") == null)
        {
            redirect(controller: "game", action: "login");
            return;
        }
        Joueur joueur = session.getAttribute("SESSION_JOUEUR");
        String inscription = params.getProperty("inscription");
        boolean inscrit = false;
        if(inscription != null && inscription == 'success')
        {
            inscrit = true;
        }
        return new ModelAndView("/game/index",[inscrit:inscrit,joueur:joueur])
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
