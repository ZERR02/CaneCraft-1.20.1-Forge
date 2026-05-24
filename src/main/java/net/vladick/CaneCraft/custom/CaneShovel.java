package net.vladick.CaneCraft.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CaneShovel extends ShovelItem {
    public CaneShovel(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed,  properties);
    }


    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity miner){
        if(!level.isClientSide){

            if(state.is(BlockTags.MINEABLE_WITH_SHOVEL)){
                miner.addEffect((new MobEffectInstance(MobEffects.DIG_SPEED, 30, 2)));
            }
        }
        return super.mineBlock(itemStack, level, state, pos, miner);
    }
}
