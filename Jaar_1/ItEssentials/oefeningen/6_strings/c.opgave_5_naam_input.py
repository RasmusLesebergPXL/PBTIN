def main():
    voornaam = "rAsmus"
    achternaam = "lEsEbErg"
    naam = voornaam[0].upper() +". " + achternaam[0].upper() + achternaam[1:].lower()
    print(naam)


if __name__ == '__main__':
    main()