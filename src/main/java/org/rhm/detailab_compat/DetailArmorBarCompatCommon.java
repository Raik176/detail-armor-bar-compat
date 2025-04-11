package org.rhm.detailab_compat;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DetailArmorBarCompatCommon {
	public static final String MOD_ID = "detailab_compat";
	public static final Map<ResourceLocation, CompatInfo> MOD_COMPATS = new CompatBuilder()
			.basicCompat("friendsandfoes", "wildfire_crown") // Friends and Foes

			.basicCompat("goated", "barbaric_helmet") // You've Goat to be Kidding Me!

			// Better Nether
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betternether", "cincinnasite")),
					"betternether",
					"cincinnasite"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betternether", "nether_ruby")),
					"betternether",
					"nether_ruby"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betternether", "flaming_ruby")),
					"betternether",
					"flaming_ruby"
			)

			// Archers (RPG Series)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("archers", "archer_armor")),
					"archers",
					"archer_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("archers", "ranger_armor")),
					"archers",
					"ranger_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("archers", "netherite_ranger")),
					"archers",
					"netherite_ranger",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)

			// Paladins & Priests (RPG Series)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("paladins", "crusader_armor")),
					"paladins",
					"crusader_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("paladins", "netherite_crusader")),
					"paladins",
					"netherite_crusader",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("paladins", "netherite_prior_robe")),
					"paladins",
					"netherite_prior_robe",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("paladins", "paladin_armor")),
					"paladins",
					"paladin_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("paladins", "priest_robe")),
					"paladins",
					"priest_robe",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("paladins", "prior_robe")),
					"paladins",
					"prior_robe",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)

			// Rogues & Warriors (RPG Series)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("rogues", "rogue_armor")),
					"rogues",
					"rogue_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("rogues", "assassin_armor")),
					"rogues",
					"assassin_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("rogues", "netherite_assassin_armor")),
					"rogues",
					"netherite_assassin_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("rogues", "warrior_armor")),
					"rogues",
					"warrior_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("rogues", "berserker_armor")),
					"rogues",
					"berserker_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("rogues", "netherite_berserker_armor")),
					"rogues",
					"netherite_berserker_armor",
					CompatBuilder.ALT_EQUIPMENT_TYPES
			)

			// Scorchful
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("scorchful", "turtle")),
					"scorchful",
					"turtle"
			)

			// Frostiful
			.complexCompat(
					builder -> builder.setLocation(textureId("frostiful", "frostology_cloak")),
					"frostiful",
					"inert_frostology_cloak"
			)
			.complexCompat(
					builder -> builder.setLocation(textureId("frostiful", "frostology_cloak")),
					"frostiful",
					"frostology_cloak"
			)
			.complexCompat(
					builder -> builder.setLocation(textureId("frostiful", "ice_skates")),
					"frostiful",
					"ice_skates"
			)
			.complexCompat(
					builder -> builder.setLocation(textureId("frostiful", "armored_ice_skates")),
					"frostiful",
					"armored_ice_skates"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("frostiful", "fur")),
					"frostiful",
					"fur"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("frostiful", "fur_padded")),
					"frostiful",
					"fur_padded_chainmail"
			)

			// Better End
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betterend", "aeternium")),
					"betterend",
					"aeternium"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betterend", "crystalite")),
					"betterend",
					"crystalite"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betterend", "terminite")),
					"betterend",
					"terminite"
			)
			.complexAllEquipment(
					builder -> builder.setLocation(textureId("betterend", "thallasium")),
					"betterend",
					"thallasium"
			)
			.basicCompat("betterend", "elytra_armored")
			.basicCompat("betterend", "elytra_crystalite")

			/*
			.complexAllEquipment(builder ->
					builder.setLocation(textureId("emerald","emerald")), "emeraldequipment", "emerald")
			.complexAllEquipment(builder ->
					builder.setLocation(textureId("emerald","emerald")), "emeraldexpansion", "emerald")
			*/
			.build();

	private static ResourceLocation textureId(String ns, String path) {
		return id("textures/gui/sprites/hud/" + ns + "/" + path + ".png");
	}
	private static ResourceLocation id(String path) {
		return id(MOD_ID,path);
	}
	private static ResourceLocation id(String ns, String path) {
		//? if >=1.21 {
		return ResourceLocation.tryBuild(ns,path);
		//?} else
		/*return new ResourceLocation(ns,path);*/
	}

	public static class CompatBuilder {
		public static final String[] EQUIPMENT_TYPES = {"helmet", "chestplate", "leggings", "boots"};
		public static final String[] ALT_EQUIPMENT_TYPES = {"head", "chest", "legs", "feet"};

		private final Map<ResourceLocation, CompatInfo> registered;


		public CompatBuilder() {
			this.registered = new HashMap<>();
		}

		@SafeVarargs
        public final CompatBuilder multiBasicCompat(Map.Entry<String, String>... ids) {
            for (Map.Entry<String, String> id : ids) {
                basicCompat(id.getKey(), id.getValue());
            }

			return this;
		}
		public CompatBuilder basicAllEquipment(String ns, String path) {
			for (String equipmentType : EQUIPMENT_TYPES) {
				basicCompat(ns,path + "_" + equipmentType);
			}

			return this;
		};
		public CompatBuilder basicCompat(String ns, String name) {
			return complexCompat(builder -> builder, ns, name);
		}


		@SafeVarargs
		public final CompatBuilder multiComplexCompat(Function<CompatInfo.Builder, CompatInfo.Builder> buildFunction, Map.Entry<String, String>... ids) {
            for (Map.Entry<String, String> id : ids) {
                complexCompat(buildFunction, id.getKey(), id.getValue());
            }

			return this;
		}
		public CompatBuilder complexAllEquipment(Function<CompatInfo.Builder, CompatInfo.Builder> buildFunction, String ns, String path) {
			return complexAllEquipment(buildFunction, ns, path, EQUIPMENT_TYPES);
		};
		public CompatBuilder complexAllEquipment(Function<CompatInfo.Builder, CompatInfo.Builder> buildFunction, String ns, String path, String[] equipmentTypes) {
			for (String equipmentType : equipmentTypes) {
				complexCompat(buildFunction, ns,path + "_" + equipmentType);
			}

			return this;
		};
		public CompatBuilder complexCompat(Function<CompatInfo.Builder, CompatInfo.Builder> buildFunction, String ns, String name) {
			registered.put(id(ns,name), buildFunction.apply(new CompatInfo.Builder(textureId(ns, name))).build());
			return this;
		}


		public Map<ResourceLocation, CompatInfo> build() {
			return registered;
		}
	}

	public static class CompatInfo {
		public static final int DEFAULT_SIZE = 18;

		private final ResourceLocation location;
		private final int size;
		private final Map.Entry<Integer,Integer> fullOffset;
		private final Map.Entry<Integer,Integer> halfOffset;
		private final Map.Entry<Integer,Integer> fullOutlineOffset;
		private final Map.Entry<Integer,Integer> halfOutlineOffset;

		private CompatInfo(Builder builder) {
			this.location = builder.location;
			this.size = builder.size;
			this.fullOffset = builder.fullOffset;
			this.halfOffset = builder.halfOffset;
			this.fullOutlineOffset = builder.fullOutlineOffset;
			this.halfOutlineOffset = builder.halfOutlineOffset;
		}

		public ResourceLocation getLocation() {
			return location;
		}

		public int getSize() {
			return size;
		}

		public Map.Entry<Integer, Integer> getFullOffset() {
			return fullOffset;
		}

		public Map.Entry<Integer, Integer> getHalfOffset() {
			return halfOffset;
		}

		public Map.Entry<Integer, Integer> getFullOutlineOffset() {
			return fullOutlineOffset;
		}

		public Map.Entry<Integer, Integer> getHalfOutlineOffset() {
			return halfOutlineOffset;
		}

		public static class Builder {
			ResourceLocation location;
			int size;
			Map.Entry<Integer,Integer> fullOffset;
			Map.Entry<Integer,Integer> halfOffset;
			Map.Entry<Integer,Integer> fullOutlineOffset;
			Map.Entry<Integer,Integer> halfOutlineOffset;

			public Builder(ResourceLocation location) {
				this.location = location;
				this.size = DEFAULT_SIZE;
				this.fullOffset = Map.entry(9,0);
				this.halfOffset = Map.entry(0,0);
				this.fullOutlineOffset = Map.entry(9,9);
				this.halfOutlineOffset = Map.entry(0,9);
			}

			public Builder setLocation(ResourceLocation location) {
				this.location = location;
				return this;
			}

			public Builder setSize(int size) {
				this.size = size;
				return this;
			}

			public Builder setFullOffset(int x, int y) {
				this.fullOffset = Map.entry(x,y);
				return this;
			}

			public Builder setHalfOffset(int x, int y) {
				this.fullOffset = Map.entry(x,y);
				return this;
			}

			public Builder setFullOutlineOffset(int x, int y) {
				this.fullOffset = Map.entry(x,y);
				return this;
			}

			public Builder setHalfOutlineOffset(int x, int y) {
				this.fullOffset = Map.entry(x,y);
				return this;
			}

			public CompatInfo build() {
				return new CompatInfo(this);
			}
		}
	}
}
