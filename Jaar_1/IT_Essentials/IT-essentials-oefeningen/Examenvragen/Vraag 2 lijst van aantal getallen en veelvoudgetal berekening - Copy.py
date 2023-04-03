from random import randint


def output(veelvoud_getal, hoeveel_getallen):
    getallen_lst = []
    for getallen in range(hoeveel_getallen):
        random_getal = veelvoud_getal * randint(1, 100 // veelvoud_getal)
        getallen_lst.append(random_getal)

    if len(getallen_lst) % 2 == 0:
        print("De genererde getallen zijn: ", *getallen_lst, sep=" ")
    else:
        getallen_lst.reverse()
        print("De array in speciale afdruk: ", *getallen_lst, sep=" ")

    kleiner_dan = []
    gemid_lst = sum(getallen_lst) / len(getallen_lst)
    for getal in getallen_lst:
        if getal < gemid_lst:
            kleiner_dan.append(getal)

    print("De getallen die kleiner zijn dan het gemiddelde: ", *kleiner_dan, sep=" ")


def main():
    hoeveel_getallen = int(input("Geef het aantal getallen dat random zal berekend worden: "))
    while hoeveel_getallen < 1:
        hoeveel_getallen = int(input("Geef het aantal getallen dat random zal berekend worden: "))
    veelvoud_getal = int(input("Geef het veelvoud: "))
    while veelvoud_getal >= 10:
        veelvoud_getal = int(input("Geef het veelvoud: "))

    output(veelvoud_getal, hoeveel_getallen)


if __name__ == "__main__":
    main()
