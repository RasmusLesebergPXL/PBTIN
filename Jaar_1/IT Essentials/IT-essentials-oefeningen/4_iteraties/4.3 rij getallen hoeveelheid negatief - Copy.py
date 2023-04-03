teller = 0
som = 0
negatief_count = 0
while teller < 5:
    number = int(input("geef een getal:"))
    teller += 1
    som += number
    if(number < 0):
        negatief_count += 1
print("De som van de getallen is:",som)
if(negatief_count == 0):
    print("Er zijn geen negatieve getallen")
else:
    print("Er zijn {0} negatieve getallen".format(negatief_count))