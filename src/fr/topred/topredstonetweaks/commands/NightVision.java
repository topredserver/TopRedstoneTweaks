package fr.topred.topredstonetweaks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVision implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(! (commandSender instanceof Player))
        {
            commandSender.sendMessage("You must be a player to execute this command");
               return false;
        }
        Player player = (Player)commandSender;
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.NIGHT_VISION,Integer.MAX_VALUE,1);
        player.addPotionEffect(potionEffect);
        return false;
    }
}
