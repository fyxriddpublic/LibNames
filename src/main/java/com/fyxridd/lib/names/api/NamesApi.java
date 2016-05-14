package com.fyxridd.lib.names.api;

import com.fyxridd.lib.names.NamesPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class NamesApi {
    /**
     * 获取世界的名字
     * @param world 世界名,可为null(null时返回"")
     * @return 世界的显示名,不会为null
     */
    public static String getWorldName(String world) {
        return NamesPlugin.instance.getNamesManager().getWorldName(world);
    }

    /**
     * 获取附魔名
     * @param id 附魔ID
     * @return 附魔名,不会为null
     */
    public static String getEnchantName(int id) {
        return NamesPlugin.instance.getNamesManager().getEnchantName(id);
    }

    /**
     * 获取物品的名字<br>
     * 物品显示名(displayName)优先
     * @param is 物品,可为null
     * @return 不会为null
     */
    public static String getItemName(ItemStack is) {
        return NamesPlugin.instance.getNamesManager().getItemName(is);
    }

    /**
     * 获取物品的名字
     * @param id 物品ID
     * @param smallId 物品小ID
     * @return 不会为null
     */
    public static String getItemName(int id, int smallId) {
        return NamesPlugin.instance.getNamesManager().getItemName(id, smallId);
    }

    /**
     * @see #getEntityName(Entity, boolean, boolean)
     */
    public static String getEntityName(Entity entity) {
        return getEntityName(entity, true, true);
    }

    /**
     * 获取实体的名字
     * @param entity 实体,可为null(null时返回"")
     * @param customName 如果是生物,是否以customName优先
     * @param playerName 如果是玩家,是否加上玩家名(true时会忽视customName的设定)
     * @return 名字,不为null
     */
    public static String getEntityName(Entity entity, boolean customName, boolean playerName) {
        return NamesPlugin.instance.getNamesManager().getEntityName(entity, customName, playerName);
    }

    /**
     * 获取实体的名字
     * @param id 实体ID
     * @return 实体名,不会为null
     */
    public static String getEntityName(int id) {
        return NamesPlugin.instance.getNamesManager().getEntityName(id);
    }

    /**
     * 获取实体的名字
     * @param name 实体类型enum值,可为null
     * @return 实体名,不会为null
     */
    public static String getEntityName(String name) {
        return NamesPlugin.instance.getNamesManager().getEntityName(name);
    }

    /**
     * 获取药效名字
     * @param id 药效ID
     * @return 不会为null
     */
    public static String getPotionName(int id) {
        return NamesPlugin.instance.getNamesManager().getPotionName(id);
    }

    /**
     * 获取物品名映射<br>
     * 格式: '物品ID:小ID,显示名'
     */
    public static Map<String, String> getItemNames() {
        return NamesPlugin.instance.getNamesManager().getItemConfig().getItems();
    }
}
