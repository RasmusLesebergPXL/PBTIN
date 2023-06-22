import math


def kostprijs(gerond_aantal_uur, aantal_personen):
    kostprijs = gerond_aantal_uur * 12.5
    personen = math.floor(aantal_personen)
    persoon = math.ceil(aantal_personen % 1)
    rest_uur = gerond_aantal_uur % 8
    print("het uiteindelijke bedrag is: ", kostprijs)
    print("het aantal personen wat zal werken is: ", math.ceil(aantal_personen))
    if gerond_aantal_uur % 8 == 0:
        print(personen, "personen gaan 8 uur lang werken")
    else:
        print(personen, "personen gaan 8 uur lang werken, en ", persoon, "persoon gaat ", rest_uur, "uur werken")


def aantal_personen(oppervlakte):
    aantal_uur = oppervlakte / 160
    gerond_aantal_uur = math.ceil(aantal_uur)
    if oppervlakte <= 160:
        aantal_personen = 1
    else:
        aantal_personen = gerond_aantal_uur / 8

    kostprijs(gerond_aantal_uur, aantal_personen)


def main():
    oppervlakte = int(input("Hoe groot is de oppervlakte: "))
    if oppervlakte == "0":
        return 0
    else:
        aantal_personen(oppervlakte)


if __name__ == '__main__':
    main()
