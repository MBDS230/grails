package vsjoueur;

import java.sql.Timestamp;

public class MessageCron implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            final int HOUR_CRON = 13;
            final int MINUTE_CRON = 33;
            final int SECOND_CRON = 0;
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
