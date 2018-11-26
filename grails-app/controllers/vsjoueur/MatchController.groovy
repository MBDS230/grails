package vsjoueur

import grails.converters.JSON
import mapping.Demandematch
import mapping.Joueur
import org.springframework.web.servlet.ModelAndView
import utilitaire.StatusHttp

class MatchController {

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
                new MatchService().demandeMatch(joueurConnecte, idAutreJoueur, duree);
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

    def listeDemandeRencontre()
    {
        try
        {
            ArrayList<Demandematch> listDem = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idJoueurConnecte = joueurSession.getIdjoueur();
                listDem = new MatchService().listeDemandeRencontre(idJoueurConnecte);
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
