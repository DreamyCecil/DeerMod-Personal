package mei.arisuwu.deermod.entity.deer;

import mei.arisuwu.deermod.ModResourceLocation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

// [Cecil] Colored nose layer
public class DeerEntityLayer extends RenderLayer<DeerEntity, DeerEntityModel<DeerEntity>> {
    private static final ResourceLocation TEXTURE_NOSE = ModResourceLocation.of("textures/entity/deer/deer_nose.png");
    private final DeerEntityModel<DeerEntity> modelOverlay;

    public DeerEntityLayer(RenderLayerParent<DeerEntity, DeerEntityModel<DeerEntity>> parent) {
        super(parent);
        modelOverlay = new DeerEntityModel<>(parent.getModel().root()); // Copy base model
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, DeerEntity entity,
        float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
    {
        if (entity.isInvisible()) return;

        // Copy model properties and animation from the base model
        getParentModel().copyPropertiesTo(modelOverlay);
        modelOverlay.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        // Render the overlay model
        VertexConsumer buf = bufferSource.getBuffer(RenderType.entityCutoutNoCull(TEXTURE_NOSE));
        int col = entity.getNoseColor().getTextureDiffuseColor() | 0xFF000000;

        modelOverlay.renderToBuffer(poseStack, buf, packedLight, OverlayTexture.NO_OVERLAY, col);
    }
}
