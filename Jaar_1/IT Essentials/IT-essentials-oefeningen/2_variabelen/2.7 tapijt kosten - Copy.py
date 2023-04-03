lengte = input("Geef de lengte: ")
lengte = float(lengte)
breedte = input("Geef de breedte: ")
breedte = float(breedte)
prijs = input("Geef de prijs per m2: ")
prijs = float(prijs)
plaats = input("Geef de plaatsingskosten per m2: ")
plaats = float(plaats)
kostprijs = lengte*breedte*prijs
plkst = kostprijs*plaats
print("De kostprijs van het tapijt is", kostprijs)
print("De plaatsingskosten zijn: ", plkst)
print("de totale kosten zijn: ", (plkst + kostprijs))


