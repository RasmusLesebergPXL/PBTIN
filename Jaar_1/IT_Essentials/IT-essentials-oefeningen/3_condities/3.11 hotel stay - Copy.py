sterren = (input("Geef het aantal sterren: "))
code = str(input("Geef de code voor uw verblijf: (Keuze tussen O,H,V,A)"))
overnachtingen= int(input("Geef het aantal overnachtingen: "))
seizoen = str(input("Binnen welk seizoen zal uw verblijf plaatsvinden? Keuze tussen (H, L, T)"))

if sterren==1:
    prijs = overnachtingen*30
elif sterren==2 or sterren ==3:
    prijs = overnachtingen*40
else:
    prijs = overnachtingen*55

if code=='O':
    maaltijd = prijs*0.2
elif code=='H':
    maaltijd = prijs*0.5
elif code=='V':
    maaltijd = prijs*0.6
else:
    maaltijd = (prijs*0.6)+80

if (code=='O' or code=='H') and seizoen=='L':
    reductie = prijs*0.10

else:
    reductie=0

print("Het bedrag wat u gaat betalen is: ", prijs+maaltijd-reductie, "euro")

