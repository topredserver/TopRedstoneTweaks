package fr.topred.topredstonetweaks.sscauldron;

import fr.topred.topredstonetweaks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class CauldronListener implements Listener {

    @EventHandler(priority= EventPriority.LOW)

    public void onPlayerInteract(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        EquipmentSlot eq = event.getHand();
        //Test si click avec la main

        if (!eq.equals(EquipmentSlot.HAND))
        {
            return;
        }

        //Test si block est un chaudron
        if(! block.getType().equals(Material.CAULDRON))
        {
            return;
        }
        PlayerInteractEvent e = new PlayerInteractEvent(event.getPlayer(), Action.LEFT_CLICK_BLOCK, null, block, BlockFace.UP) ;
        if(!Main.canBuild(e))
        {
            return;
        }

        Levelled cauldronData = (Levelled) block.getBlockData();
        cauldronData.setLevel((cauldronData.getLevel()+1)%4);
        block.setBlockData(cauldronData);
    }
}
