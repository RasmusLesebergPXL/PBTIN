teller = 1

while teller > 0:
    artikelnummer = int(input("Geef het artikelnummer in: "))
    if artikelnummer != 999:
        hoeveel = int(input("Geef de hoeveelheid aan: "))
        prijs = float(input("Geef de eenheidsprijs aan: "))
        print("De gegevens per artikel zijn: ")
        bedrag = hoeveel * prijs
        print("Artikelnummer: ", artikelnummer, "hoeveelheid :", hoeveel,
              "prijs per item: ", prijs)
        print("totaal bedrag: ", bedrag, "euro", "\n")
    else:
        teller = 0
