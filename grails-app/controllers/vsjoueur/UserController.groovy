package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Joueur
import utilitaire.StatusHttp

import java.security.MessageDigest


class UserController
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

    def testLogoutJoueur()
    {
        session.removeAttribute("SESSION_JOUEUR");
        session.invalidate();
        Joueur j = new Joueur(1, "", "ergergergere", false, 1);
        render j as JSON
    }

    def testGetSessionJoueur()
    {
        Joueur val = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(val == null)
        {
            val = new Joueur(1, "TSIS ANATY SESSION", "ergergergerer", false, 1);
        }
        render val as JSON;
    }

    def setSessionJoueur(Joueur joueur)
    {
        session.setAttribute("SESSION_JOUEUR", joueur);
    }

    def modifJoueur()
    {
        mapping.Joueur joueur = new Joueur();
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                String username = params.getProperty("username")
                String motDePasseAncien = params.getProperty("motDePasseAncien")
                String motDePasseNouveau = params.getProperty("motDePasseNouveau")
                String motDePasseConfirmation = params.getProperty("motDePasseConfirmation")
                StatusHttp statu = new StatusHttp(500, "Vous devez importer un fichier pour votre Profil", "/game/login");
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
                    joueur = new UserService().modifJoueur(joueurSession.getIdjoueur(), username, motDePasseAncien,motDePasseNouveau ,motDePasseConfirmation,CHEMIN_PDP+username+Long.toString(currentMillis)+".PNG");
                    if(joueur != null)
                    {
                        File f = new File(new File(CHEMIN_PDP+username+Long.toString(currentMillis)+".PNG"));
                        if(f.exists())
                        {
                            f.delete();
                        }
                        file.transferTo(f)
                    }
                    def responseData = [
                            'results': joueur,
                            'status': statu
                    ]
                    render responseData as JSON
                    return;
                }
            }
            else {
                redirect(controller: "game", action: "login")
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

    def inscription()
    {
        mapping.Joueur joueur = new Joueur();
        try
        {
            String username = params.getProperty("username")
            String motDePasse = params.getProperty("motDePasse")
            StatusHttp statu = new StatusHttp(500, "Vous devez importer un fichier pour votre Profil", "/game/login");
            def file = request.getFile('file');
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
                statu = new StatusHttp(200, null, "/game/index?inscription=success");
                joueur = new UserService().login(username, motDePasse);
                if(joueur != null)
                {
                    File f = new File(new File(CHEMIN_PDP+joueur.getLogin()+Long.toString(currentMillis)+".PNG"));
                    if(f.exists())
                    {
                        f.delete();
                    }
                    file.transferTo(f)
                    joueur.setStatus(true);
                    new JoueurDao().update(joueur);
                    session.setAttribute("SESSION_JOUEUR", joueur);
                }
                def responseData = [
                        'results': joueur,
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

    def login()
    {
        Joueur valiny = new Joueur();
        try
        {
            String username = params.getProperty("username");
            String motDePasse = params.getProperty("motDePasse");
            valiny = new UserService().login(username, motDePasse);
            if(valiny != null)
            {
                valiny.setStatus(true);
                new JoueurDao().update(valiny);
                session.setAttribute("SESSION_JOUEUR", valiny);
                StatusHttp statu = new StatusHttp(200, null, "/game/index");
                def responseData = [
                        'results': valiny,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            StatusHttp statu = new StatusHttp(500, "L'utilisateur n'existe pas", "/game/login");
            def responseData = [
                    'results': valiny,
                    'status': statu
            ]
            render responseData as JSON
            return;
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            def responseData = [
                    'results': valiny,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        def responseData = [
                'results': valiny,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def logout()
    {
        Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(joueurSession != null)
        {
            new UserService().logout(joueurSession.getIdjoueur());
        }
        session.removeAttribute("SESSION_JOUEUR");
        session.invalidate();
        redirect(controller: "game", action: "login")
    }

    def listeJoueurConnecte()
    {
        try
        {
            String htmlVal = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                htmlVal = new UserService().listeJoueurConnecteToHtml(joueurSession.getIdjoueur());
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': htmlVal,
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



}
