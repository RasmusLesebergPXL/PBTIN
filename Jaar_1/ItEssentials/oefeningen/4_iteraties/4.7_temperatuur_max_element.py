teller = 0
lst = []
while teller < 10:
    temperatuur = int(input("Geef de temperatuur van dag "+str(teller+1)+":"))
    teller += 1
    lst.append(temperatuur)

max_temp = max(lst)
def average(lst):
    return sum(lst)/len(lst)

print("De max temperatuur uit de 10 dagen bedraagt: ",max_temp,"*C,en het gemiddelde valt op: ", average(lst), "*C")
