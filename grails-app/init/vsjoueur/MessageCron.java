package vsjoueur;

import DAO.ParametrecronDao;
import mapping.Parametrecron;

import java.sql.Timestamp;
import java.util.List;

public class MessageCron implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            int HOUR_CRON = 13;
            int MINUTE_CRON = 33;
            int SECOND_CRON = 0;
            List<Parametrecron> lparametre  = new ParametrecronDao().findAllParam();
            if(lparametre!=null && lparametre.size()>0)
            {
                HOUR_CRON = lparametre.get(0).getHeure();
                MINUTE_CRON = lparametre.get(0).getMinute();
                SECOND_CRON = lparametre.get(0).getSeconde();
            }

            while (true)
            {
                Timestamp t = new Timestamp(System.currentTimeMillis());
                if(t.getHours() == HOUR_CRON && t.getMinutes() == MINUTE_CRON && t.getSeconds() == SECOND_CRON)
                {

                    Thread.sleep(2000);
                    new MessageService().cronMessage();
                    System.out.println("CRON");

                }
                else
                {
                    Thread.sleep(500);
                    System.out.println(t.getHours()+"-----"+t.getMinutes()+"----"+t.getSeconds());
                }

            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
