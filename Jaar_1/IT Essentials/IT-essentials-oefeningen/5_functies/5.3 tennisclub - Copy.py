def tennis(leeftijd, kinderen, jaar, inkomen):
    aanvang = 100
    if leeftijd > 65:
        prijs = aanvang - 15
    else:
        prijs = aanvang
    if 0 < kinderen < 5:
        prijs = prijs - (kinderen * 7.5)
    elif kinderen >= 5:
        prijs = prijs - 35
    if jaar > 20:
        prijs = prijs - 12.5
    if inkomen <= 7500:
        prijs = prijs - 12.5
    if prijs < 50:
        prijs = 50
    return prijs


def main():
    naam = str(input("Geef uw naam: "))
    while naam != "X" and naam != "x":
        leeftijd = int(input("Geef uw leeftijd: "))
        kinderen = int(input("Geef het aantal kinderen ten laste: "))
        inkomen = float(input("Geef uw inkomen: "))
        aansluitingsjaar = int(input("Geef uw aansluitingsjaar: "))
        jaar = 2021 - aansluitingsjaar
        print("De naam van het lid is: ", naam, ", en het bedrag wat betaalt moet worden is gelijk aan: ",
              tennis(leeftijd, kinderen, jaar, inkomen), "euro")
        print()

        naam = str(input("Geef uw naam: "))


if __name__ == "__main__":
    main()
