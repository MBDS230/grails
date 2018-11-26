package vsAdmin

import grails.converters.JSON
import mapping.Admin
import org.springframework.web.servlet.ModelAndView
import utilitaire.StatusHttp
import vsjoueur.AdminService

class AdminController
{

    def testGetSessionAdmin()
    {
        Admin val = (Admin) session.getAttribute("SESSION_ADMIN");
        if(val == null)
        {
            val = new Admin(0, 0, "TSIS ANATY SESSION", "Tsisssss", "zefzefzefzefze");
        }
        StatusHttp statu = new StatusHttp(200, null, "/game/accueil");
        def responseData = [
                'results': val,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def authentification()
    {
        try
        {
            Admin valiny = null;
            String username = params.getProperty("username");
            String motDePasse = params.getProperty("motDePasse");
            valiny = new AdminService().login(username, motDePasse);
            if(valiny != null)
            {
                session.setAttribute("SESSION_ADMIN", valiny);
            }
            StatusHttp statu = new StatusHttp(200, null, "/game/accueil");
            def responseData = [
                    'results': valiny,
                    'status': statu
            ]
            render responseData as JSON
            return;
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def logout()
    {
        Admin adminSession = (Admin) session.getAttribute("SESSION_ADMIN");
        if(adminSession != null)
        {
            new AdminService().logout(adminSession.getIdadmin());
        }
        session.removeAttribute("SESSION_ADMIN");
        session.invalidate();
        redirect(admin: "admin", action: "login")
    }

    def approuve()
    {
        Admin adminSession = null; // Admin SESSION
        if(adminSession!=null)
        {
            int idAdmin = Integer.parseInt(params.getProperty("idAdmin"));
            new AdminService().approuve(idAdmin);
        }
        else
        {
            redirect(admin: "admin", action: "login")
        }
    }

    def rejete()
    {
        Admin adminSession = (Admin) session.getAttribute("SESSION_ADMIN");
        if(adminSession!=null)
        {
            int idAdmin = Integer.parseInt(params.getProperty("idAdmin"));
            new AdminService().rejete(idAdmin);
        }
        else
        {
            redirect(admin: "admin", action: "login")
        }
    }

    def dashboard(){
        return new ModelAndView("/admin/dashboard")
    }
    def login(){
        return new ModelAndView("/admin/login")
    }
}
