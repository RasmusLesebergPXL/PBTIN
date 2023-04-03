from random import randint

def feedback(doel,getal):
    if getal > doel:
        print("lager")
    elif getal < doel:
        print("hoger")
    else:
        print("proficiaat, getal geraden")

def main():
    doel = randint(1, 10)
    print(doel)
    getal = int(input("Raad het getal: "))
    teller = 1
    while teller < 3:
        feedback(doel, getal)
        if getal == doel:
            return
        getal = int(input("Volgende poging: "))
        teller += 1
    print("U heeft geen pogingen meer")


if __name__ == '__main__':
    main()
