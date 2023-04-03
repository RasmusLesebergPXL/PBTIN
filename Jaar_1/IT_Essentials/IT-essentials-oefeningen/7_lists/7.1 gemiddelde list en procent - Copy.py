def main():
    lst = []
    teller = 1
    for i in range(0, 15):
        getal = float(input("" + str(teller) + ". Geef een getal: "))
        lst.append(getal)
        teller += 1
    gemiddelde = round(sum(lst) / len(lst), 1)
    nieuwe_lst = []
    for getallen in lst:
        if getallen < gemiddelde:
            nieuwe_lst.append(getallen)
    percentage = len(nieuwe_lst) / len(lst) * 100
    print("het gemiddelde is :", gemiddelde)
    print("de hoeveelheid aan elementen die kleiner zijn dan het gemiddelde is: ", len(nieuwe_lst))
    print("het percentage van de elemeneten van de hoeveelheid is: ", round(percentage, 2), "%")


if __name__ == '__main__':
    main()
