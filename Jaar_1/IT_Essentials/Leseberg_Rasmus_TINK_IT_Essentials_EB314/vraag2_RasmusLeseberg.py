# Rasmus Leseberg - 1TINK

def bereken_max_aantal_personen(element):
    appartement = element.split()
    sterren = appartement[2]
    ruimte = appartement[4]
    ruimte = ruimte.strip("opp:")
    ruimte = int(ruimte)
    aantal_personen = 0
    if sterren == "****":
        aantal_personen = (ruimte - 5) // 6
    elif sterren == "***":
        aantal_personen = (ruimte - 4) // 5
    elif sterren == "**":
        aantal_personen = (ruimte - 3) // 4
    return aantal_personen


def get_afstand(element):
    appartement = element.split()
    if len(appartement) == 9:
        afstand_piste = appartement[5]
    else:
        afstand_piste = appartement[6]

    afstand = afstand_piste.strip("afstand:")
    afstand = int(afstand)
    return afstand


def selecteer_appartementen(lijst, aantal_personen, balkon, maximum_afstand):
    lijst_ok = []
    for element in lijst:
        afstand_appartement = get_afstand(element)
        ruimte = bereken_max_aantal_personen(element)
        appartement_lijst = element.split()
        if len(appartement_lijst) == 9:
            balkon_lijst = appartement_lijst[5]
        else:
            balkon_lijst = 0
        if balkon == "ja" and balkon_lijst == "balkon":
            if aantal_personen <= ruimte and maximum_afstand <= afstand_appartement:
                lijst_ok.append(element)
    return lijst_ok


def appartement_juiste_prijs(lijst_ok, periode):
    for element in lijst_ok:
        appartement = element.split()
        prijs = int(appartement[-1])
        if periode == "kerst" or periode == "krokus":
            prijs = prijs * 4
        elif periode == "paas":
            prijs = prijs * 3
        return prijs


def druk(lijst_ok):
    for appartement in lijst_ok:
        print(appartement)
        print()


def main():
    lijst = ["Résidence Noeyms **** T0 opp:32 afstand:30  prijs 159",
             "Résidence Noemys **** T0 opp:28 balkon afstand:30 prijs 139",
             "Résidence Noemys **** T1 opp:34 afstand:30  prijs 148",
             "Résidence Noemys **** T3 opp:100 balkon afstand:30 prijs 431",
             "Résidence Noemys **** T1 opp:44 afstand:30 prijs 204",
             "Résidence Noemys **** T2 opp:50 afstand:30 balkon prijs 256",
             "Chalet L’Establou *** T3 opp:63 afstand:1200 prijs 208",
             "Résidence Odysee ** T1 opp:18 balkon afstand:300 prijs 83",
             "Résidence Odysee ** T3 opp:60  afstand:300 balkon prijs 139",
             "Ski Constellation *** T1 opp:30 afstand:250 prijs 105",
             "Ski Constellation *** T0 opp:30 afstand:250 balkon prijs 110",
             "Ski Constellation *** T2 opp:50 afstand:250 prijs 210",
             "Ski Constellation *** T3 opp:101 afstand:250 prijs 390",
             "Résidence Vacancéole Véga *** T1 opp:44 afstand:500 prijs 82",
             "Résidence Vacancéole Véga *** T3 opp:74 afstand:500 prijs 152",
             "Résidence Reneb ** T1 opp:22 afstand:250 prijs 72",
             "Résidence Reneb ** T0 opp:18 balkon afstand:250 prijs 83",
             "Résidence Pégase ** T1 opp:26 afstand:300 prijs 62",
             "Résidence Pégase ** T0 opp:25 afstand:300 prijs 60"]

    aantal_personen = int(input("Geef het gewenst aantal personen in "))
    balkon = input("Wens je een balkon? ")
    if balkon == "JA" or balkon == "jA" or balkon == "ja" or balkon == "Ja":
        balkon = "ja"
    else:
        balkon = "niet belangrijk"

    maximum_afstand = int(input("Geef de maximale afstand in meter tot de skipiste "))
    periode = input("Geef de gewenste periode in ")

    lijst_ok = selecteer_appartementen(lijst, aantal_personen, balkon, maximum_afstand)
    if len(lijst_ok) == 0:
        print("Er zijn geen appartementen die voldoen aan je eisen.")
    else:
        druk(lijst_ok)
        lijst_juiste_prijs = appartement_juiste_prijs(lijst_ok, periode)
        druk(lijst_juiste_prijs)


if __name__ == '__main__':
    main()
