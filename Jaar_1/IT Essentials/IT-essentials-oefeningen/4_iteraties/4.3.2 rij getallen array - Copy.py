teller = 0
som = 0
lst = []
while teller < 5:
    number = int(input("Geef een getal:"))
    teller +=1
    som += number
    lst.append(number)

print(som)

for i in range(len(lst)):
    if lst[i]<0:
        print(lst[i])

