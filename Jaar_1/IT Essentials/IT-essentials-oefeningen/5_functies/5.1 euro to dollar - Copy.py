def dollar(euro):
    print(euro * 1.28)


def main():

    euro = float(input("Geef de hoeveelheid euros in: "))
    while euro != 0:
        dollar(euro)
        euro = float(input("Geef de hoeveelheid euros in: "))


if __name__ == "__main__":
    main()
