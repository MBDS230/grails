package DAO

import Connecting.Connecting
import association.MatchJoueur
import mapping.Demandematch
import mapping.Joueur
import mapping.Match

class MatchDao {


    def findMatchByIdDemandeurAndRecepteur(int idDemandeur, int idRecepteur)
    {
        List<Match> lmatch = new ArrayList<>()
        Match match = new Match()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT match.* FROM match JOIN demandematch ON demandematch.iddemandematch = match.iddemandematch " +
                    "WHERE (demandematch.iddemandeur = "+idDemandeur+" AND demandematch.idrecepteur = "+idRecepteur+")  OR (demandematch.iddemandeur = "+idRecepteur+"  AND demandematch.idrecepteur = "+idDemandeur+")")
                    { resultSet ->
                        while (resultSet.next()) {
                            match.setIdmatch(resultSet.getInt("idmatch"))
                            match.setIddemandematch(resultSet.getInt('iddemandematch'))
                            match.setDatematch(resultSet.getDate("datematch"))
                            match.setScoredemandeur(resultSet.getInt("scoredemandeur"))
                            match.setScorerecepteur(resultSet.getInt("scorerecepteur"))
                            match.setDatedebut(resultSet.getDate("datedebut"))
                            match.setDatefin(resultSet.getDate("datefin"))
                            lmatch.add(match)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmatch
    }


    def findMatchByIdDemandematch(int idDemandeMatch){

        List<Match> lmatch = new ArrayList<>()
        Match match = new Match()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM match where 1 > 0 AND iddemandematch = "+idDemandeMatch)
                    { resultSet ->
                        while (resultSet.next()) {
                            match.setIdmatch(resultSet.getInt("idmatch"))
                            match.setIddemandematch(resultSet.getInt('iddemandematch'))
                            match.setDatematch(resultSet.getDate("datematch"))
                            match.setScoredemandeur(resultSet.getInt("scoredemandeur"))
                            match.setScorerecepteur(resultSet.getInt("scorerecepteur"))
                            match.setDatedebut(resultSet.getDate("datedebut"))
                            match.setDatefin(resultSet.getDate("datefin"))
                            lmatch.add(match)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmatch
    }

    def findAll(){

        List<Match> lmatch = new ArrayList<>();
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM match where 1 > 0")
            { resultSet ->
                while (resultSet.next()) {
                    Match match = new Match()
                    match.setIdmatch(resultSet.getInt("idmatch"))
                    match.setIddemandematch(resultSet.getInt('iddemandematch'))
                    match.setDatematch(resultSet.getDate("datematch"))
                    match.setScoredemandeur(resultSet.getInt("scoredemandeur"))
                    match.setScorerecepteur(resultSet.getInt("scorerecepteur"))
                    match.setDatedebut(resultSet.getDate("datedebut"))
                    match.setDatefin(resultSet.getDate("datefin"))
                    lmatch.add(match)
                }
            }
        }
        else
        {
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmatch
    }

    def findAllMatch(){

        List<MatchJoueur> lmatch = new ArrayList<>();
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM match where 1 > 0")
            { resultSet ->
                while (resultSet.next()) {
                    Match match = new Match()
                    match.setIdmatch(resultSet.getInt("idmatch"))
                    match.setIddemandematch(resultSet.getInt('iddemandematch'))
                    match.setDatematch(resultSet.getDate("datematch"))
                    match.setScoredemandeur(resultSet.getInt("scoredemandeur"))
                    match.setScorerecepteur(resultSet.getInt("scorerecepteur"))
                    match.setDatedebut(resultSet.getDate("datedebut"))
                    match.setDatefin(resultSet.getDate("datefin"))
                    Demandematch dem = new DemandematchDao().findByID(match.getIddemandematch());
                    Joueur joueur1 = new JoueurDao().findByID(dem.getIddemandeur());
                    Joueur joueur2 = new JoueurDao().findByID(dem.getIdrecepteur());
                    MatchJoueur matchJoueur = new MatchJoueur(match.getIdmatch(), joueur1.getLogin(), match.getDatematch(), match.getScoredemandeur(), joueur2.getLogin(), match.getScorerecepteur(), match.getDatedebut(), match.getDatefin());
                    lmatch.add(matchJoueur)
                }
            }
        }
        else
        {
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmatch
    }


    def findByID(int id){
        Match match = null

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM match where idmatch = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            match = new Match()
                            match.getIdmatch(resultSet.getInt("idmatch"))
                            match.getIddemandematch(resultSet.getInt('iddemandematch'))
                            match.getDatematch(resultSet.getDate("datematch"))
                            match.getScoredemandeur(resultSet.getInt("scoredemandeur"))
                            match.getScorerecepteur(resultSet.getInt("scorerecepteur"))
                            match.getDatedebut(resultSet.getDate("datedebut"))
                            match.getDatefin(resultSet.getDate("datefin"))

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return match
    }

    def update(Match match){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update match set iddemandematch = ?, datematch = ?, scoredemandeur = ?, scorerecepteur = ?, datedebut = ?, datefin = ? where idmatch = ?",
                    [match.getIddemandematch(),match.getDatematch(),match.getScoredemandeur(),match.getScorerecepteur(),match.getDatedebut(),match.getDatefin(),match.getIdmatch()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM match where idjoueur = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def insert(Match match){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into match values (?,?,?,?,?,?,?)",
                    [match.getIdmatch(),
                     match.getIddemandematch(),
                     match.getDatematch(),
                     match.getScoredemandeur(),
                     match.getScorerecepteur(),
                     match.getDatedebut(),
                     match.getDatefin()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }
}
