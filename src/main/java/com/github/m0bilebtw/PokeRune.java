package com.github.sophronize;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(PokeRuneConfig.GROUP)
public interface PokeRuneConfig extends Config
{
    String GROUP = "pokerune";

    enum PokemonGeneration
    {
        GEN_1("Red/Blue/Yellow"),
        GEN_2("Gold/Silver/Crystal"),
        GEN_3("Ruby/Sapphire/Emerald"),
        GEN_4("Diamond/Pearl/Platinum"),
        GEN_5("Black/White/Black 2/White 2"),
        GEN_6("X/Y/ORAS"),
        GEN_7("Sun/Moon/Ultra Sun/Ultra Moon"),
        GEN_8("Sword/Shield"),
        GEN_9("Scarlet/Violet");

        private final String label;

        PokemonGeneration(String label)
        {
            this.label = label;
        }

        @Override
        public String toString()
        {
            return label;
        }
    }

    @ConfigItem(
        keyName = "pokemonGeneration",
        name = "Pokémon Generation",
        description = "Select which generation's sounds to use",
        position = 0
    )
    default PokemonGeneration pokemonGeneration()
    {
        return PokemonGeneration.GEN_1;
    }

    @ConfigSection(
        name = "Announce Achievements",
        description = "Which sounds that are achievements should play.",
        position = 10
    )
    String SECTION_ACHIEVEMENT_ANNOUNCEMENTS = "Announce Achievements";

    @ConfigItem(
        keyName = "announceLevelUp",
        name = "Level ups",
        description = "Should PokeRune announce when you gain a level in a skill?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 11
    )
    default boolean announceLevelUp()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceLevelUpIncludesVirtual",
        name = "Include virtual level ups",
        description = "Should PokeRune announce when you gain a virtual (>99) level in a skill?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 12
    )
    default boolean announceLevelUpIncludesVirtual()
    {
        return false;
    }

    @ConfigItem(
        keyName = "announceQuestCompletion",
        name = "Quest completions",
        description = "Should PokeRune announce when you complete a quest?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 13
    )
    default boolean announceQuestCompletion()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceCollectionLog",
        name = "New collection log entry",
        description = "Should PokeRune announce when you fill in a new slot in your collection log? This relies on having chat messages enabled in-game settings!",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 14
    )
    default boolean announceCollectionLog()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceAchievementDiary",
        name = "Completed achievement diaries",
        description = "Should PokeRune announce when you complete a new achievement diary?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 15
    )
    default boolean announceAchievementDiary()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceCombatAchievement",
        name = "Completed combat achievement tasks",
        description = "Should PokeRune announce when you complete a new combat achievement task?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 16
    )
    default boolean announceCombatAchievement()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceSlayerTasks",
        name = "Completed Slayer Tasks",
        description = "Should PokeRune announce when you complete a slayer task?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 17
    )
    default boolean announceSlayerTasks()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceFarmingContracts",
        name = "Completed Farming Contracts",
        description = "Should PokeRune announce when you complete a farming contract?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 18
    )
    default boolean announceFarmingContracts()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceHunterRumours",
        name = "Completed Hunter Rumours",
        description = "Should PokeRune announce when you receive the required creature part for a hunter rumour?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 19
    )
    default boolean announceHunterRumours()
    {
        return true;
    }

    @ConfigItem(
        keyName = "announceLeaguesTasks",
        name = "Completed Leagues Tasks",
        description = "Should PokeRune announce when you complete a leagues task?",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 20
    )
    default boolean announceLeaguesTasks()
    {
        return true;
    }

    @ConfigItem(
        keyName = "needToRemindAboutDisablingLeaguesTasks",
        name = "Need to remind user they can disable leagues tasks announcements if they want",
        description = "Leagues tasks can get spammy, and some users might not know they can toggle individual announcements instead of the whole plugin",
        section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
        hidden = true
    )
    default boolean needToRemindAboutDisablingLeaguesTasks()
    {
        return true;
    }

    @ConfigSection(
        name = "Announce Other",
        description = "Which sounds that are not necessarily achievements (and not easter eggs) should play.",
        position = 30
    )
    String SECTION_NON_ACHIEVEMENT_ANNOUNCEMENTS = "Announce Other";

    @ConfigItem(
        keyName = "announceDeath",
        name = "When you die",
        description = "Should PokeRune play a sound when you die?",
        section = SECTION_NON_ACHIEVEMENT_ANNOUNCEMENTS,
        position = 31
    )
    default boolean announceDeath()
    {
        return true;
    }

    @ConfigSection(
        name = "General Announcement Settings",
        description = "Settings for other details when achievement sounds play.",
        position = 40
    )
    String SECTION_GENERAL_ANNOUNCEMENT_SETTINGS = "General Announcement Settings";

    @Range(
        min = 0,
        max = 200
    )
    @ConfigItem(
        keyName = "announcementVolume",
        name = "Announcement volume",
        description = "Adjust how loud the audio announcements are played!",
        section = SECTION_GENERAL_ANNOUNCEMENT_SETTINGS,
        position = 41
    )
    default int announcementVolume()
    {
        return 100;
    }
}
