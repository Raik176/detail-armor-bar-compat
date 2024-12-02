package org.rhm.detailab_compat;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DetailArmorBarCompatCommon {
	public static final String MOD_ID = "detailab_compat";
	public static final Map<ResourceLocation, CompatInfo> MOD_COMPATS = new CompatBuilder()
			.basicCompat("friendsandfoes", "wildfire_crown")
			/*
			.complexAllEquipment(builder ->
					builder.setLocation(textureId("emerald","emerald")), "emeraldequipment", "emerald")
			.complexAllEquipment(builder ->
					builder.setLocation(textureId("emerald","emerald")), "emeraldexpansion", "emerald")
			 */
			.build();

	private static ResourceLocation textureId(String ns, String name) {
		return id("textures/gui/sprites/hud/" + ns + "/" + name + ".png");
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
		private static final String[] EQUIPMENT_TYPES = {"helmet", "chestplate", "leggings", "boots"};

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
			for (String equipmentType : EQUIPMENT_TYPES) {
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
