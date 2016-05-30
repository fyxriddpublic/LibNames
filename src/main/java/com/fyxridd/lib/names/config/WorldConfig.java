package com.fyxridd.lib.names.config;

import com.fyxridd.lib.core.api.config.basic.Config;
import com.fyxridd.lib.core.api.config.basic.ListType;
import com.fyxridd.lib.core.api.config.basic.Path;
import com.fyxridd.lib.core.api.config.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/world.yml")
public class WorldConfig {
    private static class WorldConverter implements ListConvert.ListConverter<Map<String, String>> {
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
    @ListConvert(value = WorldConverter.class, listType = ListType.String)
    private Map<String, String> worlds;

    public Map<String, String> getWorlds() {
        return worlds;
    }
}
