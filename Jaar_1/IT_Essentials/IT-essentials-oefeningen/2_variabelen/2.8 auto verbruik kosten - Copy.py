afgelegd = input("Geef het aantal afgelegde kilometeres in: ")
afgelegd = float(afgelegd)
verbruik = input("Geef de hoeveelheid liter die per 100km verbruikt word: ")
verbruik = float(verbruik)
prijs = input("Geef de prijs van 1l brandstof")
prijs = float(prijs)
totaal = (afgelegd/100)*verbruik*prijs
km = afgelegd/totaal
print("De totale kosten voor het opgegeven aantaal km is:", round(totaal,2), "euro")
print("De kostprijs per km rijden is:", round(km,2), "euro")

