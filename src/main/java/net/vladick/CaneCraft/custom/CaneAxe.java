package net.vladick.CaneCraft.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CaneAxe extends AxeItem {
    public CaneAxe(Tier tier, float AttackDamage, float AttackSpeed, Properties properties) {
        super(tier, AttackDamage, AttackSpeed, properties);

    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {


        if(!level.isClientSide){

            if(state.is(BlockTags.MINEABLE_WITH_AXE)){
                miner.addEffect((new MobEffectInstance(MobEffects.DIG_SPEED, 30, 2)));
            }

        }
        return super.mineBlock(stack, level, state, pos, miner);
    }
}
