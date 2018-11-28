package DAO

import Connecting.Connecting
import mapping.Joueur

class JoueurDao {



    def findAll(){

        List<Joueur> ljoueur = new ArrayList<>()
        Joueur joueur = new Joueur()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query('SELECT * FROM joueur where 1 > 0')
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            joueur.setPhoto(resultSet.getString("photo"))
                            ljoueur.add(joueur)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ljoueur
    }

    def findByUsername(String username){
        List<Joueur> ljoueur = new ArrayList<>()
        Joueur joueur = new Joueur()
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM joueur where login = '"+username+"'")
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            joueur.setPhoto(resultSet.getString("photo"))
                            ljoueur.add(joueur)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ljoueur
    }


    def findByLoginAndPassword(String username, String motDePasseHash){
        Joueur joueur = null
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM joueur where login = '"+username+ "' and motdepasse = '"+motDePasseHash+"'")
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur = new Joueur()
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            joueur.setPhoto(resultSet.getString("photo"))
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return joueur
    }
    def findByStatus(int joueurConnecte, boolean  status) {
        List<Joueur> ljoueur = new ArrayList<>()
        Joueur joueur = new Joueur()
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM joueur where idjoueur != "+joueurConnecte+ " and status = "+status)
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur = new Joueur()
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            joueur.setPhoto(resultSet.getString("photo"))
                            ljoueur.add(joueur);
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ljoueur
    }

    def findByID(int id){
        Joueur joueur = null
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM joueur where idjoueur = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur = new Joueur()
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            joueur.setPhoto(resultSet.getString("photo"))
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return joueur
    }

    def update(Joueur joueur){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update joueur set login = ?, motdepasse = ?, status = ?, aprouve = ?, photo = ? where idjoueur = ?",
                    [joueur.getLogin(),joueur.getMotdepasse(),joueur.isStatus(),joueur.getAprouve(),joueur.getPhoto(), joueur.getIdjoueur()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def delete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM joueur where idjoueur = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def insert(Joueur joueur){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into joueur values(?,?,?,?,?,?)", [joueur.getIdjoueur(),joueur.getLogin(),joueur.getMotdepasse(),joueur.isStatus(),joueur.getAprouve(),joueur.getPhoto()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


}
