package net.AllozaBD.alloza_mod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

//Will be replaced with a different item later on.

public class PlantGrowerItem extends Item {
    public PlantGrowerItem(Properties pProperties){
        super (pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            BlockState state = pContext.getLevel().getBlockState(positionClicked);
            if (ValuedBlock(state)) {
                //Change Dirt to grass and damage item.
                foundBlock = true;
                pContext.getLevel().setBlockAndUpdate(positionClicked, Blocks.GRASS_BLOCK.defaultBlockState());
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), existingplayer -> player.broadcastBreakEvent(player.getUsedItemHand()));
            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No dirt block detected."));
            }
        }
        return InteractionResult.SUCCESS;
    }

    //Checks if the block clicked is the right one
    private boolean ValuedBlock (BlockState state) {
        return state.is(Blocks.DIRT);
    }
}
