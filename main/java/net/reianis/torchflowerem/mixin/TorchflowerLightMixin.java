package net.reianis.torchflowerem.mixin;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public class TorchflowerLightMixin {

    @Inject(method = "getLightEmission", at = @At("HEAD"), cancellable = true)
    private void injectTorchflowerLight(
            CallbackInfoReturnable<Integer> cir) {

        BlockState state = (BlockState) (Object) this;

        // Fully grown torchflower + potted torchflower
        if (state.is(Blocks.TORCHFLOWER) ||
                state.is(Blocks.POTTED_TORCHFLOWER)) {

            cir.setReturnValue(15);
        }

        // Growing torchflower
        if (state.is(Blocks.TORCHFLOWER_CROP)) {
            cir.setReturnValue(7);
        }
    }
}