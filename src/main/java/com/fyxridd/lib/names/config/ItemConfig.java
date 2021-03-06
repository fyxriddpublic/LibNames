package com.fyxridd.lib.names.config;

import com.fyxridd.lib.core.api.config.basic.Config;
import com.fyxridd.lib.core.api.config.basic.ListType;
import com.fyxridd.lib.core.api.config.basic.Path;
import com.fyxridd.lib.core.api.config.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/item.yml")
public class ItemConfig {
    private static class ItemConverter implements ListConvert.ListConverter<Map<String, String>> {
        @Override
        public Map<String, String> convert(String plugin, List list) {
            Map<String, String> items = new HashMap<>();
            for (Object o:list) {
                String s = (String) o;
                String[] ss = s.split(" ", 2);
                String name = ss[0];
                if (!name.contains(":")) name += ":0";
                String show = ss[1];
                items.put(name, show);
            }
            return items;
        }
    }

    @Path("item")
    @ListConvert(value = ItemConverter.class, listType = ListType.String)
    private Map<String, String> items;

    public Map<String, String> getItems() {
        return items;
    }
}
