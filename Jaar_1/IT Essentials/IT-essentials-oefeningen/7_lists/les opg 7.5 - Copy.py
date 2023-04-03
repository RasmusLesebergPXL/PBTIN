def voorkomens(elementen, element):
    aantal_voorkomens = elementen.count(element)
    print("Aantal keer: ", aantal_voorkomens)
    index = -1
    for i in range(aantal_voorkomens):
        index = elementen.index(element, index +1)
        print("Index:", index)


def main():
    lijst = [23, 45, 45, 87, 23, 75]
    element = 45
    voorkomens(lijst, element)
    print(lijst)


if __name__ == '__main__':
    main()