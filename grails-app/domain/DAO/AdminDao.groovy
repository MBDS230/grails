package DAO

import Connecting.Connecting
import mapping.Admin

class AdminDao {

    def findAll(){

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

    def findByLoginAndPassword(String login, String motdepasse) {
        Admin admin = null

        def sql = Connecting.getConnection()
        if(sql != null){
            sql.query("SELECT * FROM admin where login = "+id+" and motdepasse = "+motdepasse)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin = new Admin()
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

    def findByID(int id){

        Admin admin = null

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM admin where idadmin = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            admin = new Admin()
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

    def update(Admin admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update admin set idrole = ? , surnom = ?, login = ?, motdepasse = ? where idadmin = ?", [admin.getIdrole(),admin.getSurnom(),admin.getLogin(),admin.getMotdepasse(),admin.getIdadmin()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM admin where idadmin = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()

    }


    def insert(Admin admin){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into admin values (?,?,?,?,?) ",[admin.getIdadmin(),admin.getIdrole(),admin.getSurnom(),admin.getLogin(),admin.getMotdepasse()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

}
