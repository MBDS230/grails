package Connecting

import groovy.sql.Sql
import mapping.Joueur

class Connecting {

    public static Sql getConnection(){
        return Sql.newInstance("jdbc:postgresql://localhost:5432/vsjoueur","postgres", "admin", "org.postgresql.Driver");
    }

    public static int getMaxId(String table){
        int val = 0;
        def sql = Connecting.getConnection()
        if(sql != null)
        {
            sql.query("SELECT MAX(id"+table+") FROM "+table)
            { resultSet ->
                while (resultSet.next()) {
                    val = resultSet.getInt(1);
                }
            }
        }
        else
        {
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close();
        return val;
    }


}
