package Moderation;

import Moderation.checks.Messagelength;
import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static Moderation.Moderation.setFlagtype;

public class Config extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            return;
        }
        String[] args = event.getMessage().getContentRaw().split(" ");


        if (args[0].equalsIgnoreCase("!config") && args[1].equals("Flagtype")) {
            if (args[3].equalsIgnoreCase("silent")) {
                setFlagtype(Flagtype.Silent);
            }
        } else if (args[3].equalsIgnoreCase("Action")) {
            setFlagtype(Flagtype.Action);
        } else if (args[3].equalsIgnoreCase("None")) {
            setFlagtype(Flagtype.none);

        }

if (args[0].equalsIgnoreCase("!config")&&args[1].equalsIgnoreCase("threshold")){
try {
    int a = Integer.parseInt(args[3]);
    Messagelength messagelength  = new Messagelength();
    messagelength.setMessagelenththreshold(a);
    event.getChannel().sendMessage("threshold was set to "+a).queue();
}catch (Exception e){
    e.printStackTrace();
}
}
    }
}
