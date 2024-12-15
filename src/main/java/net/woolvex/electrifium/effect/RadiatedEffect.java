package net.woolvex.electrifium.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class RadiatedEffect extends StatusEffect {
    public RadiatedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }



    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity.isTouchingWater()) {
            entity.removeStatusEffect(ModEffects.RADIATED);
        }

        if (!entity.hasStatusEffect(ModEffects.RADIATED)) {
            entity.setGlowing(true);
        } else entity.setGlowing(false);
        

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;

    }
}
