package DAO

import Connecting.Connecting
import mapping.Cron

class CronDao {

    def findByActive()
    {
        List<Cron> lcron = new ArrayList<>();

        def sql = Connecting.getConnection();

        if(sql != null)
        {
            sql.query("SELECT * FROM cron where active = TRUE ")
                { resultSet ->
                    while (resultSet.next()) {
                        Cron cron = new Cron()
                        cron.setIdcron(resultSet.getInt("idcron"))
                        cron.setIdenvoyeur(resultSet.getInt("idenvoyeur"))
                        cron.setIdrecepteur(resultSet.getInt("idrecepteur"))
                        cron.setActive(resultSet.getBoolean('active'))
                        lcron.add(cron)
                    }
                }
        }
        else
        {
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lcron;
    }

    def findByRecepteurAndEnvoyeur(int idEnvoyeur, int idRecepteur){

        List<Cron> lcron = new ArrayList<>()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM cron where ( idenvoyeur = "+idEnvoyeur+" AND idrecepteur = "+idRecepteur+" ) OR ( idrecepteur = "+idEnvoyeur+" AND idenvoyeur = "+idRecepteur+" ) ")
                    { resultSet ->
                        while (resultSet.next()) {
                            Cron cron = new Cron()
                            cron.setIdcron(resultSet.getInt("idcron"))
                            cron.setIdenvoyeur(resultSet.getInt("idenvoyeur"))
                            cron.setIdrecepteur(resultSet.getInt("idrecepteur"))
                            cron.setActive(resultSet.getBoolean('active'))
                            lcron.add(cron)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lcron;
    }

    def findAll(){

        List<Cron> lcron = new ArrayList<>()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM cron where 1 > 0")
                    { resultSet ->
                        while (resultSet.next()) {
                            Cron cron = new Cron()
                            cron.setIdcron(resultSet.getInt("idcron"))
                            cron.setIdenvoyeur(resultSet.getInt("idenvoyeur"))
                            cron.setIdrecepteur(resultSet.getInt("idrecepteur"))
                            cron.setActive(resultSet.getBoolean('active'))
                            lcron.add(cron)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lcron;
    }

    def findByID(int id){
        Cron cron = null;
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM cron where idcron = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            cron = new Cron()
                            cron.setIdcron(resultSet.getInt("idcron"))
                            cron.setIdenvoyeur(resultSet.getInt("idenvoyeur"))
                            cron.setIdrecepteur(resultSet.getInt("idrecepteur"))
                            cron.setActive(resultSet.getBoolean('active'))
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return cron;
    }

    def update(Cron cron){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update cron set idenvoyeur = ?, idrecepteur = ?, active = ? where idcron = ?",
                    [cron.getIdenvoyeur(),cron.getIdrecepteur(),cron.getActive(),cron.getIdcron()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM cron where idcron = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def insert(Cron cron){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into cron values(?, ?, ?, ?)", [cron.getIdcron(), cron.getIdenvoyeur(), cron.getIdrecepteur(), cron.getActive()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }
}
