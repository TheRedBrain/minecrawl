package com.github.theredbrain.minecrawl.config;

import com.github.theredbrain.minecrawl.Minecrawl;
import me.fzzyhmstrs.fzzy_config.annotations.ConvertFrom;
import me.fzzyhmstrs.fzzy_config.config.Config;

@ConvertFrom(fileName = "client.json5", folder = "minecrawl")
public class ClientConfig extends Config {

	public ClientConfig() {
		super(Minecrawl.identifier("client"));
	}

}
