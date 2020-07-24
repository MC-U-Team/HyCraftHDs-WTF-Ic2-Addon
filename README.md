# HyCraftHDs-WTF-Ic2-Addon

[
![Curseforge Downloads](http://cf.way2muchnoise.eu/hycrafthds-wtf-ic2-addon.svg)
![Curseforge Versions](http://cf.way2muchnoise.eu/versions/hycrafthds-wtf-ic2-addon.svg)
](https://www.curseforge.com/minecraft/mc-mods/hycrafthds-wtf-ic2-addon)
[
![Discord](https://img.shields.io/discord/297104769649213441?label=Discord)
](https://discordapp.com/invite/QXbWS36)

### This mod adds some endgame energy things for ic2.

- Download on [curseforge](https://www.curseforge.com/minecraft/mc-mods/hycrafthds-wtf-ic2-addon).  
- Find more information on our [website](https://u-team.info/mods/wtfic2addon).
- Updates can be found in the [changelog](CHANGELOG.md).

### How to build this mod

#### Setup Eclipse
- ``./gradlew setupDecompWorkspace eclipse``
- Import project as existing workspace

#### Setup IntelliJ IDEA
- ``./gradlew setupDecompWorkspace idea``
- Import project as existing workspace

#### Build
- ``./gradlew build``

### How to include this mod

- Repository: [repo.u-team.info](https://repo.u-team.info)
- Artifact: **info.u-team:hycrafthds_wtf_ic2_addon-${config.forge.mcversion}:${config.wtfic2addon.version}** 
- *{config.forge.mcversion}* is the minecraft version.
- *{config.wtfic2addon.version}* is the wtfic2addon version.

#### Using in Forge Gradle 2.3:
```gradle
repositories {
    maven { url = "https://repo.u-team.info" }
}

dependencies {
  deobfCompile "info.u-team:hycrafthds_wtf_ic2_addon-${config.forge.mcversion}:${config.wtfic2addon.version}"
}
```

### License

- This mod is licensed under apache 2 license. For more information see [here](LICENSE).  
- This mod can be packed in any curseforge modpack you like.

### Issues

- Please report issues to the [github issues](../../issues).
- Include your minecraft version, forge version and mod version.
- Upload your log on [gist](https://gist.github.com) or [pastebin](https://pastebin.com) and include link in your report.
