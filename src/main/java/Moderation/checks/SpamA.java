package Moderation.checks;

import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import static Moderation.Moderation.flag;
import static Moderation.Moderation.flagtype;

public class SpamA extends ListenerAdapter {



    //this checks the message length of the word if it is over the messagethreshhold amount

    public static int messagelenththreshold = 20;
    private int counter;


    public void setMessagelenththreshold(int messaththreold) {
        messagelenththreshold = messaththreold;
    }

    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot())
            return;
        //    if (e.getMember().hasPermission(Permission.ADMINISTRATOR)) {
        //       return;
        //     }


        String[] args = e.getMessage().getContentRaw().split(" ");
        if (flagtype == Flagtype.none) {
            return;
        }

        String c;
        this.counter = 0;
        for (int i = 0; i <= args.length; i++) {
                c = args[i];



                    if (c.length() >= messagelenththreshold || args.length > 200) {
                        if (e.getMessage().isWebhookMessage()) {
                            return;
                        }
                        // prevents false flags with mentions
                        if (c.length()<40&&!e.getMessage().mentionsEveryone()||e.getMessage().getMentionedMembers().size()<6)
                            return;
                        // prevents false flags with links
                        if (c.contains("www.") || c.contains("https") && c.length() < 80) {
                            this.counter++;

                        }else {
                            e.getMessage().delete().queue();
                            flag(flagtype, e.getAuthor(), e.getGuild(), e.getChannel(), "Spam A", e.getMessage());
                            return;
                        }


                    }
                    if (this.counter > 4) {
                        flag(flagtype, e.getAuthor(), e.getGuild(), e.getChannel(), "Spam A", e.getMessage());
                        return;
                    }

                }
            }


        }

