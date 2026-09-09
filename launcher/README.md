# Kiya Launcher

Native Android launcher baseline designed to be selectable as the device Home app.

## Supported launcher experiences

- Standard / stock-like
- Third-party style
- Custom
- Minimalist
- Gaming

## Current capabilities

- HOME/DEFAULT intent registration
- Installed application discovery through launcher activities
- Searchable application drawer
- One-tap application launching
- Settings screen for launcher mode, labels, search, animations, animation duration, and gaming mode
- Local SharedPreferences configuration; no cloud dependency

## Architecture direction

The project is intentionally a small native Android core. Future modules can add widgets, folders, icon packs, gestures, per-profile layouts, backup/import/export, usage-aware organization, offline recognition, and a deterministic rules engine without coupling the launcher core to a vendor ecosystem.

## Build

Open `launcher/` as an Android Studio project and build the `app` module.
