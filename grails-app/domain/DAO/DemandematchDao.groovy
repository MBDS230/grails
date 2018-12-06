package DAO

import Connecting.Connecting
import mapping.Demandematch

class DemandematchDao {

      def findAll(){
        List<Demandematch> ldemandeMatch = new ArrayList<>()
        Demandematch demandeMatch = new Demandematch()

        def sql = Connecting.getConnection()
        if(sql != null){
            sql.query('SELECT * FROM demandematch where 1 > 0')
                    { resultSet ->
                        while (resultSet.next()) {
                            demandeMatch.setIddemandematch(resultSet.getInt("iddemandematch"))
                            demandeMatch.setIddemandeur(resultSet.getInt('iddemandeur'))
                            demandeMatch.setIdrecepteur(resultSet.getInt('idrecepteur'))
                            demandeMatch.setDuree(resultSet.getInt('duree'))
                            demandeMatch.setDatedemande(resultSet.getDate("datedemande"))
                            demandeMatch.setDateexpiration(resultSet.getDate("dateexpiration"))
                            demandeMatch.setAprouvee(resultSet.getInt('aprouvee'))
                            ldemandeMatch.add(demandeMatch)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ldemandeMatch
    }

    def findByRecepteurAndAprouve(int idRecepteur, int aprouve)    {
        List<Demandematch> ldemandeMatch = new ArrayList<>()
        Demandematch demandeMatch = new Demandematch()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM demandematch where idrecepteur = "+idRecepteur+" and aprouvee = "+aprouve)
                    { resultSet ->
                        while (resultSet.next()) {
                            demandeMatch.setIddemandematch(resultSet.getInt("iddemandematch"))
                            demandeMatch.setIddemandeur(resultSet.getInt('iddemandeur'))
                            demandeMatch.setIdrecepteur(resultSet.getInt('idrecepteur'))
                            demandeMatch.setDuree(resultSet.getInt('duree'))
                            demandeMatch.setDatedemande(resultSet.getDate("datedemande"))
                            demandeMatch.setDateexpiration(resultSet.getDate("dateexpiration"))
                            demandeMatch.setAprouvee(resultSet.getInt('aprouvee'))
                            ldemandeMatch.add(demandeMatch)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ldemandeMatch
    }

    def findByEnvoyeurAndAprouve(int idEnvoyeur, int aprouve)    {
        List<Demandematch> ldemandeMatch = new ArrayList<>()
        Demandematch demandeMatch = new Demandematch()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM demandematch where idenvoyeur = "+idEnvoyeur+" and aprouvee = "+aprouve)
                    { resultSet ->
                        while (resultSet.next()) {
                            demandeMatch.setIddemandematch(resultSet.getInt("iddemandematch"))
                            demandeMatch.setIddemandeur(resultSet.getInt('iddemandeur'))
                            demandeMatch.setIdrecepteur(resultSet.getInt('idrecepteur'))
                            demandeMatch.setDuree(resultSet.getInt('duree'))
                            demandeMatch.setDatedemande(resultSet.getDate("datedemande"))
                            demandeMatch.setDateexpiration(resultSet.getDate("dateexpiration"))
                            demandeMatch.setAprouvee(resultSet.getInt('aprouvee'))
                            ldemandeMatch.add(demandeMatch)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ldemandeMatch
    }

    def findByID(int id){
        Demandematch demandeMatch = null

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM demandematch where iddemandematch = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            demandeMatch = new Demandematch()
                            demandeMatch.setIddemandematch(resultSet.getInt("iddemandematch"))
                            demandeMatch.setIddemandeur(resultSet.getInt('iddemandeur'))
                            demandeMatch.setIdrecepteur(resultSet.getInt('idrecepteur'))
                            demandeMatch.setDuree(resultSet.getInt('duree'))
                            demandeMatch.setDatedemande(resultSet.getDate("datedemande"))
                            demandeMatch.setDateexpiration(resultSet.getDate("dateexpiration"))
                            demandeMatch.setAprouvee(resultSet.getInt('aprouvee'))

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return demandeMatch
    }

    def update(Demandematch demandeMatch){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update demandematch set iddemandeur = ? , idrecepteur = ?, duree = ?, datedemande = ?, dateexpiration = ?,aprouvee = ? where iddemandematch = ?", [demandeMatch.getIddemandematch(),demandeMatch.getIddemandeur(),demandeMatch.getIdrecepteur(),demandeMatch.getDuree(),demandeMatch.getDatedemande(),demandeMatch.getDateexpiration(),demandeMatch.getAprouvee()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM demandematch where idadmin = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def insert(Demandematch demandeMatch){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into demandematch values (?,?,?,?,?,?,?)", [demandeMatch.getIddemandematch(),demandeMatch.getIddemandeur(),demandeMatch.getIdrecepteur(),demandeMatch.getDuree(),demandeMatch.getDatedemande(),demandeMatch.getDateexpiration(),demandeMatch.getAprouvee()])

        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }
}
