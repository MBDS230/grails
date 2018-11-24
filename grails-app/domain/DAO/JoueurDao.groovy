package DAO

import Connecting.Connecting
import mapping.Joueur

class JoueurDao {

    def joueurFindAll(){

        Joueur admin = new Joueur()

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


    def joueurByID(int id){
        Joueur admin = new Joueur()

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

    def joueurUpdate(Joueur admin){

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

    def joueurDelete(Joueur admin){

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


    def joueurInsert(Joueur admin){

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
