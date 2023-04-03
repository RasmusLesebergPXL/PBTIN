teller = 1
lst = []
man_count = 0
vrouw_count = 0
while teller > 0:
    personeelsnummer = int(input("Geef het personeelsnummer: "))
    if personeelsnummer != 0:
        geslacht = int(input("Geef het geschlacht, 0 voor vrouw, 1 voor man:"))
        if geslacht != 0 and geslacht != 1:
            geslacht = int(input("Geef de juiste gelachtscode: "))
            leeftijd = int(input("Geef de leeftijd:"))
            loon = int(input("Geef de bruttoloon van die persoon:"))
            lst.append((personeelsnummer, geslacht, leeftijd, loon))
            if geslacht == 1 and (leeftijd > 34 or loon > 1800):
                man_count += 1
            if geslacht == 0 and leeftijd < 25:
                vrouw_count += 1
        else:
            leeftijd = int(input("Geef de leeftijd:"))
            loon = int(input("Geef de bruttoloon van die persoon:"))
            lst.append((personeelsnummer, geslacht, leeftijd, loon))
            if geslacht == 1 and (leeftijd > 34 or loon > 1800):
                man_count += 1
            if geslacht == 0 and leeftijd < 25:
                vrouw_count += 1
    else:
        teller = 0

print(lst)

if man_count > 0:
    print("Het aantal mannelijke personen die ouder zijn dan 34 jaar, "
          "of een loon hebben van 1800 euro of meer bedraagt {0} personen " .format(man_count))
else:
    print("Er bestaan geen mannelijke personen die ouder zijn dan 34 jaar, "
          "of een loon hebben van 1800 euro of meer")

if vrouw_count > 0:
    print("Het aantal vrouwelijke personen die onder de 25 zijn bedraagt {0} personen".format(vrouw_count))
else:
    print("Er bestaan geen vrouwelijke personen die jonger zijn dan 25 jaar")
