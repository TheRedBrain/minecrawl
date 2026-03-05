# 1.0.0

TODO
- finish heavy attacks
  - animations
- crafting/upgrading system
  - recipes
  - upgrade material items
- first iteration of enchantments
- hub rework
  - tavern with several food blocks
  - enchanter with all enchantments unlocked
- remove mana?
- change spell recipes back to scrolls
  https://discord.com/channels/1272264429022744617/1272264429479919819/1425216860848390257

5 + 3 + 3 + 3 + 3 + 5 + 4 + 5 + 3 + 5 39

First release.

Contains all content previously included in the mod packs data/resource packs and also includes the following additions/changes/fixes:

## Additions

- added a first iteration of "heavy attacks" to weapons
  - these are spells which are always bound to the use item hotkey
  - heavy attacks require special conditions to be available, depending on the weapon type:
    - daggers require a weapon of the same kind in the offhand
    - some weapons don't have heavy attacks
    - all other weapons require the 2-handed stance
- added 'infinite rune pouches/arrow quivers'
- overhauled the Trial Chamber dungeon

## Changes

- reworked the hub area
  - pvp arena
  - mannequins with prebuild load outs
  - "work shops" granting access to netherite/unique equipment and spells
  - player housing with several mannequins to save custom load outs

## Fixes

- fixed "slanted" chamber sometimes failing to generate all its addons, leading to places where players could fall out of the map

## Backend/Technical stuff

- adjusted default player attributes (attack damage and attack speed are now 0 by default), items were modified to account for this (this change should not result in any changes in game play, but is required for future gameplay features to work properly)
- using the 'Default Components' mod, all third-party items used by the mod pack are now configured via the built-in data pack. This will drastically improve efficiency when implementing future content updates and balancing tweaks.
- all weapon items were tweaked to use the "attackrangeattribute:generic.attack_range" entity attribute instead of the "minecraft:player.entity_interaction_range" attribute. There should be no consequences in regular gameplay.

#