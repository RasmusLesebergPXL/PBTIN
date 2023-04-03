totaal = 0
teller = 0

while teller < 5:
    totaal += int(input("Geef nummer " + str(teller + 1) + ":"))
    teller += 1

print("Totaal is", totaal)
print("gemiddelde is", totaal / teller)