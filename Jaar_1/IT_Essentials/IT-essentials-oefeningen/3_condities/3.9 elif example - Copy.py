a=int(input("Geef een getal: "))
b=int(input("Geef nog een getal: "))
code=int(input("Geef de bewerkingscode: "))

if code==1:
    totaal= a+b
elif code==2:
    totaal= a-b
elif code==3:
    totaal=a*b
elif code==4:
    totaal=a**2
elif code==5:
    totaal=b**2
else:
    totaal=("Foutieve code")

print("Het getal a is:",a,"Het getal b is: ", b, "Het totaal is: ", totaal)