package DAO

import Connecting.Connecting
import mapping.Message

class MessageDao {

    def findAll(){

        List<Message> lmessage = new ArrayList<>()
        Message message = new Message()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query('SELECT * FROM message where 1 > 0')
                    { resultSet ->
                        while (resultSet.next()) {
                            message.getIdmessage(resultSet.getInt("idmessage"))
                            message.getIdenvoyeur(resultSet.getInt('idenvoyeur'))
                            message.getIdrecepteur(resultSet.getInt("idrecepteur"))
                            message.getCorps(resultSet.getString("corps"))
                            message.getAprouve(resultSet.getString("aprouve"))
                            message.isAffichage(resultSet.getBoolean("affichage"))
                            message.getDateenvoye(resultSet.getDate("dateenvoye"))
                            message.isStatus(resultSet.getBoolean("status"))
                            lmessage.add(message)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lmessage
    }

    def findByEnvoyeurAndRecepteur(int envoyeur, int recepteur){
        List<Message> valiny = new ArrayList<>();
        Message message = null

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM message WHERE ( idenvoyeur = "+envoyeur+" AND idrecepteur = "+recepteur+" ) OR ( idrecepteur = "+envoyeur+" AND idenvoyeur = "+recepteur+" ) AND affichage = TRUE ORDER by dateenvoye ASC")
                    { resultSet ->
                        while (resultSet.next()) {
                            message = new Message()
                            message.setIdmessage(resultSet.getInt("idmessage"))
                            message.setIdenvoyeur(resultSet.getInt('idenvoyeur'))
                            message.setIdrecepteur(resultSet.getInt("idrecepteur"))
                            message.setCorps(resultSet.getString("corps"))
                            message.setAprouve(resultSet.getInt("aprouve"))
                            message.setAffichage(resultSet.getBoolean("affichage"))
                            message.setDateenvoye(resultSet.getDate("dateenvoye"))
                            message.setStatus(resultSet.getBoolean("status"))
                            valiny.add(message)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return valiny;
    }

    def findByID(int id){
        Message message = null

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM message where idmessage = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            message = new Message()
                            message.setIdmessage(resultSet.getInt("idmessage"))
                            message.setIdenvoyeur(resultSet.getInt('idenvoyeur'))
                            message.setIdrecepteur(resultSet.getInt("idrecepteur"))
                            message.setCorps(resultSet.getString("corps"))
                            message.setAprouve(resultSet.getInt("aprouve"))
                            message.setAffichage(resultSet.getBoolean("affichage"))
                            message.setDateenvoye(resultSet.getDate("dateenvoye"))
                            message.setStatus(resultSet.getBoolean("status"))
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return message
    }

    def update(Message message){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update message set idenvoyeur = ?, idrecepteur = ?, corps = ?, aprouve = ?, affichage = ?, dateenvoye = ?, status = ? where idmessage = ?",
                    [message.getIdenvoyeur(),message.getIdrecepteur(),message.getCorps(),message.getAprouve(),message.isAffichage(),message.getDateenvoye(),message.isStatus(),message.getIdmessage()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM message where idmessage = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def insert(Message message){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into message values (?, ?, ?, ?, ?, ?, ?, ?)",
                    [ message.getIdmessage(),
                     message.getIdenvoyeur(),
                     message.getIdrecepteur(),
                     message.getCorps(),
                     message.getAprouve(),
                     message.isAffichage(),
                     message.getDateenvoye(),
                     message.isStatus()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()

    }

    ///CRON
    def cacheMessageByIdEnvoyeurAndRecepteur(int idEnvoyeur, int idRecepteur)
    {
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update message set  affichage = ?  WHERE ( idenvoyeur = "+idEnvoyeur+" AND idrecepteur = "+idRecepteur+" ) OR ( idrecepteur = "+idEnvoyeur+" AND idenvoyeur = "+idRecepteur+" ) ",
                    [false])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()

    }
}
