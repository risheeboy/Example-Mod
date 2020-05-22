package io.github.cadiboo.examplemod.init;

import io.github.cadiboo.examplemod.ExampleMod;
import io.github.cadiboo.examplemod.item.ItemBase;
import io.github.cadiboo.examplemod.item.ModdedSpawnEggItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */
public final class ModItems {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ExampleMod.MODID);

	// This is a very simple Item. It has no special properties except for being on our creative tab.
	public static final RegistryObject<Item> EXAMPLE_CRYSTAL = ITEMS.register("example_crystal", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<ModdedSpawnEggItem> WILD_BOAR_SPAWN_EGG = ITEMS.register("wild_boar_spawn_egg", () -> new ModdedSpawnEggItem(ModEntityTypes.WILD_BOAR, 0xF0A5A2, 0xA9672B, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

	//Tools
	public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ItemTier.DIAMOND, 9, 6.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ItemTier.DIAMOND, 7, 5.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ItemTier.DIAMOND, 6, 5.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ItemTier.DIAMOND, 11, 4.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ItemTier.DIAMOND, 5.0f, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));

	//Armor
	public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE =  ITEMS.register("ruby_chestplate", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<ArmorItem> RUBY_LEGGINGS =  ITEMS.register("ruby_leggings", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
	public static final RegistryObject<ArmorItem> RUBY_BOOTS =  ITEMS.register("ruby_boots", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP).group(ModItemGroups.MOD_ITEM_GROUP)));

	//Food
//	public static final RegistryObject<Item> RUBY_APPLE = ITEMS.register("ruby_apple", () -> new Item((new Item.Properties()).group(ItemGroup.FOOD).food(Foods.ENCHANTED_GOLDEN_APPLE)));

	public static final Food RUBY_APPLE_FOOD = (new Food.Builder()).hunger(4).saturation(1.2F).effect(new EffectInstance(Effects.REGENERATION, 4100, 5), 1.0F)
			.effect(new EffectInstance(Effects.RESISTANCE, 44100, 100), 1.0F)
			.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 49000, 0), 1.0F)
			.effect(new EffectInstance(Effects.ABSORPTION, 44100, 3), 1.0F)
			.effect(new EffectInstance(Effects.JUMP_BOOST, 44100, 15), 1.0F)
			.effect(new EffectInstance(Effects.NIGHT_VISION, 44100, 2), 1.0F)
			.effect(new EffectInstance(Effects.WATER_BREATHING, 44100, 15), 1.0F)
			.effect(new EffectInstance(Effects.HASTE, 44100, 2), 1.0F)
			.effect(new EffectInstance(Effects.SPEED, 44100, 15), 1.0F)
			.effect(new EffectInstance(Effects.STRENGTH, 44100, 15), 1.0F)
			.effect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 44100, 1), 1.0F)
			.effect(new EffectInstance(Effects.INVISIBILITY, 44100, 1), 1.0F)
			.effect(new EffectInstance(Effects.INSTANT_HEALTH, 44100, 15), 1.0F)
			.setAlwaysEdible().build();
	public static final RegistryObject<Item> RUBY_APPLE = ITEMS.register("ruby_apple", () -> new Item((new Item.Properties()).group(ItemGroup.FOOD).food(RUBY_APPLE_FOOD)));


	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	public enum ModArmorMaterial implements IArmorMaterial {
		RUBY(ExampleMod.MODID + ":ruby", 20, new int[] { 7, 9, 11, 7 }, 420, SoundEvents.BLOCK_CHEST_OPEN, 6.9F, () -> {
			return Ingredient.fromItems(ModItems.RUBY.get());
		});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;

		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
								 int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
								 Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
