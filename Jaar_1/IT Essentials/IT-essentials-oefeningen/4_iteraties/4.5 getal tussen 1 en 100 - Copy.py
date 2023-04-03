

getal = int(input("Geef een getal in tussen een en honderd: "))
while getal not in range(2, 100):
    if getal >= 100:
        print("Fout! Het getal moet kleiner zijn dan 100")
        getal = int(input("Geef een getal in tussen een en honderd: "))

    elif getal <= 1:
        print("Fout! Het getal moet groter zijn dan 1")
        getal = int(input("Geef een getal in tussen een en honderd: "))
else:
    print(getal)



