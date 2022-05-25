package Moderation;
import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.EmbedBuilder;
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
        if (args[0].equalsIgnoreCase("!info")) {
            EmbedBuilder em = new EmbedBuilder()
                    .setTitle("Info")
                    .addField("Spam A :", "checks the length of the word", true)
                    .addField("Spam B :", "checks if the words in the sentence are similar", true)
                    .addField("Spam C :", "checks if the last sentance is the same as the current one ", true)
                    .addField("Spam D : ", "trys to see if the user has sent a nitro scam link", true);
            event.getChannel().sendMessageEmbeds(em.build()).queue();

        }
        if (args[0].equalsIgnoreCase("!config") && args[1].equalsIgnoreCase("amount")) {
            try {
                int a = Integer.parseInt(args[2]);
                messagelenththreshold = a;
                event.getChannel().sendMessage("threshold was set to " + a).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}