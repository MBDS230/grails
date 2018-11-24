package DAO

import Connecting.Connecting
import mapping.Match

class MatchDao {

    def matchAll(){

        List<Match> lmatch = new ArrayList<>()
        Match match = new Match()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query('SELECT * FROM match where 1 > 0')
                    { resultSet ->
                        while (resultSet.next()) {
                            match.getIdmatch(resultSet.getInt("idmatch"))
                            match.getIddemandematch(resultSet.getInt('iddemandematch'))
                            match.getDatematch(resultSet.getDate("datematch"))
                            match.getScoredemandeur(resultSet.getInt("scoredemandeur"))
                            match.getScorerecepteur(resultSet.getInt("scorerecepteur"))
                            match.getDatedebut(resultSet.getDate("datedebut"))
                            match.getDatefin(resultSet.getDate("datefin"))
                            lmatch.add(match)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmatch
    }


    def matchByID(int id){
        List<Match> lmatch = new ArrayList<>()
        Match admin = new Match()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM match where idmatch = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            match.getIdmatch(resultSet.getInt("idmatch"))
                            match.getIddemandematch(resultSet.getInt('iddemandematch'))
                            match.getDatematch(resultSet.getDate("datematch"))
                            match.getScoredemandeur(resultSet.getInt("scoredemandeur"))
                            match.getScorerecepteur(resultSet.getInt("scorerecepteur"))
                            match.getDatedebut(resultSet.getDate("datedebut"))
                            match.getDatefin(resultSet.getDate("datefin"))
                            lmatch.add(match)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmatch
    }

    def matchUpdate(Match match){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update match set iddemandematch = ?, datematch = ?, scoredemandeur = ?, scorerecepteur = ?, datedebut = ?, datefin = ? where idmatch = ?",
                    [match.getIddemandematch(),match.getDatematch(),match.getScoredemandeur(),match.getScorerecepteur(),match.getDatedebut(),match.getDatefin(),match.getIdmatch()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def matchDelete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM match where idjoueur = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def matchInsert(Match match){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into match values (?,?,?,?,?,?,?)",
                    [match.getIdmatch(),match.getIddemandematch(),match.getDatematch(),match.getScoredemandeur(),match.getScorerecepteur(),match.getDatedebut(),match.getDatefin()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }
}
