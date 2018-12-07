package vsjoueur

import Connecting.Connecting
import DAO.DemandematchDao
import DAO.JoueurDao
import DAO.MatchDao
import grails.gorm.transactions.Transactional
import mapping.Demandematch
import mapping.Joueur
import mapping.Match

import java.sql.Date


@Transactional
class MatchService
{

    def resultatMatch(int idJoueurConnecte, int idAutreJoueur)
    {
        List<Match> val = new ArrayList<>();
        if(idJoueurConnecte >0 && idAutreJoueur>0)
        {
            val = new MatchDao().findMatchByIdDemandeurAndRecepteur(idJoueurConnecte, idAutreJoueur);
        }
        Joueur autreJoueur = new JoueurDao().findByID(idAutreJoueur);
        String htmlVal = "";
        htmlVal += "<section id=\"cart_items\">";
        htmlVal += "<div class=\"table-responsive cart_info\">";
        htmlVal += "<h3>Résultats des matchs avec "+ autreJoueur.getLogin() + "</h3>";
        htmlVal += "<table class=\"table table-condensed mesDemandes\">";
        htmlVal += "<thead>\n" +
                "\t\t\t\t\t\t\t\t\t<tr class=\"cart_menu\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Id Match</th>\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Id Demande</th>\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Date Match</th>\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Votre score</th>\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Score adversaire</th>\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Date de debut</th>\n" +
                "\t\t\t\t\t\t\t\t\t\t<th>Date de fin</th>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</thead>";
        for(int i=0; i<val.size(); i++)
        {
                htmlVal += "<tbody>";
                htmlVal += "<tr>";
                htmlVal += "<td>"+ val.get(i).getIdmatch() +"</td>";
                htmlVal += "<td>"+ val.get(i).getIddemandematch() +"</td>";
                htmlVal += "<td>"+ val.get(i).getDatematch() +"</td>";
                htmlVal += "<td>"+ val.get(i).getScoredemandeur() +"</td>";
                htmlVal += "<td>"+ val.get(i).getScorerecepteur() +"</td>";
                htmlVal += "<td>"+ val.get(i).getDatedebut() +"</td>";
                htmlVal += "<td>"+ val.get(i).getDatefin() +"</td>";
                htmlVal += "</tr>";
                htmlVal += "<tbody>";
        }
        htmlVal += "</table>\n" +
                "\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</section>";
        return htmlVal;
    }

    def jouer(int idDemandeMatch)
    {
        if(idDemandeMatch >0)
        {
            Demandematch demande = new DemandematchDao().findByID(idDemandeMatch);
            if(demande!=null && demande.getAprouvee()==1)
            {
                List<Match> findMatch = new MatchDao().findMatchByIdDemandematch(idDemandeMatch);
                if(findMatch==null || findMatch.size()==0)
                {
                    int idMatch = Connecting.getMaxId("match");
                    idMatch++;
                    java.sql.Date jourCourant = new java.sql.Date(System.currentTimeMillis());

                    Match mInsert = new Match(idMatch, idDemandeMatch, jourCourant, 1, 0, jourCourant, jourCourant);
                    new MatchDao().insert(mInsert);
                }
                else
                {
                    throw new Exception("Match déja términé");
                }
            }
            else if(demande==null)
            {
                throw new Exception("Vous devez faire une demande de match");
            }
            else if(demande!=null && demande.getAprouvee()==0)
            {
                throw new Exception("Demande de match déja rejété");
            }
            else if(demande!=null && demande.getAprouvee()==2)
            {
                throw new Exception("Demande de match pas encore aprouvé pas l'autre joueur");
            }
        }
    }

    def demandeMatch(int joueurConnecte, int idAutreJoueur, int duree)
    {
        if(joueurConnecte>0 && idAutreJoueur>0 && duree>0)
        {
            JoueurDao jDao = new JoueurDao();
            Joueur demandeur = jDao.findByID(joueurConnecte);
            Joueur autreJoueur = jDao.findByID(idAutreJoueur);
            String htmlVal = "";
            if(demandeur!= null && autreJoueur!=null)
            {
                java.sql.Date jourCourant = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date demain = new Date(jourCourant.getYear(), jourCourant.getMonth(), jourCourant.getDay());
                DemandematchDao dmDao = new DemandematchDao();
                int iddemande = Connecting.getMaxId("demandematch");
                iddemande++;
                Demandematch dem = new Demandematch(iddemande, joueurConnecte, idAutreJoueur, duree, jourCourant, demain, 2);
                dmDao.insert(dem);
                htmlVal += "<tr>"
                htmlVal += "<td>"+ dem.getIddemandematch() +"</td>"
                htmlVal += "<td>"+ dem.getIdrecepteur() +"</td>"
                htmlVal += "<td>"+ dem.getDuree() +"</td>"
                htmlVal += "<td>"+ dem.getDatedemande()  +"</td>"
                htmlVal += "<td>"+ dem.getDateexpiration()  +"</td>"
                htmlVal += 	"<td><button class=\"btn btn-primary\">"+ dem.getAprouvee() +"</button></td>"
                htmlVal += 	"</tr>"
                return htmlVal;
            }
            else
            {
                throw new Exception("Joueur inexistant");
            }
        }
    }

    def listeDemandeAutresJoueurs(int idJoueurConnecte)
    {
        ArrayList <Demandematch> listDem = new ArrayList<>();
        if(idJoueurConnecte>0)
        {
            listDem = new DemandematchDao().findByRecepteurAndAprouve(idJoueurConnecte, 2);
        }
        return listDem;
    }

    def listeDeMesDemandes(int idJoueurConnecte)
    {
        ArrayList <Demandematch> listDem = new ArrayList<>();
        if(idJoueurConnecte>0)
        {
            listDem = new DemandematchDao().findByEnvoyeurAndAprouve(idJoueurConnecte, 2);
        }
        return listDem;
    }

    def aprouverDemandeMatch(int idDemandeMatch)
    {
        Demandematch demande = new DemandematchDao().findByID(idDemandeMatch);
        demande.setAprouvee(1);
        new DemandematchDao().update(demande);
    }

}
