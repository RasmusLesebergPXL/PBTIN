def tekst_find(tekst):
    eerste_t = tekst.find('t')
    eerste_T = tekst.find('T')
    if eerste_t != -1 and eerste_T != -1:
        if eerste_t > eerste_T:
            return eerste_T
        else:
            return eerste_t
    elif eerste_t == -1 or eerste_T == -1:
        if eerste_t == -1:
            return eerste_T
        elif eerste_T == -1:
            return eerste_t


def main():
    tekst = input("Geef hier een tekst in: ")
    resultaat = tekst_find(tekst)
    if len(tekst) % 2 == 0 and resultaat != -1:
        print(tekst[resultaat + 1:].lower())
    elif len(tekst) % 2 != 0 and resultaat != -1:
        print(tekst[resultaat + 1:].upper())
    else:
        print("Deze string bevat geen 't'of 'T'")


if __name__ == '__main__':
    main()
