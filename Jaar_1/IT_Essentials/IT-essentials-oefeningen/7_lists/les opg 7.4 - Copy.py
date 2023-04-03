aantal_getallen = 10

def main():
    som = 0
    getallen = []
    for i in range(aantal_getallen):
        getal = int(input("Geef een getal:"))
        getallen.append(getal)
        som += getal
    gemid = som/aantal_getallen
    print(gemid)
    aantal_kleiner_dan_gemid = 0
    for(getal) in getallen:
        if getal < gemid:
            aantal_kleiner_dan_gemid += 1
    print(aantal_kleiner_dan_gemid)


if __name__ == '__main__':
    main()