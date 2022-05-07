import Commands.Ping;
import Events.Message;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {


    public static void main(String []args) throws LoginException {
        JDA jda = JDABuilder.createDefault("").build();


        jda.addEventListener(new Message());
        jda.addEventListener(new Ping());




    }



}
