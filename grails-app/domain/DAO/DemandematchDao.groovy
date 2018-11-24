package DAO

import Connecting.Connecting
import mapping.Demandematch

class DemandematchDao {

    def demandematchFindAll(){

        Demandematch admin = new Demandematch()

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


    def demandematchdByID(int id){
        Demandematch admin = new Demandematch()

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

    def demandematchUpdate(Demandematch admin){

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

    def demandematchDelete(Demandematch admin){

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


    def demandematchInsert(Demandematch admin){

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
