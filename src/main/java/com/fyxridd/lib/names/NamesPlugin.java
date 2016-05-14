package com.fyxridd.lib.names;

import com.fyxridd.lib.core.api.plugin.SimplePlugin;
import com.fyxridd.lib.names.manager.NamesManager;

public class NamesPlugin extends SimplePlugin{
    public static NamesPlugin instance;

    private NamesManager namesManager;

    @Override
    public void onEnable() {
        instance = this;

        namesManager = new NamesManager();

        super.onEnable();
    }

    public NamesManager getNamesManager() {
        return namesManager;
    }
}