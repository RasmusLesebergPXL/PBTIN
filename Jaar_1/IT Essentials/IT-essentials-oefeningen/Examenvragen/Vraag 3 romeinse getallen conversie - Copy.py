from random import randint


def reeks(letter):
    teller_som_tot_50 = 0
    teller_50_tot_70 = 0
    teller_70_tot_90 = 0
    teller_som_over_90 = 0

    for i in range(97, letter + 1):
        som = []
        nummer = randint(1, 49)
        print("Reeks ", chr(i))
        print("Het romeinse cijfer voor ", nummer, "is:", zet_om_naar_romeinse(nummer))
        som.append(nummer)
        nieuw_getal = randint(1, 49)
        while nieuw_getal >= nummer:
            print("Het romeinse cijfer voor ", nieuw_getal, "is:", zet_om_naar_romeinse(nieuw_getal))
            som.append(nieuw_getal)
            nummer = nieuw_getal
            nieuw_getal = randint(1, 49)
        if sum(som) < 50:
            teller_som_tot_50 += 1
        elif 50 < sum(som) < 70:
            teller_50_tot_70 += 1
        elif 70 < sum(som) < 90:
            teller_70_tot_90 += 1
        else:
            teller_som_over_90 += 1
        print("\n")

    print("Aantal reeksen met som onder 50 is: ", teller_som_tot_50)
    print("Aantal reeksen met som tussen 50 en 70  is: ", teller_50_tot_70)
    print("Aantal reeksen met som tussen 70 en 90 is: ", teller_70_tot_90)
    print("Aantal reeksen met som boven de 90 is: ", teller_som_over_90)


def zet_om_naar_romeinse(nummer):
    roman = ["XL", "X", "IX", "V", "IV", "I"]
    waarde = [40, 10, 9, 5, 4, 1]
    i = 0
    romeinse_waarde = ""
    while nummer > 0:
        for j in range(nummer // waarde[i]):
            romeinse_waarde += roman[i]
            nummer -= waarde[i]
        i += 1
    return romeinse_waarde


def main():
    letter = input("Geef een letter in: ").lower()
    letter = ord(letter)
    reeks(letter)


if __name__ == "__main__":
    main()
