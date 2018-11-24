package DAO

import Connecting.Connecting
import groovy.sql.Sql
import mapping.Admin

class AdminDao {



    def adminFindAll(){

        Admin admin = new Admin()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query('SELECT * FROM admin where 1 > 0')
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


    def adminFindByID(int id){
        Admin admin = new Admin()

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

    def adminUpdate(Admin admin){

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

    def adminDelete(Admin admin){

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


    def adminInsert(Admin admin){

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
