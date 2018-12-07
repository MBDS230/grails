package vsjoueur

import grails.converters.JSON
import mapping.Demandematch
import mapping.Joueur
import org.springframework.web.servlet.ModelAndView
import utilitaire.StatusHttp

class MatchController {

    def resultatMatch()
    {
        try
        {
            String val = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if (joueurSession != null)
            {
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                val = new MatchService().resultatMatch(joueurSession.getIdjoueur(),idAutreJoueur );
                StatusHttp statu = new StatusHttp(200, null, "/game/login");
                def responseData = [
                        'results': val,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "game", action: "login")
            }

        } catch (Exception exc) {
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

    def jouer()
    {
        try
        {
            ArrayList<Joueur> val = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if (joueurSession != null)
            {
                int idDemandeMatch = Integer.parseInt(params.getProperty("idDemandeMatch"));
                MatchService matchService = new MatchService();
                matchService.aprouverDemandeMatch(idDemandeMatch);
                matchService.jouer(idDemandeMatch);
                StatusHttp statu = new StatusHttp(200, null, "/game/index");
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "game", action: "login")
            }

        } catch (Exception exc) {
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

    def demandeMatch()
    {
        try
        {
            Joueur joueurSession =(Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                int duree = Integer.parseInt(params.getProperty("duree"));
                int joueurConnecte = joueurSession.getIdjoueur();
                String html = new MatchService().demandeMatch(joueurConnecte, idAutreJoueur, duree);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': html,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "game", action: "login")
            }
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;

    }

    def listeDeMesDemandes()
    {
        try
        {
            ArrayList<Demandematch> listDem = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idJoueurConnecte = joueurSession.getIdjoueur();
                listDem = new MatchService().listeDeMesDemandes(idJoueurConnecte);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': listDem,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
        }catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def listeDemandeAutresJoueurs()
    {
        try
        {
            ArrayList<Demandematch> listDem = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idJoueurConnecte = joueurSession.getIdjoueur();
                listDem = new MatchService().listeDemandeAutresJoueurs(idJoueurConnecte);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': listDem,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
        }catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def renderTest()
    {
        //redirect(controller: "match", action: "testrehetra")
        return new ModelAndView("/match/testrehetra");
    }
}
