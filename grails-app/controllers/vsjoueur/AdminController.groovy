package vsjoueur

import mapping.Admin
import org.springframework.web.servlet.ModelAndView

class AdminController {

    def approuve()
    {
        Admin adminSession = null; // Admin SESSION
        if(adminSession!=null)
        {
            int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
            new AdminService().approuve(idJoueur);
        }
        else
        {

        }
    }

    def rejete()
    {
        Admin adminSession = null; // Admin SESSION
        if(adminSession!=null)
        {
            int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
            new AdminService().rejete(idJoueur);
        }
        else
        {

        }
    }

    def dashboard(){
        return new ModelAndView("/admin/dashboard")
    }
    def login(){
        return new ModelAndView("/admin/login")
    }
}
