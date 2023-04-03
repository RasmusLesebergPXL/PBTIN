leeftijd=int(input("Geef uw leeftijd in: "))
aansluiting=int(input("Geef uw aansluitingsjaar in: "))

basis = 100
huidig = 2021-aansluiting
reductie = 2.5*(huidig)


if leeftijd<21 or leeftijd>60:
    bijdrage = basis-14.5
else:
    bijdrage = basis

if aansluiting>0:
    bijdrage = (bijdrage)-(reductie)
else:
    bijdrage = basis

if bijdrage <62.5:
    bijdrage = 62.5

print("Uw bijdrage is: ",bijdrage, "euro")


