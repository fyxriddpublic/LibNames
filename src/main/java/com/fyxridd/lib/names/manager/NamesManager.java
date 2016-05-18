package com.fyxridd.lib.names.manager;

import com.fyxridd.lib.core.api.config.ConfigApi;
import com.fyxridd.lib.core.config.ConfigManager;
import com.fyxridd.lib.names.NamesPlugin;
import com.fyxridd.lib.names.config.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class NamesManager{
	private EnchantConfig enchantConfig;
    private EntityConfig entityConfig;
    private ItemConfig itemConfig;
    private PotionConfig potionConfig;
    private WorldConfig worldConfig;

	public NamesManager() {
        //注册配置
        ConfigApi.register(NamesPlugin.instance.pn, EnchantConfig.class);
        ConfigApi.register(NamesPlugin.instance.pn, EntityConfig.class);
        ConfigApi.register(NamesPlugin.instance.pn, ItemConfig.class);
        ConfigApi.register(NamesPlugin.instance.pn, PotionConfig.class);
        ConfigApi.register(NamesPlugin.instance.pn, WorldConfig.class);

        //添加配置监听
        ConfigApi.addListener(NamesPlugin.instance.pn, EnchantConfig.class, new ConfigManager.Setter<EnchantConfig>() {
            @Override
            public void set(EnchantConfig value) {
                enchantConfig = value;
            }
        });
        ConfigApi.addListener(NamesPlugin.instance.pn, EntityConfig.class, new ConfigManager.Setter<EntityConfig>() {
            @Override
            public void set(EntityConfig value) {
                entityConfig = value;
            }
        });
        ConfigApi.addListener(NamesPlugin.instance.pn, ItemConfig.class, new ConfigManager.Setter<ItemConfig>() {
            @Override
            public void set(ItemConfig value) {
                itemConfig = value;
            }
        });
        ConfigApi.addListener(NamesPlugin.instance.pn, PotionConfig.class, new ConfigManager.Setter<PotionConfig>() {
            @Override
            public void set(PotionConfig value) {
                potionConfig = value;
            }
        });
        ConfigApi.addListener(NamesPlugin.instance.pn, WorldConfig.class, new ConfigManager.Setter<WorldConfig>() {
            @Override
            public void set(WorldConfig value) {
                worldConfig = value;
            }
        });
	}

	public String getWorldName(String world) {
        if (world == null) return "";

		if (worldConfig.getWorlds().containsKey(world)) return worldConfig.getWorlds().get(world);
		else return world;
	}

	public String getEnchantName(int id) {
		if (enchantConfig.getEnchants().containsKey(id)) return enchantConfig.getEnchants().get(id);
		else {
			Enchantment enchantment = Enchantment.getById(id);
			if (enchantment == null) return "";
			else return enchantment.getName();
		}
	}

	public String getItemName(ItemStack is) {
        if (is == null) return "";
		if (is.hasItemMeta()) {
			ItemMeta im = is.getItemMeta();
			if (im.getDisplayName() != null && !im.getDisplayName().isEmpty()) return im.getDisplayName();
		}
		return getItemName(is.getTypeId(), is.getDurability());
	}

	public String getItemName(int id, int smallId) {
		String result = itemConfig.getItems().get(id+":"+smallId);
		if (result == null) {
            result = itemConfig.getItems().get(id + ":" + 0);
            if (result == null) result = new ItemStack(id, 1, (short) smallId).getType().name();
            if (result == null) result = "";
        }
		return result;
	}

	public String getEntityName(Entity entity, boolean customName, boolean playerName) {
		if (entity == null) return "";
		try {
			if (playerName && entity instanceof Player) {
				return entity.getName();
			}else if (customName && entity instanceof LivingEntity) {
				String name = entity.getCustomName();
				if (name != null && !name.trim().isEmpty()) return name;
			}
		} catch (Exception e) {
            //do nothing
		}
		return getEntityName(entity.getType().name());
	}

	public String getEntityName(int id) {
		try {
            return getEntityName(EntityType.fromId(id).name());
		} catch (Exception e) {
			return "";
		}
	}

    public String getEntityName(String name) {
        if (name == null) return "";
        String result = entityConfig.getEntitys().get(name);
        if (result == null) result = name;
        return result;
    }

	public String getPotionName(int id) {
		try {
			String result = potionConfig.getPotions().get(id);
			if (result == null) {
                result = PotionEffectType.getById(id).getName();
                if (result == null) result = "";
            }
			return result;
		} catch (Exception e) {
			return "";
		}
	}

    public EnchantConfig getEnchantConfig() {
        return enchantConfig;
    }

    public EntityConfig getEntityConfig() {
        return entityConfig;
    }

    public ItemConfig getItemConfig() {
        return itemConfig;
    }

    public PotionConfig getPotionConfig() {
        return potionConfig;
    }

    public WorldConfig getWorldConfig() {
        return worldConfig;
    }
}
