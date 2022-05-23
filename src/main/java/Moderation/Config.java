package Moderation;
import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import static Moderation.Moderation.setFlagtype;
import static Moderation.checks.SpamA.messagelenththreshold;

public class Config extends ListenerAdapter {
    //todo make each algorithm toggleable


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
   //     if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {//return;
     //   }
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase("!config")&&args[1].equalsIgnoreCase("amount")){
            try {
                int a = Integer.parseInt(args[2]);
                messagelenththreshold = a;
                event.getChannel().sendMessage("threshold was set to "+a).queue();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if (args[0].equalsIgnoreCase("!config") && args[1].equals("Flagtype")) {
            if (args[3].equalsIgnoreCase("silent")) {
                setFlagtype(Flagtype.Silent);
            }

        } else if (args[3].equalsIgnoreCase("None")) {
            setFlagtype(Flagtype.none);

        }


    }
}
