package vsjoueur

import org.springframework.web.servlet.ModelAndView

class GameController {

    def index() {
        return new ModelAndView("/game/index")
    }

    def login(){
        return new ModelAndView("/game/login")
    }
}
