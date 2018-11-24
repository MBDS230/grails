package vsjoueur

import mapping.Admin

class AdminController {

    def approuve()
    {
        Admin adminSession = null; // Admin SESSION
        if(adminSession!=null)
        {
            int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
            new AdminService().approuve(idJoueur);
        }
        else
        {

        }
    }

    def rejete()
    {
        Admin adminSession = null; // Admin SESSION
        if(adminSession!=null)
        {
            int idJoueur = Integer.parseInt(params.getProperty("idJoueur"));
            new AdminService().rejete(idJoueur);
        }
        else
        {

        }
    }
}
