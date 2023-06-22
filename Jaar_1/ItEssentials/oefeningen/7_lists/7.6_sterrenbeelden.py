def sterrenbeelden_functie(geboortedatum):
    dag = int(geboortedatum[0:2])
    maand = int(geboortedatum[3:5])
    sterrenbeelden = ["waterman", "vissen", "ram", "stier", "tweelingen", "kreeft", "leeuw", "maagd", "weegschaal",
                      "scorpioen", "boogschutter", "steenbok"]

    if maand == 1 and dag < 21:
        sterrenbeeld = sterrenbeelden[11]
    elif dag < 21:
        sterrenbeeld = sterrenbeelden[maand - 2]
    elif dag >= 21:
        sterrenbeeld = sterrenbeelden[maand - 1]
    return sterrenbeeld


def main():
    personen = []
    geboortedatum = input("Geef uw geboortedatum in: ")
    while geboortedatum != "/":
        naam = input("Geef uw naam: ").upper()
        voornaam = input("Geef uw voornaam: ")[:1]
        voornaam = (voornaam + ".")
        sterrenbeeld = sterrenbeelden_functie(geboortedatum)
        personen.append([voornaam, naam, sterrenbeeld])
        print()
        geboortedatum = input("Geef uw geboortedatum in: ")
    print()

    for persoon in personen:
        voornaam = persoon[0]
        naam = persoon[1]
        sterrenbeeld = persoon[2]
        print(voornaam, naam, sterrenbeeld)


if __name__ == "__main__":
    main()
