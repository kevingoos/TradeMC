package be.ghost606.trademc.handler;

import be.ghost606.trademc.client.gui.GuiTradeProposal;
import be.ghost606.trademc.inventory.ContainerTradeProposal;
import be.ghost606.trademc.inventory.InventoryTrade;
import be.ghost606.trademc.reference.GuiId;
import be.ghost606.trademc.utility.LogHelper;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Kevin on 15/07/2014.
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GuiId.TRADE.ordinal()) {
            LogHelper.info("Gui server side!");
            return new ContainerTradeProposal(player, new InventoryTrade());
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GuiId.TRADE.ordinal()) {
            LogHelper.info("Gui client side!");
            return new GuiTradeProposal(player, new InventoryTrade());
        }

        return null;
    }
}
