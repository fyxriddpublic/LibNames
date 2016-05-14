package com.fyxridd.lib.names.enchant;

import com.fyxridd.lib.config.api.basic.Config;
import com.fyxridd.lib.config.api.basic.ListType;
import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/potion.yml")
public class PotionConfig {
    private class PotionConverter implements ListConvert.ListConverter<Map<Integer, String>> {
        @Override
        public Map<Integer, String> convert(String plugin, List list) {
            Map<Integer, String> potions = new HashMap<>();
            for (Object o:list) {
                String s = (String) o;
                String[] ss = s.split(" ", 2);
                int id = Integer.parseInt(ss[0]);
                String show = ss[1];
                potions.put(id, show);
            }
            return potions;
        }
    }

    @Path("potion")
    @ListConvert(PotionConverter.class)
    @ListType(ListType.Type.String)
    private Map<Integer, String> potions;

    public Map<Integer, String> getPotions() {
        return potions;
    }
}
