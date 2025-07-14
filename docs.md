# Legend-Style Engine — Project Structure Overview

This document outlines the folder layout, game object inheritance model, and rendering architecture for the Legend of Kyrandia–inspired game engine.

---

## 1. Folder Structure

/src/
├── engine/ # Core reusable engine modules
│ ├── core/ # Game loop, time, config
│ ├── entity/ # Entity, GameObject, Renderable logic
│ ├── enums/ # enumaration, other global vars
│ ├── input/ # Input tracking and abstraction
│ ├── render/ # Z-sorting, draw management
│ └── util/ # Helpers, math, files
│
├── game/ # Game-specific content (non-reusable)
│ ├── scenes/ # Scene definitions (JSON, logic)
│ ├── actors/ # Player, NPC subclasses
│ ├── objects/ # Items, props, triggers
│ ├── logic/ # Cutscene and interaction scripts
│ └── data/ # Dialogue, translations, constants

## 2. Object Structure (Entity Inheritance Tree)

Entity
│
├── Renderable             # Can be drawn with texture or animation
│   ├── NamedEntity        # Has a name (tooltip, dialogue)
│   │   ├── PlayerEntity   # Controlled by input
│   │   ├── NpcEntity      # Dialogue, AI, script hooks
│   │   └── ItemEntity     # Can be picked up, used
│   └── EffectEntity       # Animated visuals (particles, glow)
│
├── ScriptedEntity         # Executes scripted logic on trigger
└── HotspotEntity          # Clickable region on scene