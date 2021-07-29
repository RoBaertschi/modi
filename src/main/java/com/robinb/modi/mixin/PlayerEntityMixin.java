package com.robinb.modi.mixin;

import com.robinb.modi.PlayerEntityExt;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerEntityExt {

    private int killCount;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    public void addKills(int amount) {
        killCount += amount;
        System.out.println(killCount);
    }

    @Inject(method = "writeCustomDataToTag", at = @At("RETURN"))
    private void writeData(CompoundTag tag, CallbackInfo info){
        tag.putInt("killCount", killCount);
    }
     @Inject(method = "readCustomDataFromTag", at = @At("RETURN"))
    private void readData(CompoundTag tag, CallbackInfo info){
        killCount = tag.getInt("killCount");
     }
}
