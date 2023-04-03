
def controleer(getal):
    getalstr = str(getal)
    if (getalstr[1] and getalstr[3]) == (getalstr[5] and getalstr[6]):
        print("gratis")
    else:
        print("niet gratis")


def main():
    getal = int(input("Geef uw lidnummer: "))
    controleer(getal)


if __name__ == '__main__':
    main()
