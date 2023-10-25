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
        PowerStatus("Health", 761, 2000),
        PowerStatus("Armor", 20, 100),
        PowerStatus("Attack", 80, 300),
        PowerStatus("Movement Speed", 34, 100),
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

val hero2 = Hero(
    id = 2,
    name = "Adagio",
    image = "https://www.vaingloryfire.com/images/heroes/potrait/adagio.png",
    imageBackground = "https://www.vainglorygame.com/wp-content/uploads/2017/09/AdagioActive.png",
    desc = "The master manipulator of large-scale battles, Adagio brings incredible teamfight presence with huge area-of-effect damage and team-saving abilities. He almost seems too good: He can heal. He can amplify damage. He can stun and nuke the entire enemy team ... but none of these can be achieved easily without team-wide coordination. Adagio is extremely flexible and can start as carry, jungler or captain.",
    power = listOf(
        PowerStatus("Health", 1654, 2000),
        PowerStatus("Armor", 86, 100),
        PowerStatus("Attack", 117, 300),
        PowerStatus("Movement Speed", 32, 50),
    ),
    role = "Captain",
    attackType = "Range",
    position = "Support",
    skills = listOf(
        SkillStatus(
            skillName = "Arcane Renewal (Perk)",
            skillDesc = "Whenever enemies burning with Arcane Fire take damage from any source, Adagio regenerates 35% of that damage as energy.",
            skillImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/b/b2/AdaP.png/revision/latest?cb=20161226205601",
        ), SkillStatus(
            skillName = "Gift of Fire",
            skillDesc = "Adagio heals a target ally and splashes Arcane Fire onto nearby enemies, dealing damage every second. If Adagio targets himself, he'll also slow nearby enemies by 70% for 1.5 seconds.",
            skillImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/f/fb/AdaA.png/revision/latest?cb=20161226205611",
        ), SkillStatus(
            skillName = "Agent of Wrath",
            skillDesc = "Temporarily empower target hero's basic attacks for either a fixed number of attacks or 6 seconds. The attacks deal increased damage to enemies afflicted by Arcane Fire, and also deal increased damage if Adagio casts this spell on himself. Resets basic attack cooldown on activation.",
            skillImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/4/4a/AdaB.png/revision/latest?cb=20161226205556",
        ), SkillStatus(
            skillName = "Verse of Judgement",
            skillDesc = "Adagio channels for 2 seconds then deals heavy damage to all enemies in a wide, rune-marked ring around him. Enemies burning with Arcane Fire are also stunned. Adagio temporarily gains fortified health during channeling.",
            skillImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/0/01/AdaU.png/revision/latest?cb=20161226205606",
        )
    ),
    skins = listOf(
        SkinStatus(
            skinName = "Default",
            skinImage = "https://www.vaingloryfire.com/images/heroes/potrait/adagio.png"
        ),
        SkinStatus(
            skinName = "Parade Adagio (R)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/AdagioT1Flat.jpg",
            skinType = "Rare",
        ),
        SkinStatus(
            skinName = "Parade Adagio (E)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/AdagioT2Flat.jpg",
            skinType = "Epic",
        ),
        SkinStatus(
            skinName = "Parade Adagio (L)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/AdagioT3Flat.jpg",
            skinType = "Legendary",
        ),
    )
)

val hero3 = Hero(
    id = 3,
    name = "Koshka",
    image = "https://www.vaingloryfire.com/images/heroes/potrait/koshka.png",
    imageBackground = "https://www.vainglorygame.com/wp-content/uploads/2017/09/KoshkaActive.png",
    desc = "Koshka is an in-your-face assassin adept at getting the kill and then getting out. She should focus on assassinating weak targets and locking down the most lethal enemy.",
    power = listOf(
        PowerStatus("Health", 1595, 2000),
        PowerStatus("Armor", 86, 100),
        PowerStatus("Attack", 164, 300),
        PowerStatus("Movement Speed", 32, 100),
    ),
    role = "Assassin",
    attackType = "Melee",
    position = "Jungler",
    skills = listOf(
        SkillStatus(
            skillName = "Bloodrush (Perk)",
            skillDesc = "Koshka gains 0.5 move speed for each enemy she hits with her abilities. Lasts 5 seconds. Max 4 stacks.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/Koshka-P-bloodrush.png",
        ),
        SkillStatus(
            skillName = "Pouncy Fun",
            skillDesc = "Koshka dashes to the target enemy and deals damage. Pounce cooldown is reduced by 2 seconds each time she executes a basic attack.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/Koshka-A-Pouncy-Fun.png",
        ),
        SkillStatus(
            skillName = "Twirly Death",
            skillDesc = "Koshka twirls, damaging all enemies around her. She gains a boosted basic attack for each enemy hit by the twirl (up to 12). Twirl cooldown is reduced by 2 seconds each time she executes a basic attack.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/Koshka-B-twirly-death.png",
        ),
        SkillStatus(
            skillName = "Yummy Catnip Frenzy",
            skillDesc = "Koshka leaps at her target then launches into a flurry of slashes, stunning the target for the entire 2.2 second duration. Cooldown is reduced by 1 second each time she executes a basic attack.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/Koshka-C-yummy-catnip-frenzy.png",
        ),

        ),
    skins = listOf(
        SkinStatus(
            skinName = "Default",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/b/ba/Koshka.jpg/revision/latest?cb=20161218150237"
        ),
        SkinStatus(
            skinName = "Kandi Twirl Koshka (R)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/KoshkaT1Flat.jpg",
            skinType = "Rare"
        ),
        SkinStatus(
            skinName = "Kandi Twirl Koshka (E)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/KoshkaT2Flat.jpg",
            skinType = "Epic"
        ),
        SkinStatus(
            skinName = "Kandi Twirl Koshka (L)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2015/05/KoshkaT3Flat.jpg",
            skinType = "Legendary"
        ),
        SkinStatus(
            skinName = "Red Lantern Koshka (LE)",
            skinImage = "https://static.wikia.nocookie.net/vainglory_gamepedia/images/b/bb/RLKoshkaLE.jpg/revision/latest?cb=20161218150305",
            skinType = "Limited Edition"
        ),
    )
)

val hero4 = Hero(
    id = 4,
    name = "Lyra",
    image = "https://www.vaingloryfire.com/images/heroes/potrait/lyra.png",
    imageBackground = "https://www.vainglorygame.com/wp-content/uploads/2017/09/LyraActive.png",
    desc = "Drawing upon her training as a Gythian battlemage, Lyra uses healing and protective magic to turn enemy positions into powerful zones for her allies. Her portals also allow her team to bypass these positions entirely, avoiding defenses and terrain. Utility and defense items improve her role as a healer, while crystal items provide a devastating but fragile mage path.",
    power = listOf(
        PowerStatus("Health", 1895, 2000),
        PowerStatus("Armor", 50, 100),
        PowerStatus("Attack", 30, 300),
        PowerStatus("Movement Speed", 33, 100),
    ),
    role = "Protector",
    attackType = "Ranged",
    position = "Captain",
    skills = listOf(
        SkillStatus(
            skillName = "Principle Arcanum",
            skillDesc = "Lyra’s attacks are arcane missiles, dealing crystal damage. If she holds her ground after releasing an attack, she automatically channels and releases a much stronger arcane missile that deals additional crystal damage and briefly slows its target. Each channeled missile consumes energy, but Lyra can continue using these even if she runs out of energy.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2016/06/Lyra_Ability_Icons_perk_square.png",
        ),
        SkillStatus(
            skillName = "Imperial Sigil",
            skillDesc = "Lyra forms a sigil at the target location, revealing surrounding enemies. While this sigil remains active, it heals nearby allied heroes and damages nearby enemy heroes. Lyra can reactivate this ability at any time to detonate the sigil, dealing heavy damage to surrounding enemies while providing a burst of healing and a moderate move speed boost to nearby allies.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2016/06/Lyra_Ability_Icons_A1.png",
        ),
        SkillStatus(
            skillName = "Bright Bulwark",
            skillDesc = "After a brief delay, Lyra releases a pulse of magical energy, damaging and applying a decaying slow to surrounding enemies. The affected area then becomes a walled zone of protection that deals the same damage and slow to enemies attempting to cross its borders. Enemies inside the zone are snared, allowing them to move normally but preventing them from using movement abilities.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2016/06/Lyra_Ability_Icons_B.png",
        ),
        SkillStatus(
            skillName = "Arcane Passage",
            skillDesc = "Lyra blinks to the target location, leaving portals at both the beginning and the end of the blink. Portals last for a few seconds, allowing allied and enemy heroes to move freely between them in both directions. Heroes must wait several seconds before they can re-enter a portal. This cooldown is also applied to enemies when Lyra hits them with the initial pulse of Bright Bulwark.",
            skillImage = "https://www.vainglorygame.com/wp-content/uploads/2016/06/Lyra_Ability_Icons_C.png",
        ),
    ),
    skins = listOf(
        SkinStatus(
            skinName = "Default",
            skinImage = "https://www.vaingloryfire.com/images/heroes/potrait/lyra.png"
        ),
        SkinStatus(
            skinName = "School Days Lyra (R)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2016/06/Lyra_SchoolDays-web.png",
            skinType = "Rare",
        ),
        SkinStatus(
            skinName = "Dear Diary Lyra (L)",
            skinImage = "https://www.vainglorygame.com/wp-content/uploads/2016/06/Lyra_Unicorn-web.jpg",
            skinType = "Legendary",
        ),
    )
)

val listHeroes = listOf(
    hero,
    hero2,
    hero3,
    hero4,
)
