package Moderation.checks;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static Moderation.Moderation.flag;
import static Moderation.Moderation.flagtype;

public class SpamC extends ListenerAdapter {

    //this checks to see if the previous message was the same as the last one

        private String preMessage= "";


    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        System.out.println(e.getMessage().getContentRaw());
        System.out.println(this.preMessage);
            if (this.preMessage.equalsIgnoreCase(e.getMessage().getContentRaw())){
                flag(flagtype, e.getAuthor(), e.getGuild(), e.getChannel(), "Spam C", e.getMessage());
                e.getMessage().delete().queue();
            }
            preMessage = e.getMessage().getContentRaw();
    }
}
