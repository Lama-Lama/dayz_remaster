package com.github.dayzminecraft.dayzminecraft.common.misc;

import com.github.dayzminecraft.dayzminecraft.common.effects.Effect;
import com.github.dayzminecraft.dayzminecraft.common.world.biomes.Biomes;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static boolean debug;
    public static int structureGenerationChance;
    public static boolean canSpawnZombiesInDefaultWorld;
    public static boolean showWorldTypeWarning;

    public static void init(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "DayZ Config.txt"));

        config.load();

        Biomes.biomeConfig(config);
        Effect.effectConfig(config);

        debug = config.get(Configuration.CATEGORY_GENERAL, "debug", false, "Should DayZ log extra information?").getBoolean(false);
        showWorldTypeWarning = config.get(Configuration.CATEGORY_GENERAL, "show-world-type-warning", true, "Should DayZ warn if the worldtype is not DayZ?").getBoolean(true);
        structureGenerationChance = config.get(Configuration.CATEGORY_GENERAL, "structure-generation-chance", 5, "1 in x chance to generate a structure in a given chunk").getInt(5);
        canSpawnZombiesInDefaultWorld = config.get(Configuration.CATEGORY_GENERAL, "spawn zombies-in-default-world", false, "Should DayZ zombies generate in the surface world?").getBoolean(false);

        config.save();
    }
}