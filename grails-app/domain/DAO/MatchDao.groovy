package DAO

import Connecting.Connecting
import mapping.Match

class MatchDao {

    def matchAll(){

        Match admin = new Match()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query('SELECT * FROM demandematch where 1 > 0')
                    { resultSet ->
                        while (resultSet.next()) {
                            admin.idadmin = resultSet.getInt("idadmin")
                            admin.idrole = resultSet.getInt('idrole')
                            admin.surnom = resultSet.getString("surnom")
                            admin.login = resultSet.getString("login")
                            admin.motdepasse = resultSet.getString("motdepasse")

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return admin
    }


    def matchByID(int id){
        Match admin = new Match()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM admin where idadmin = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin.idadmin = resultSet.getInt("idadmin")
                            admin.idrole = resultSet.getInt('idrole')
                            admin.surnom = resultSet.getString("surnom")
                            admin.login = resultSet.getString("login")
                            admin.motdepasse = resultSet.getString("motdepasse")

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return admin
    }

    def matchUpdate(Match admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM admin where idadmin = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin.idadmin = resultSet.getInt("idadmin")
                            admin.idrole = resultSet.getInt('idrole')
                            admin.surnom = resultSet.getString("surnom")
                            admin.login = resultSet.getString("login")
                            admin.motdepasse = resultSet.getString("motdepasse")

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return admin
    }

    def matchDelete(Match admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM admin where idadmin = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin.idadmin = resultSet.getInt("idadmin")
                            admin.idrole = resultSet.getInt('idrole')
                            admin.surnom = resultSet.getString("surnom")
                            admin.login = resultSet.getString("login")
                            admin.motdepasse = resultSet.getString("motdepasse")

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return admin
    }


    def matchInsert(Match admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM admin where idadmin = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin.idadmin = resultSet.getInt("idadmin")
                            admin.idrole = resultSet.getInt('idrole')
                            admin.surnom = resultSet.getString("surnom")
                            admin.login = resultSet.getString("login")
                            admin.motdepasse = resultSet.getString("motdepasse")

                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return admin
    }
}
