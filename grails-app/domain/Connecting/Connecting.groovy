package Connecting

import groovy.sql.Sql

class Connecting {

    public static Sql getConnection(){
        return Sql.newInstance("jdbc:postgresql://localhost:5432/test","postgres", "mbds230", "org.postgresql.Driver");
    }

    public static int getMaxId(String table){

        return 0;
    }


}
