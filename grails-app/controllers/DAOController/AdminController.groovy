package DAOController

import DAO.AdminDao
import grails.converters.JSON
import mapping.Admin

class AdminController {

    def index() { }

    def getAdmin (){
        int id = 1
        AdminDao adm = new AdminDao()
        Admin a  = new Admin(40,1,"karante","loginina","maodiaasy")
        adm.adminInsert(a)
        render a as JSON
    }


}
