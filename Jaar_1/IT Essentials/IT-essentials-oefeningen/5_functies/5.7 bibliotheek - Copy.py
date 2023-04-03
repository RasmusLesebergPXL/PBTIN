lst = []


def boete(aantal_dagen, aantal_boeken):
    if aantal_dagen >= 45:
        boete = aantal_dagen * (aantal_boeken * 0.07) + 0.84
        lst.append(boete)
    else:
        boete = aantal_dagen * (aantal_boeken * 0.07)
    print("De boete bedraagt: ", round(boete, 2))


def main():
    for i in range(1, 10):
        naam = input("Wat is de naam van de persoon: ")
        if naam == "xx":
            return 0
        else:
            aantal_boeken = int(input("Wat is het aantal boeken wat te laat is: "))
            aantal_dagen = int(input("Hoeveel dagen zijn deze boeken te laat: "))
            boete(aantal_dagen, aantal_boeken)
            print(len(lst))
            print("\r")


if __name__ == '__main__':
    main()
