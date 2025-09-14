package com.github.theredbrain.minecrawl.config;

import com.github.theredbrain.minecrawl.Minecrawl;
import me.fzzyhmstrs.fzzy_config.annotations.ConvertFrom;
import me.fzzyhmstrs.fzzy_config.config.Config;

@ConvertFrom(fileName = "server.json5", folder = "minecrawl")
public class ServerConfig extends Config {

	public ServerConfig() {
		super(Minecrawl.identifier("server"));
	}

}
