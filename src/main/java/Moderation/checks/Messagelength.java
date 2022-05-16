package Moderation.checks;

import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static Moderation.Moderation.flag;
import static Moderation.Moderation.flagtype;

public class Messagelength extends ListenerAdapter{

        private int messagelenththreshold = 20;


    public void setMessagelenththreshold(int messagelenththreshold) {
        this.messagelenththreshold = messagelenththreshold;
    }

    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot())
            return;


        String[] args = e.getMessage().getContentRaw().split(" ");
        if (flagtype == Flagtype.none){
            return;
        }
        System.out.println("here");
        String c = "p";

        for (int i=0;i<=args.length;i++){
            c= args[i];
            System.out.println(c);
            if (c.length()>=3||args.length>37){
               // e.getChannel().sendMessage(e.getAuthor().getAsMention()+" failed spam")
                flag(flagtype,e.getAuthor(),e.getGuild(),e.getChannel());
            }

        }
    }


}

