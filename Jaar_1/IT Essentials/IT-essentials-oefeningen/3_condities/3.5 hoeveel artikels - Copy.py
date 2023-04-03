hoeveel = int(input("Hoeveel artikels wilt u bestellen: "))
artikel = 11.5
if (hoeveel*artikel)+((hoeveel*artikel)*0.21) >= 1000:
    print("Het totale bedrag inclusief 10% korting is: ", (((hoeveel*artikel)+((hoeveel*artikel)*0.21))-(((hoeveel*artikel)+((hoeveel*artikel)*0.21))*0.10)))
else:
    print("Het totale bedrag is: ", ((hoeveel*artikel)+((hoeveel*artikel)*0.21)))