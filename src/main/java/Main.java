import Events.Message;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {


    public static void main(String []args) throws LoginException {

        JDA jda = JDABuilder.createDefault("OTcxNDM0NjYzNTQzNDM5NDYw.GulEze.OtdxPcfIFO6IDgYadQ4ja2EGaJGlFqF9PqjPVg").build();
        jda.addEventListener(new Message());



    }



}
