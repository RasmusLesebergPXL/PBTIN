from datetime import date


def tijd_berekening(tijd):
    uur = str(tijd // 3600)
    tijd %= 3600
    minuten = str(tijd // 60)
    tijd = (uur + "u", minuten + "m")
    return tijd


def leeftijd_berekening(geboortedatum):
    geboortedag = int(geboortedatum[:2])
    geboortemaand = int(geboortedatum[3:5])
    geboortejaar = int(geboortedatum[6:])
    vandaag = date.today()
    leeftijd = vandaag.year - geboortejaar - (
            (vandaag.month, vandaag.day) < (geboortemaand, geboortedag))
    return str(leeftijd) + " jaar"


def resultaten_berekening(antworden, juist_antwoord):
    user_antworden = list(antworden)
    juist_antwoord = list(juist_antwoord)
    punten = 20
    for letter in range(len(user_antworden)):
        if user_antworden[letter] == juist_antwoord[letter]:
            punten += 2
        elif user_antworden[letter] != juist_antwoord[letter]:
            punten -= 1
    return str(punten) + " punten"


def main():
    afdruk_lijst = []

    juist_antwoord = input("Geef het antwoord: ")
    user_input = input("Geef hier het input van de persoon: ")
    while user_input != "0":
        user_input = user_input.split()
        deelnemers_nummer = user_input[0]
        geboortedatum = user_input[1]
        antworden = user_input[2]
        tijd = int(user_input[3])
        duratie = tijd_berekening(tijd)
        leeftijd = leeftijd_berekening(geboortedatum)
        resultaten = resultaten_berekening(antworden, juist_antwoord)
        afdruk_lijst.append([deelnemers_nummer, leeftijd, duratie, resultaten])
        print()
        user_input = input("Geef hier het input van de persoon: ")

    teller = 1
    for personen in afdruk_lijst:
        deelnemers_nummer = personen[0]
        leeftijd = personen[1]
        tijd = personen[2]
        punten = personen[3]
        print(teller, ". ", deelnemers_nummer, " ", leeftijd, " ", tijd, " ", punten)
        teller += 1


if __name__ == "__main__":
    main()
