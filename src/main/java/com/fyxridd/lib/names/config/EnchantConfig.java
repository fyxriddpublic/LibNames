package com.fyxridd.lib.names.config;

import com.fyxridd.lib.config.api.basic.Config;
import com.fyxridd.lib.config.api.basic.ListHelper;
import com.fyxridd.lib.config.api.basic.ListType;
import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/enchant.yml")
public class EnchantConfig {
    private class EnchantsConverter implements ListConvert.ListConverter<Map<Integer, String>> {
        @Override
        public Map<Integer, String> convert(String plugin, List list) {
            Map<Integer, String> enchants = new HashMap<>();
            for (Object o:list) {
                String s = (String) o;
                String[] ss = s.split(" ", 2);
                int id = Integer.parseInt(ss[0]);
                String show = ss[1];
                enchants.put(id, show);
            }
            return enchants;
        }
    }

    @Path("enchant")
    @ListConvert(value = EnchantsConverter.class, listType = ListType.String)
    private Map<Integer, String> enchants;

    public Map<Integer, String> getEnchants() {
        return enchants;
    }
}
