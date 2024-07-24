package com.github.Sophronize;
import com.github.Sophronize.sound.SoundEngine;
import com.github.Sophronize.checks.LoggedInState;
import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import okhttp3.OkHttpClient;

import javax.inject.Inject;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@PluginDescriptor(
        name = "PokeRune",
        description = "PokeRune announces when you complete an achievement",
        tags = {"PokeRune", "stats", "levels", "quests", "diary", "announce"}
)

public class PokeRunePlugin extends Plugin {
    @Inject
    private Client client;

    @Getter(AccessLevel.PACKAGE)
    @Inject
    private ClientThread clientThread;

    @Inject
    private PokeRuneConfig config;

    @Inject
    private ScheduledExecutorService executor;

    @Inject
    private OkHttpClient okHttpClient;

    @Inject
    private EventBus eventBus;

    @Inject
    private SoundEngine soundEngine;

    @Inject
    private Triggers announcementTriggers;
    
    @Inject
    private LoggedInState loggedInState;

    @Override
    protected void startUp() throws Exception {
        eventBus.register(announcementTriggers);
        eventBus.register(loggedInState);
        loggedInState.setForCurrentGameState(client.getGameState());
        announcementTriggers.initialise();
    }

    @Override
    protected void shutDown() throws Exception {
        eventBus.unregister(announcementTriggers);
        eventBus.unregister(loggedInState);

        announcementTriggers.shutDown();
        soundEngine.close();
    }

    @Provides
    PokeRuneConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(PokeRuneConfig.class);
    }
}
