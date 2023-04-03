from datetime import datetime


def oppervlakte(hoogte, breedte):
    berekening_oppervlakte = hoogte * breedte
    return berekening_oppervlakte


def gewicht(berekening_oppervlakte):
    berekening_gewicht = berekening_oppervlakte * 11
    return berekening_gewicht


def motor(berekening_gewicht):
    if berekening_gewicht > 300:
        motor_type = "X300"
    elif berekening_gewicht < 150:
        motor_type = "A101"
    else:
        motor_type = "A105"
    return motor_type


def prijs_berekening(motor_type, berekening_oppervlakte, kleur):
    if motor_type == "X300":
        if kleur == "standaard":
            prijs = berekening_oppervlakte * 113.5 + 250.5
        else:
            prijs = berekening_oppervlakte * 113.5 + 250.5 + (berekening_oppervlakte * 113.5 * 0.1)
        return prijs

    elif motor_type == "A105":
        if kleur == "standaard":
            prijs = berekening_oppervlakte * 113.5 + 220.5
        else:
            prijs = berekening_oppervlakte * 113.5 + 220.5 + (berekening_oppervlakte * 113.5 * 0.1)
        return prijs

    else:
        if kleur == "standaard":
            prijs = berekening_oppervlakte * 113.5 + 120
        else:
            prijs = berekening_oppervlakte * 113.5 + 120 + (berekening_oppervlakte * 113.5 * 0.1)
        return prijs


def offertenummer_gen(naam, prijs):
    jaar = datetime.now().year
    jaar = str(jaar)
    prijs = str(prijs)
    naam = naam.replace(" ", "")
    omgekeerd = prijs[-1::-1]
    omgekeerd = omgekeerd[omgekeerd.find('.') + 1:]
    volleedige_str = str(jaar + "_" + naam.upper() + "_" + omgekeerd)
    print(volleedige_str)


def main():
    naam = input("Geef de naam van de verkoper: ")
    hoogte = float(input("Geef de hoogte van de garage in: "))
    while hoogte < 2 or hoogte > 6.5:
        hoogte = float(input("De hoogte is tussen 2 en 6.5 meter. Geef opnieuw in: "))
    else:
        breedte = float(input("Geef de breedte van de garage in: "))
        while breedte < 2 or breedte > 8:
            breedte = float(input("De breedte is tussen 2 en 8 meter. Geef opnieuw in: "))
        else:
            kleur = input("Geef uw kleurwens in, standaard of speciaal: ")
    berekening_oppervlakte = oppervlakte(hoogte, breedte)
    berekening_gewicht = gewicht(berekening_oppervlakte)
    motor_type = motor(berekening_gewicht)
    prijs = prijs_berekening(motor_type, berekening_oppervlakte, kleur)
    offertenummer_gen(naam, prijs)


if __name__ == '__main__':
    main()
