def verander(tekst, aantal):
    resultaat = tekst[0]
    eerste_letter = tekst[0].lower()
    index = 1
    aantal_vervangen = 0
    while index < len(tekst):
        if tekst[index].lower() == eerste_letter and aantal_vervangen < aantal:
            resultaat += '$'
            aantal_vervangen += 1
        else:
            resultaat += tekst[index]
        index += 1
    return resultaat

def main():
    tekst = input("Geef uw tekst: ").strip()
    while tekst != "":
        getal = int(input("Geef een aantal: "))
        print(verander(tekst, getal))
        tekst = input("Geef uw tekst: ").strip()


if __name__ == '__main__':
    main()