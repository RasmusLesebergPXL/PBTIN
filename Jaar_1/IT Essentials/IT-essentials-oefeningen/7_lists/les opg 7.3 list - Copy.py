def main():
    getal = int(input("Geef een getal:"))
    lijst = []
    while getal != 0:
        if getal not in lijst:
            lijst.append(getal)
        else:
            print("Het getal", getal, "staat op index", lijst.index(getal))
            lijst.remove(getal)
        getal = int(input("Geef een getal: "))
    print(lijst)

if __name__ == '__main__':
    main()