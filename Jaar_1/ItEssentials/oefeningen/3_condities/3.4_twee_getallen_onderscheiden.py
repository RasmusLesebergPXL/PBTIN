x = int(input("Geef een getal: "))
y = int(input("Geef een tweede getal: "))
if y<x:
    print("Het kleinste getal is: ",y)
    print("Het kwadraat van het kleinste getal is: ", y**2)
    print("Het grootste getal gedeeld door het kleinste getal is: ",x/y)
else:
    print("Het kleinste getal is:",x)
    print("Het kwadraat van het kleinste getal is: ", x**2)
    print("Het grootste getal gedeeld door het kleinste getal is: ", y/x)


