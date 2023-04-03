import string


def berekening(volwassen, kinderen, hotelcode, sterren, kindercode):
    hotelcode = hotelcode[0:2]

    if hotelcode == "HI":
        if kindercode == "A":
            k_prijs = 0
            v_prijs = volwassen * 70
        else:
            k_prijs = kinderen * 70 * 0.5
            v_prijs = volwassen * 70
        total_prijs = v_prijs + k_prijs
        return "{:.2f}".format(v_prijs), "{:.2f}".format(k_prijs), "{:.2f}".format(total_prijs)

    elif sterren == "****" or sterren == "*****":
        if kindercode == "A" and hotelcode not in ["BR"]:
            k_prijs = 0
            v_prijs = volwassen * 60
        else:
            k_prijs = kinderen * 60 * 0.5
            v_prijs = volwassen * 60
        total_prijs = v_prijs + k_prijs
        return "{:.2f}".format(v_prijs), "{:.2f}".format(k_prijs), "{:.2f}".format(total_prijs)

    elif sterren == "***":
        if hotelcode not in ["AN", "BR"]:
            if kindercode == "A" and hotelcode not in ["BR"]:
                k_prijs = 0
                v_prijs = volwassen * 56

            else:
                k_prijs = kinderen * 56 * 0.5
                v_prijs = volwassen * 56
            total_prijs = v_prijs + k_prijs
            return "{:.2f}".format(v_prijs), "{:.2f}".format(k_prijs), "{:.2f}".format(total_prijs)
        else:
            v_prijs = volwassen * 56
            k_prijs = kinderen * 56 * 0.5
        total_prijs = v_prijs + k_prijs
        return "{:.2f}".format(v_prijs), "{:.2f}".format(k_prijs), "{:.2f}".format(total_prijs)

    elif sterren == "**" or sterren == "*":
        if kindercode == "A":
            k_prijs = 0
            v_prijs = volwassen * 48
        else:
            v_prijs = volwassen * 48
            k_prijs = kinderen * 48 * 0.5
        total_prijs = v_prijs + k_prijs
        return "{:.2f}".format(v_prijs), "{:.2f}".format(k_prijs), "{:.2f}".format(total_prijs)


def main():
    for i in range(0, 10):
        volwassen = int(input("Geef het aantal volwassenen: "))
        kinderen = int(input("Geef het aantal kinderen: "))
        hotelcode = input("Geef de hotelcode: ")
        if hotelcode == "/":
            return 0
        else:
            sterren = input("Geef het aantal sterren: ")
            kindercode = input("Indien toepasselijk, geef de kindercode: ")
            if kindercode not in string.ascii_uppercase:
                kindercode = input(
                    "De kindercode moet een hoofdletter tussen 'A' en 'Z' zijn. Geef de code opnieuw in: ")
            prijslijst = berekening(volwassen, kinderen, hotelcode, sterren, kindercode)
            prijslijst = str(prijslijst)[1:-1].replace("'", "")
            prijslijst = prijslijst.replace(",", "")
            print(hotelcode + sterren, prijslijst)


if __name__ == '__main__':
    main()
