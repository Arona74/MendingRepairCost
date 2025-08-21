# MendingRepairCost

A Minecraft Fabric mod that reworks the Mending enchantment to make item maintenance more strategic and cost-effective.

## Overview

**MendingRepairCost** fundamentally changes how the Mending enchantment works in Minecraft. Instead of automatically repairing items with experience orbs, this mod transforms Mending into a powerful enchantment that resets repair costs when using anvils.

## Features

### 🚫 **Removes Automatic XP Repair**
- Items with Mending will **no longer** be automatically repaired by experience orbs
- Players still gain experience points normally from all sources
- Experience orbs function exactly as they would without Mending items

### ⚒️ **Anvil Repair Cost Reset**
- When repairing, combining, or enchanting items with Mending in an anvil, the **repair cost is reset to 0**
- This prevents the exponential cost increase that normally makes items "too expensive" to repair
- Makes Mending items infinitely maintainable through traditional repair methods

## Why This Change?

The vanilla Mending enchantment creates a "set it and forget it" gameplay loop where players never need to think about item maintenance once they have Mending. This mod makes Mending more strategic:

- **Encourages active gameplay**: Players must engage with repair mechanics rather than relying on passive healing
- **Balances powerful items**: High-tier gear requires more intentional maintenance
- **Preserves item value**: Items with Mending become valuable long-term investments rather than replacing the entire repair system
- **Maintains progression**: Players still need resources and planning for repairs, but without the cost spiral

## Installation

### Requirements
- **Minecraft**: 1.20.1
- **Fabric Loader**: 0.14.21 or higher
- **Fabric API**: Latest version for 1.20.1
- **Java**: 17 or higher

### Steps
1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.20.1
2. Download [Fabric API](https://modrinth.com/mod/fabric-api) and place it in your `mods` folder
3. Download the latest release of MendingRepairCost from the [Releases](https://github.com/arona74/mendingrepaircost/releases) page
4. Place the `.jar` file in your Minecraft `mods` folder
5. Launch Minecraft with the Fabric profile

## Compatibility

- **Client-side**: ✅ Works on clients
- **Server-side**: ✅ Works on servers  
- **Single-player**: ✅ Fully supported
- **Multiplayer**: ✅ Must be installed on server

This mod uses Mixins to modify core game behavior and should be compatible with most other mods. However, mods that heavily modify experience orb behavior or anvil mechanics may have conflicts.

## Gameplay Examples

### Before (Vanilla Mending)
```
1. Get Mending sword
2. Fight mobs → sword repairs automatically
3. Never think about maintenance again
```

### After (MendingRepairCost)
```
1. Get Mending sword
2. Fight mobs → gain XP, sword doesn't repair
3. When sword is damaged, repair in anvil with materials
4. Repair cost resets to 0, can repeat infinitely
5. Strategic resource management required
```

## Technical Details

This mod modifies two key systems:
- **Experience Orb Logic**: Prevents automatic repair of Mending items
- **Anvil Logic**: Resets repair cost for Mending items during anvil operations

The mod is lightweight and only activates when Mending items are present, ensuring minimal performance impact.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

- **Issues**: Report bugs on the [GitHub Issues](https://github.com/arona74/mendingrepaircost/issues) page
- **Suggestions**: Feature requests welcome in issues
- **Compatibility**: List any mod conflicts in issues for investigation
