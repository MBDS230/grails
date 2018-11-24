package DAO

import Connecting.Connecting
import groovy.sql.Sql
import mapping.Admin

class AdminDao {



    def adminFindAll(){

        List<Admin> ladmin = new ArrayList<>()
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
                            ladmin.add(admin)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ladmin
    }

    def adminFindByLoginAndPassword(String login, String motdepasse) {
        List<Admin> ladmin = new ArrayList<>()
        Admin admin = new Admin()

        def sql = Connecting.getConnection()
        if(sql != null){
            sql.query("SELECT * FROM admin where login = "+id+" and motdepasse = "+motdepasse)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin.idadmin = resultSet.getInt("idadmin")
                            admin.idrole = resultSet.getInt('idrole')
                            admin.surnom = resultSet.getString("surnom")
                            admin.login = resultSet.getString("login")
                            admin.motdepasse = resultSet.getString("motdepasse")
                            ladmin.add(admin)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ladmin
    }

    def adminFindByID(int id){

        List<Admin> ladmin = new ArrayList<>()
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
                            ladmin.add(admin)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ladmin
    }

    def adminUpdate(Admin admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update admin set idrole = ? , surnom = ?, login = ?, motdepasse = ? where idadmin = ?", [admin.getIdrole(),admin.getSurnom(),admin.getLogin(),admin.getMotdepasse(),admin.getIdadmin()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def adminDelete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM admin where idadmin = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()

    }


    def adminInsert(Admin admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into admin values (?,?,?,?,?) ",[admin.getIdadmin(),admin.getIdrole(),admin.getSurnom(),admin.getLogin(),admin.getMotdepasse()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


}
