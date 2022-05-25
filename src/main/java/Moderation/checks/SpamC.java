package Moderation.checks;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static Moderation.Moderation.flag;
import static Moderation.Moderation.flagtype;

public class SpamC extends ListenerAdapter {
private Message messID;
    //this checks to see if the previous message was the same as the last one

        private String preMessage= "";


    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
if(e.getAuthor().isBot())
    return;


        this.preMessage = this.preMessage.replaceAll("\\d","");
            if (this.preMessage.equalsIgnoreCase(e.getMessage().getContentRaw().replaceAll("\\d",""))){
                this.messID.delete().queue();
                flag(flagtype, e.getAuthor(), e.getGuild(), e.getChannel(), "Spam C", e.getMessage());
                e.getMessage().delete().queue();
                return;
            }
            this.messID = e.getMessage();
            preMessage = e.getMessage().getContentRaw();
    }
}
