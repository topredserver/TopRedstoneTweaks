package fr.topred.topredstonetweaks.sscauldron;


import fr.topred.topredstonetweaks.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CauldronPlace implements Listener {

    @EventHandler(priority= EventPriority.LOW)

    public void onBlockPlaceEvent(BlockPlaceEvent event)
    {
        Block block = event.getBlockPlaced();
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
        cauldronData.setLevel(cauldronData.getMaximumLevel());
        block.setBlockData(cauldronData);
    }
}
