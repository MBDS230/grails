package DAO

import Connecting.Connecting
import mapping.Message

class MessageDao {

    def messageFindByEnvoyeurAndRecepteur(int envoyeur, int recepteur)
    {

    }

    def messageAll(){

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

    def messageFindByEnvoyeurAndRecepteur(int envoyeur, int recepteur){
        List<Message> lmessage = new ArrayList<>()
        Message message = new Message()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM message where WHERE envoyeur ="+envoyeur+"AND recepteur = "+recepteur+"AND affichage = TRUE ORDER by dateenvoye ASC")
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

    def messageByID(int id){
        List<Message> lmessage = new ArrayList<>()
        Message message = new Message()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM message where idmessage = "+id)
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

    def messageUpdate(Message message){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update message set idenvoyeur = ?, idrecepteur = ?, corps = ?, aprouve = ?, affichage = ?, dateenvoye = ?, status = ? where idmessage = ?",
                    [message.getIdenvoyeur(),message.getIdrecepteur(),message.getCorps(),message.getAprouve(),message.isAffichage(),message.getDateenvoye(),message.isStatus(),message.getIdmessage()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def messageDelete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM message where idmessage = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def messageInsert(Message message){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into message values (?,?,?,?,?,?,?,?)",
                    [message.getIdenvoyeur(),message.getIdrecepteur(),message.getCorps(),message.getAprouve(),message.isAffichage(),message.getDateenvoye(),message.isStatus(),message.getIdmessage()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()

    }
}
