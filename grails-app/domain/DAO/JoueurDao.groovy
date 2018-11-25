package DAO

import Connecting.Connecting
import mapping.Joueur

class JoueurDao {



    def joueurFindAll(){

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
                            ljoueur.add(joueur)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ljoueur
    }

    def joueurFindByStatus(int joueurConnecte, boolean  status) {
        List<Joueur> ljoueur = new ArrayList<>()
        Joueur joueur = new Joueur()
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM joueur where idjoueur != "+joueurConnecte+ "and status = "+status)
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            ljoueur.add(joueur)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ljoueur
    }

    def joueurByID(int id){
        List<Joueur> ljoueur = new ArrayList<>()
        Joueur joueur = new Joueur()
        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM joueur where idadmin = "+id)
                    { resultSet ->
                        while (resultSet.next()) {
                            joueur.setIdjoueur(resultSet.getInt("idjoueur"))
                            joueur.setLogin(resultSet.getString("login"))
                            joueur.setMotdepasse(resultSet.getString("motdepasse"))
                            joueur.setStatus(resultSet.getBoolean('status'))
                            joueur.setAprouve(resultSet.getInt("aprouve"))
                            ljoueur.add(joueur)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return ljoueur
    }

    def joueurUpdate(Joueur joueur){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("update joueur set login = ?, motdepasse = ?, status = ?,aprouvee = ? where idjoueur = ?",
                    [joueur.getLogin(),joueur.getMotdepasse(),joueur.isStatus(),joueur.getAprouve(),joueur.getIdjoueur()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def joueurDelete(int id){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("delete FROM joueur where idjoueur = "+id)
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }


    def joueurInsert(Joueur joueur){

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.executeUpdate("insert into joueur values(?,?,?,?,?)",
                    [joueur.getIdjoueur(),joueur.getLogin(),joueur.getMotdepasse(),joueur.isStatus(),joueur.getAprouve()])
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
    }

    def joueurFindByStatus(int joueurConnecte, boolean  status)
    {

    }

    def joueurFindByLoginAndPassword(String login, String password) {

    }
}
