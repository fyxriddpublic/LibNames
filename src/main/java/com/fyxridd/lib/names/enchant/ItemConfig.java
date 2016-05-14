package com.fyxridd.lib.names.enchant;

import com.fyxridd.lib.config.api.basic.Config;
import com.fyxridd.lib.config.api.basic.ListType;
import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/item.yml")
public class ItemConfig {
    private class ItemConverter implements ListConvert.ListConverter<Map<String, String>> {
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
    @ListConvert(ItemConverter.class)
    @ListType(ListType.Type.String)
    private Map<String, String> items;

    public Map<String, String> getItems() {
        return items;
    }
}
