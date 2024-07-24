package com.github.Sophronize;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PokeRunePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(PokeRunePlugin.class);
		RuneLite.main(args);
	}
}