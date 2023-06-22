def hotel_kosten(aantal_nachten):
    if aantal_nachten > 2:
        return round((aantal_nachten * 140.5 - aantal_nachten * 140.5 * 0.33), 2)
    else:
        return 140.50 * aantal_nachten


def vliegtuig_kosten(stad):

    if stad == "barcelona" or stad == "Barcelona":
        return 183
    elif stad == "rome" or stad == "Rome":
        return 220
    elif stad == "berlijn" or stad == "Berlijn":
        return 125
    else:
        return 450


def huurauto_kosten(aantal_dagen):
    prijs = aantal_dagen * 40
    if aantal_dagen > 7:
        prijs -= 50
    elif aantal_dagen > 3:
        prijs -= 20
    return prijs


def reiskosten(stad, aantal_nachten):
    aantal_dagen = aantal_nachten
    vliegtickets = vliegtuig_kosten(stad)
    hotel = hotel_kosten(aantal_nachten)
    auto = huurauto_kosten(aantal_dagen)
    totale_kosten = vliegtickets + hotel + auto
    print(round(totale_kosten, 2))


def main():
    stad = input("Naar welke stad wilt u reizen: ").lower()
    if stad not in ["barcelona", "berlijn", "oslo", "rome"]:
        print("foutmelding")
        return 0
    else:
        aantal_nachten = float(input("Geef het aantal nachten van uw bezoek: "))
        reiskosten(stad, aantal_nachten)


if __name__ == '__main__':
    main()
