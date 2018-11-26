package vsjoueur

import grails.converters.JSON
import mapping.Admin
import org.springframework.web.servlet.ModelAndView
import utilitaire.StatusHttp

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
        try
        {
            Admin adminSession = (Admin) session.getAttribute("SESSION_ADMIN");
            if(adminSession!=null)
            {
                int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
                new AdminService().approuve(idJoueur);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "admin", action: "login")
            }
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

    def rejete()
    {
        try
        {
            Admin adminSession = (Admin) session.getAttribute("SESSION_ADMIN");
            if(adminSession!=null)
            {
                int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
                new AdminService().rejete(idJoueur);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "admin", action: "login")
            }

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

    def dashboard(){
        return new ModelAndView("/admin/dashboard")
    }
    def login(){
        return new ModelAndView("/admin/login")
    }
    def insert(){
        return new ModelAndView("/admin/insert")
    }

}
