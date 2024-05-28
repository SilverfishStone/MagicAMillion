#### Many enchantments are customizable for use in modpacks and other mods.


### FARMER'S CURSE
Foods can be added to or removed from the curse's effect by modifying the tag `"magicamillion:farm_foods"`


### SCULK SPEED

Blocks must be in the `"magicamillion:sculk"` block tag in order for them to have an effect.


### WAVE STRUCK & WATERLOGGED

Entities can be detected as Nether mobs by adding them to the "nether" tag at `"magicamillion:tags/entity_types/nether.json"`.


### ANTIDOTE

Effects modified by this enchantment are found in `"magicamillion:tags/mob_effect/hurtful.json"`.


### SIFTING

Sifting Enchantment has three seperate loot tables, based on where it is used.
In biomes tagged with `"minecraft:has_desert_pyramid"` or `"forge:is_desert"`, loot is spawned as a random item from `"magicamillion:tags/items/desert_treaure"`.
In biomes tagged with `"minecraft:is_ocean"`, loot is spawned as a random item from `"magicamillion:tags/items/ocean_treaure"`.
In all other biomes, loot is spawned as a random item from `"magicamillion:tags/items/random_treaure"`.
Blocks can be defined as either `"magicamillion:desert_treasure_possible"` or `"magicamillion:ocean_treasure_possible"`, depending on the biome it spawns in.


### INSURANCE

Insurance tests for files in `"forge:items/insurance"`. if nothing is found, it drops a random item from `"forge:items/insurance/unknown_tool_insurance.json"`.
To add an item, create a file in the "forge:items/insurance" directory with "*item description id*_insurance" as its name, and add your items as possible drops
##### EXAMPLE:
* Item: Cleaver
* Item translation string: `"item.examplemod.cleaver"`
* Insurance tag name: `"item.examplemod.cleaver_insurance.json"`
* Tag contents:
* {
   * "values": [
       * "minecraft:iron_ingot",
       * "minecraft:iron_nugget"
   * ]
* }