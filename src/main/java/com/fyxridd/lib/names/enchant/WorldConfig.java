package com.fyxridd.lib.names.enchant;

import com.fyxridd.lib.config.api.basic.Config;
import com.fyxridd.lib.config.api.basic.ListType;
import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/world.yml")
public class WorldConfig {
    private class WorldConverter implements ListConvert.ListConverter<Map<String, String>> {
        @Override
        public Map<String, String> convert(String plugin, List list) {
            Map<String, String> worlds = new HashMap<>();
            for (Object o:list) {
                String s = (String) o;
                String[] ss = s.split(" ", 2);
                String name = ss[0];
                String show = ss[1];
                worlds.put(name, show);
            }
            return worlds;
        }
    }

    @Path("world")
    @ListConvert(WorldConverter.class)
    @ListType(ListType.Type.String)
    private Map<String, String> worlds;

    public Map<String, String> getWorlds() {
        return worlds;
    }
}