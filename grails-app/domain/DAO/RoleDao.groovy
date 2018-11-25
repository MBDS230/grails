package DAO

import Connecting.Connecting
import mapping.Role

class RoleDao {

    def findAll(){

        List<Role> lrole = new ArrayList<>()
        Role role = new Role()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query('SELECT * FROM role where 1 > 0')
                    { resultSet ->
                        while (resultSet.next()) {
                            role.getIdrole(resultSet.getInt("idrole"))
                            role.surnom = resultSet.getString("nom")
                            role.idrole = resultSet.getInt('degre')
                            lrole.add(role)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lrole
    }


    def findByID(int id){
        Role admin = new Role()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM role where idrole = "+id)

                { resultSet ->
                    while (resultSet.next()) {
                        role.getIdrole(resultSet.getInt("idrole"))
                        role.surnom = resultSet.getString("nom")
                        role.idrole = resultSet.getInt('degre')
                        lrole.add(role)
                    }
                }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return admin
    }

    def update(Role role){

        def sql = Connecting.getConnection()
        if(sql != null){
            sql.executeUpdate("update message set nom = ?, degre = ? where idrole = ?",[role.getNom(),role.getDegre(),role.getIdrole()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM role where idrole = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def insert(Role role){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into message values (?,?,?)",
                    [role.getIdrole(),role.getNom(),role.getDegre()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }
}
