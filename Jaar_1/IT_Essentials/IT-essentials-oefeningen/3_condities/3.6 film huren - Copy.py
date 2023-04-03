jaar = int(input("Geef het jaar van de film in: "))
rating = int(input("Geef de rating van de film tussen 1 en 5: "))
basisprijs = 5
if 2019<jaar<2021:
    basisprijs=basisprijs+1
    if (rating==3 or rating==2):
        basisprijs=basisprijs+1
    elif(rating==4 or rating ==5):
        basisprijs=basisprijs+1
if jaar<2019:
    basisprijs = basisprijs
    if (rating==3 or rating==2):
        basisprijs=basisprijs+1
    elif(rating==4 or rating ==5):
        basisprijs=basisprijs+2
        
print("Het bedrag is:",basisprijs)

