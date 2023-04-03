from random import randint, randrange


def basisscore(naam_lst, geboorte_lst, bezoek_lst, snack_lst):
    score_lst = []
    for naam in naam_lst:
        basis_score = 0
        for letter in naam:
            if letter in ["c", "i", "n", "e", "m", "a"]:
                basis_score += ord(letter) * naam.index(letter)
        score_lst.append(basis_score)

    for item in range(len(score_lst)):
        basis_score = score_lst[item] + geboorte_lst[item]
        if bezoek_lst[item] == 1:
            basis_score = basis_score / 2
        elif bezoek_lst[item] == 2:
            basis_score = basis_score * 2
        else:
            basis_score = basis_score * 3
        if snack_lst[item] == "N" and (bezoek_lst[item] == 1 or bezoek_lst[item] == 2):
            basis_score -= 1050
        return basis_score


def aantal_tickets():
    getal = randint(1000, 9999)
    if getal < 5000:
        getal = randrange(1000, 5000, 2)
    getal = str(getal)
    while getal[-1] != "0":
        print("Het random gegenereerde getal is ", getal.replace("'", ""))
        som = 0
        for nummer in getal:
            som += int(nummer)
        return som


def main():
    naam_lst = []
    geboorte_lst = []
    bezoek_lst = []
    snack_lst = []

    naam = input("Wat is jouw naam: ")
    while naam not in ["xxx", "qqq"]:
        naam_lst.append(naam)
        geboortejaar = int(input("Wat is jouw geboortejaar: "))
        geboorte_lst.append(geboortejaar)
        bezoek = int(input("Hoe vaak per maand breng je een bezoek aan kinepolis?: "))
        bezoek_lst.append(bezoek)
        snack = input("Welke versnapering nuttig je in kinepolis: ")
        snack_lst.append(snack)
        naam = input("Wat is jouw naam: ")

    for personen in range(len(naam_lst)):
        print("Geef jouw naam in: ", naam)
        print("In welk jaar ben jij geboren: ", geboortejaar)
        print("Hoe vaak ga je naar kinepolis per maand (1=weinig, 2 = matig, 3 = veel): ", bezoek)
        print("Wat eet je bij kinepolis (P=Popcorn, C=Chips, N=Niets: ", snack)
        print(naam, ": basisscore= ", basisscore(naam_lst, geboorte_lst, bezoek_lst, snack_lst))

    score_winnaar = basisscore(naam_lst, geboorte_lst, bezoek_lst, snack_lst)
    print()
    print(": Jij hebt gewonnen!")
    print("Jouw score is: ", score_winnaar)
    tickets = aantal_tickets()
    print(", jij wint hierbij ", tickets, "filmtickets")


if __name__ == "__main__":
    main()
