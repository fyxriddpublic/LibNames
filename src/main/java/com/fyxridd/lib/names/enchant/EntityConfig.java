package com.fyxridd.lib.names.enchant;

import com.fyxridd.lib.config.api.basic.Config;
import com.fyxridd.lib.config.api.basic.ListType;
import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ListConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config("names/entity.yml")
public class EntityConfig {
    private class EntityConverter implements ListConvert.ListConverter<Map<String, String>> {
        @Override
        public Map<String, String> convert(String plugin, List list) {
            Map<String, String> entitys = new HashMap<>();
            for (Object o:list) {
                String s = (String) o;
                String[] ss = s.split(" ", 2);
                String name = ss[0];
                String show = ss[1];
                entitys.put(name, show);
            }
            return entitys;
        }
    }

    @Path("entity")
    @ListConvert(EntityConverter.class)
    @ListType(ListType.Type.String)
    private Map<String, String> entitys;

    public Map<String, String> getEntitys() {
        return entitys;
    }
}
