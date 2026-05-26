package mei.arisuwu.deermod.entity.deer;

import mei.arisuwu.deermod.Mod;
import mei.arisuwu.deermod.ModResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class DeerSounds {
    // [Cecil] Custom deer sounds
    public static final SoundEvent DEER_AMBIENT = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.ambient"));
    public static final SoundEvent DEER_DEATH   = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.death"));
    public static final SoundEvent DEER_HURT    = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.hurt"));
    public static final SoundEvent DEER_BOOST   = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.boost"));

    public static final SoundEvent BABY_DEER_AMBIENT = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.baby_ambient"));
    public static final SoundEvent BABY_DEER_DEATH   = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.baby_death"));
    public static final SoundEvent BABY_DEER_HURT    = SoundEvent.createVariableRangeEvent(ModResourceLocation.of("entity.deer.baby_hurt"));
}
