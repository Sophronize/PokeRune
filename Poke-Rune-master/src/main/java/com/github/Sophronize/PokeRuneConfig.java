package com.github.Sophronize;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(PokeRuneConfig.GROUP)
public interface PokeRuneConfig extends Config {
    String GROUP = "PokeRune";

    @ConfigSection(
            name = "Announce Achievements",
            description = "Which sounds that are achievements should play.",
            position = 0
    )
    String SECTION_ACHIEVEMENT_ANNOUNCEMENTS = "Announce Achievements";

    @ConfigItem(
            keyName = "announceLevelUp",
            name = "Level ups",
            description = "Should PokeRune announce when you gain a level in a skill?",
            section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 1
    )
    default boolean announceLevelUp() {
        return true;
    }

    @ConfigItem(
            keyName = "announceLevelUpIncludesVirtual",
            name = "Include virtual level ups",
            description = "Should PokeRune announce when you gain a virtual (>99) level in a skill?",
            section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 2
    )
    default boolean announceLevelUpIncludesVirtual() {
        return false;
    }

    @ConfigItem(
            keyName = "announceQuestCompletion",
            name = "Quest completions",
            description = "Should PokeRune announce when you complete a quest?",
            section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 3
    )
    default boolean announceQuestCompletion() {
        return true;
    }

    @ConfigItem(
            keyName = "announceCollectionLog",
            name = "New collection log entry",
            description = "Should PokeRune announce when you fill in a new slot in your collection log? This one relies on you having chat messages (included with the popup option) enabled in game settings!",
            section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 4
    )
    default boolean announceCollectionLog() {
        return true;
    }

    @ConfigItem(
            keyName = "announceAchievementDiary",
            name = "Completed achievement diaries",
            description = "Should PokeRune announce when you complete a new achievement diary?",
            section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 5
    )
    default boolean announceAchievementDiary() {
        return true;
    }

    @ConfigItem(
            keyName = "announceCombatAchievement",
            name = "Completed combat achievement tasks",
            description = "Should PokeRune announce when you complete a new combat achievement task?",
            section = SECTION_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 6
    )
    default boolean announceCombatAchievement() {
        return true;
    }

    @ConfigSection(
            name = "Announce Other",
            description = "Which sounds that are not necessarily achievements (and not easter eggs) should play.",
            position = 20
    )
    String SECTION_NON_ACHIEVEMENT_ANNOUNCEMENTS = "Announce Other";

    @ConfigItem(
            keyName = "announceDeath",
            name = "When you die",
            description = "Should PokeRune relive his PvP HCIM death when you die?",
            section = SECTION_NON_ACHIEVEMENT_ANNOUNCEMENTS,
            position = 21
    )
    default boolean announceDeath() {
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
            position = 42
    )
    default int announcementVolume() {
        return 100;
    }
}
