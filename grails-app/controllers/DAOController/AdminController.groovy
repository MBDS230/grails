package DAOController

import DAO.AdminDao
import grails.converters.JSON
import mapping.Admin

class AdminController {

    def index() { }

    def getAdmin (){
        AdminDao adm = new AdminDao()
        Admin a  = adm.getTayporyUser()

        render a as JSON
    }


}
