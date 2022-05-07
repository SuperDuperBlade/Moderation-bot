import Events.Message;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.RichPresence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.security.auth.login.LoginException;

public class Main {


    public static void main(String []args) throws LoginException {

        JDA jda = JDABuilder.createDefault("").build();
        jda.addEventListener(new Message());
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setPrefix("<");
        builder.setOwnerId("731182000165093428");
        builder.setActivity(Activity.playing("Currently studying"));
        CommandClient client = builder.build();




    }



}
