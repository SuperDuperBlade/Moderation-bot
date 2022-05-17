package Moderation.checks;

import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static Moderation.Moderation.flag;
import static Moderation.Moderation.flagtype;

public class Messagelength extends ListenerAdapter{

        public static int messagelenththreshold = 20;


    public void setMessagelenththreshold(int messaththreold) {
        messagelenththreshold = messaththreold;
    }

    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot())
            return;
        if (e.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            return;
        }


        String[] args = e.getMessage().getContentRaw().split(" ");
        if (flagtype == Flagtype.none){
            return;
        }
        System.out.println("here");
        String c = "p";

        for (int i=0;i<=args.length;i++){
            c= args[i];
            System.out.println(this.messagelenththreshold);
            if (c.length()>=messagelenththreshold||args.length>40){
               // e.getChannel().sendMessage(e.getAuthor().getAsMention()+" failed spam")
                flag(flagtype,e.getAuthor(),e.getGuild(),e.getChannel());
            }

        }
    }


}

