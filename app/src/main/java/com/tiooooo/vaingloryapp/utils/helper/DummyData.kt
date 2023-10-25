package com.tiooooo.vaingloryapp.utils.helper

import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.data.model.PowerStatus
import com.tiooooo.vaingloryapp.data.model.SkillStatus
import com.tiooooo.vaingloryapp.data.model.SkinStatus

val hero = Hero(
    id = 1,
    name = "Ardan",
    image = "https://www.vaingloryfire.com/images/heroes/potrait/ardan.png",
    imageBackground = "https://www.vainglorygame.com/wp-content/uploads/2017/09/ArdanActive.png",
    desc = "Ardan is a protector who can dash to and through enemies, and who bolsters his teammates with a protective barrier.",
    power = listOf(
        PowerStatus("Health", 761.0, 2000.0),
        PowerStatus("Armor", 20.0, 100.0),
        PowerStatus("Attack", 80.0, 300.0),
        PowerStatus("Movement Speed", 34.0, 100.0),
    ),
    role = "Captain",
    attackType = "Melee",
    position = "Roam",
    skills = listOf(
        SkillStatus(
            skillName = "Julia's Gift (Perk)",
            skillDesc = "Ardan's attacks and abilities build Blood for Blood stacks on enemies. At 20 stacks, the target is dealt 10% of their max health as crystal damage. This can only occur once every 2s per enemy.",
            skillImage = "https://static.wikia.nocookie.net/vainglory/images/4/44/Ardan_perk.png/revision/latest?cb=20180531170310",
        ),
        SkillStatus(
            skillName = "Vanguard",
            skillDesc = "Ardan dashes to protect an ally, granting them a 4-second barrier and a burst of move speed. This also slows and damages nearby enemies.",
            skillImage = "https://static.wikia.nocookie.net/vainglory/images/1/1a/Ardan_A.png/revision/latest?cb=20180531170331",
        ),
        SkillStatus(
            skillName = "Blood for Blood",
            skillDesc = "Ardan rushes forward and punches his target.\n" + "\n" + "Overdrive: At max rank, Blood for Blood deals an additional 40% damage.\n" + "Blood for Blood can only be activated when Ardan has 100% Vengeance and will consume all of it.\n" + "Blood for Blood triggers basic-attack effects.",
            skillImage = "https://static.wikia.nocookie.net/vainglory/images/1/13/Ardan_B.png/revision/latest?cb=20180531170350",
        ),
        SkillStatus(
            skillName = "Gauntlet",
            skillDesc = "Ardan leaps to the target location and projects a perimeter around him. Enemy heroes who touch or cross the perimeter are stunned and take crystal damage.",
            skillImage = "https://static.wikia.nocookie.net/vainglory/images/a/a7/Ardan_ULT.png/revision/latest?cb=20180531170413",
        ),
    ),
    skins = listOf(
        SkinStatus(
            skinName = "Ardan Default Skin",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/c/ce/Ardan.jpg/revision/latest?cb=20170212104620"
        ),
        SkinStatus(
            skinName = "Stormload Ardan (R)",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/b/be/SArdanR.jpg/revision/latest/scale-to-width-down/1000?cb=20170212104752",
            skinType = "Rare"
        ),
        SkinStatus(
            skinName = "Stormload Ardan (E)",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/2/20/SArdanE.jpg/revision/latest/scale-to-width-down/1000?cb=20170212104647",
            skinType = "Epic"
        ),
        SkinStatus(
            skinName = "Stormload Ardan (L)",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/e/e5/SArdanL.jpg/revision/latest/scale-to-width-down/1000?cb=20170212105353",
            skinType = "Legendary"
        ),
        SkinStatus(
            skinName = "Gladiator Ardan (E)",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/2/2c/GArdanE.jpg/revision/latest/scale-to-width-down/1000?cb=20170212104940",
            skinType = "Epic"
        ),
    )
)

val listHeroes = listOf(
    hero,
)
