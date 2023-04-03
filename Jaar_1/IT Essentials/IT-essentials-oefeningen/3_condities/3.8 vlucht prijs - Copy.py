lengte = int(input("Geef de lengte van de vlucht: "))
soort = int(input("Geef de soort vlucht: "))

if lengte<1000:
    prijs = lengte*0.25
elif lengte<2999:
    prijs = lengte*0.20
else:
    prijs = lengte*0.12

if soort==1:
    prijs=prijs
elif soort==2:
    prijs=(prijs)-(prijs*0.20)
else:
    prijs=(prijs)+(prijs*0.30)

print("De prijs van uw vlucht is: " ,prijs, "euro")


