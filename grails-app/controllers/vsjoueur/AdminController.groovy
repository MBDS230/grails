package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Admin
import mapping.Joueur
import org.springframework.web.servlet.ModelAndView
import utilitaire.StatusHttp

import java.security.MessageDigest

class AdminController
{

    private static String CHEMIN_PDP = "C:\\Users\\hjhonata\\Documents\\Kevine\\MBDS\\Greg\\";

    def getPasswordHash(String data) throws  Exception
    {
        String signature = "";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes("UTF-8"));
        byte[] bytes = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        signature = sb.toString();
        return signature;
    }

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
                StatusHttp statu = new StatusHttp(200, null, "/admin/dashboard");
                def responseData = [
                        'results': valiny,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            StatusHttp statu = new StatusHttp(500, "Utilisateur inexistant", "/admin/login");
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/admin/login");
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
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
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/admin/login");
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/admin/login");
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
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/admin/login");
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/admin/login");
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }


    def insererJoueur()
    {
        mapping.Joueur joueur = new Joueur();
        try
        {
            String username = params.getProperty("username")
            String motDePasse = params.getProperty("motDePasse")
            StatusHttp statu = new StatusHttp(500, "Vous devez importer un fichier pour le Profil", "/admin/dashboard");
            def file = request.getFile('uploadPhoto');
            if(file.empty)
            {
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                long currentMillis = System.currentTimeMillis();
                joueur = new UserService().inscription(username, motDePasse, CHEMIN_PDP+username+Long.toString(currentMillis)+".PNG");
                file.transferTo(new File(CHEMIN_PDP+joueur.getLogin()+Long.toString(currentMillis)+".PNG"))
                statu = new StatusHttp(200, null, "/admin/dashboard");
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
        } catch (Exception exc) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/admin/login");
            def responseData = [
                    'results': joueur,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/admin/login");
        def responseData = [
                'results': joueur,
                'status': statu
        ]
        render responseData as JSON
        return;
    }


    def listeJoueur()
    {
        try
        {
            Admin adminSession = (Admin) session.getAttribute("SESSION_ADMIN");
            if(adminSession!=null)
            {
                ArrayList<Joueur> arrJoueur = new JoueurDao().findAll();
                StatusHttp statu = new StatusHttp(200, null, "/admin/dashboard");
                def responseData = [
                        'results': arrJoueur,
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

    def modifierJoueur()
    {
        mapping.Joueur joueur = new Joueur();
        try
        {
            String username = params.getProperty("username")
            StatusHttp statu = new StatusHttp(500, "Vous devez importer un fichier pour le Profil", "/admin/dashboard");
            def file = request.getFile('uploadPhoto');
            if(file.empty)
            {
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
                long currentMillis = System.currentTimeMillis();
                joueur = new UserService().modifierJoueur(idJoueur, username, CHEMIN_PDP+username+Long.toString(currentMillis)+".PNG");
                file.transferTo(new File(CHEMIN_PDP+username+Long.toString(currentMillis)+".PNG"))
                statu = new StatusHttp(200, null, "/admin/dashboard");
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
        } catch (Exception exc) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            def responseData = [
                    'results': joueur,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        def responseData = [
                'results': joueur,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def supprimerJoueur()
    {
        try
        {
            Admin adminSession = (Admin) session.getAttribute("SESSION_ADMIN");
            if(adminSession!=null)
            {
                int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
                new JoueurDao().delete(idJoueur)
                StatusHttp statu = new StatusHttp(200, null, "/admin/dashboard");
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
        if(session.getAttribute("SESSION_ADMIN") == null)
        {
            redirect(controller: "admin",action: "login");
        }
        ArrayList<Joueur> joueursList = new JoueurDao().findAll();
        return new ModelAndView("/admin/dashboard",[joueurs:joueursList])
    }
    def login(){
        if(session.getAttribute("SESSION_ADMIN") != null)
        {
            redirect(controller: "admin",action: "dashboard");
        }
        return new ModelAndView("/admin/login")
    }
    def insert(){
        return new ModelAndView("/admin/insert")
    }

}
