package Moderation;

import Moderation.flags.Flagtype;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Moderation {
    public static void setFlagtype(Flagtype flagtype) {
        Moderation.flagtype = flagtype;
    }

    public static Flagtype flagtype = Flagtype.normal;
    private int threshold;
    private boolean trustfactor;
    private boolean ignoreprotected;


    public Moderation(Flagtype flag, int threshold, boolean trustfactor) {
    }


    public static void flag(Flagtype f, User u, Guild guild, Channel c) {
        if (f == Flagtype.none) {
            return;
        }
        if (f == Flagtype.Action) {


        }
        if (f == Flagtype.normal) {
            guild.getTextChannelById(c.getId()).sendMessage(u.getAsMention()+" failed spam").queue();
        }
        if (f == Flagtype.Silent) {

        }
    }

    public void Ban(User user, Guild guild, int days) {
        guild.ban(user, days);

    }

    public void Kick(User user, Guild guild) {
        guild.kick(user);
    }

    public void mute(Guild guild, User user) {
        guild.mute(user, true);
    }

    public int getThreshold() {
        return threshold;
    }

    public boolean isTrustfactor() {
        return trustfactor;
    }

    public boolean isIgnoreprotected() {
        return ignoreprotected;
    }
}
