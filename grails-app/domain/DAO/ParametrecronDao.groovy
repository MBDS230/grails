package DAO

import Connecting.Connecting
import mapping.Parametrecron

class ParametrecronDao {


    public List<Parametrecron> findAllParam(){

        List<Parametrecron> lparametre = new ArrayList<>()

        def sql = Connecting.getConnection()

        if(sql != null){
            sql.query("SELECT * FROM parametrecron where 1 > 0")
                    { resultSet ->
                        while (resultSet.next()) {
                            Parametrecron parametrecron = new Parametrecron()
                            parametrecron.setIdparametrecron(resultSet.getInt("idparametrecron"))
                            parametrecron.setHeure(resultSet.getInt("heure"))
                            parametrecron.setMinute(resultSet.getInt("minute"))
                            parametrecron.setSeconde(resultSet.getInt('seconde'))
                            lparametre.add(parametrecron)
                        }
                    }
        }else{
            throw new Exception("Error when trying to connect to the database")
        }
        sql.close()
        return lparametre;
    }
}
