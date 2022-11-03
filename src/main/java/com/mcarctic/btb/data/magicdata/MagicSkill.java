package com.mcarctic.btb.data.magicdata;

import com.google.common.reflect.TypeToken;
import com.mcarctic.btb.data.magicdata.model.IMagicLevel;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IRegistryDelegate;
import net.minecraftforge.registries.RegistryDelegate;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class MagicSkill extends AbstractWidget implements IForgeRegistryEntry<MagicSkill> {

    private final TypeToken<MagicSkill> token = new TypeToken<>(getClass()) {
    };
    public final IRegistryDelegate<MagicSkill> delegate = new RegistryDelegate<>(this, (Class<MagicSkill>) token.getRawType());
    private final IMagicLevel level;
    private ResourceLocation registryName = null;

    public MagicSkill(IMagicLevel level, int x, int y, int width, int height) {
        super(x, y, width, height, NarratorChatListener.NO_TITLE);
        this.level = level;
    }

    public MagicSkill(IMagicLevel level, int x, int y) {
        this(level, x, y, 10, 10);
    }

    public final void unlock(ServerPlayer player) {

    }

    public TranslatableComponent getTitle() {
        return getTitle(getRegistryName(), level);
    }

    public TranslatableComponent getDescription() {
        return getDescription(getRegistryName(), level);
    }

    public ResourceLocation getIcon() {
        return getIcon(getRegistryName(), level);
    }

    public IMagicLevel getLevel() {
        return level;
    }

    public final MagicSkill setRegistryName(String modID, String name) {
        return setRegistryName(modID + ":" + name);
    }

    @Nullable
    public final ResourceLocation getRegistryName() {
        if (delegate.name() != null) return delegate.name();
        return registryName != null ? registryName : null;
    }

    public final MagicSkill setRegistryName(String name) {
        if (getRegistryName() != null)
            throw new IllegalStateException("Attempted to set registry name with existing registry name! New: " + name + " Old: " + getRegistryName());

        this.registryName = checkRegistryName(name);
        return this;
    }

    //Helper functions
    public final MagicSkill setRegistryName(ResourceLocation name) {
        return setRegistryName(name.toString());
    }

    public final Class<MagicSkill> getRegistryType() {
        return (Class<MagicSkill>) token.getRawType();
    }

    /**
     * This will assert that the registry name is valid and warn about potential registry overrides
     * It is important as it detects cases where modders unintentionally register objects with the "minecraft" namespace, leading to dangerous errors later.
     *
     * @param name The registry name
     * @return A verified "correct" registry name
     */
    ResourceLocation checkRegistryName(String name) {
        return GameData.checkPrefix(name, true);
    }

    @Override
    public void updateNarration(@NotNull NarrationElementOutput pNarrationElementOutput) {
    }

    public static ResourceLocation getIcon(ResourceLocation location, IMagicLevel level) {
        return new ResourceLocation(location.getNamespace(), "textures/btbskills/" + level.getType().identifier() + "/" + location.getPath() + ".png");
    }

    public static TranslatableComponent getDescription(ResourceLocation location, IMagicLevel level) {
        return new TranslatableComponent("btbskills." + level.getType().identifier() + "." + location.getNamespace() + "." + location.getPath() + ".description");
    }

    public static TranslatableComponent getTitle(ResourceLocation location, IMagicLevel level) {
        return new TranslatableComponent("btbskills." + level.getType().identifier() + "." + location.getNamespace() + "." + location.getPath() + ".title");
    }
}
