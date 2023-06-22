def output(S_lijst, S_lijst_vooraad, A_lijst, A_lijst_vooraad):
    A_lijst_str = []
    for getal in A_lijst_vooraad:
        str_getal = str(getal)
        A_lijst_str.append(str_getal)

    S_lijst_str = []
    for getal in S_lijst_vooraad:
        str_S_lijst = str(getal)
        S_lijst_str.append(str_S_lijst)

    print()
    print("Lijst van de bij te bestellen producten")
    for item in range(len(S_lijst)):
        print(S_lijst[item], "te bestellen: ", S_lijst_vooraad[item])
    print()

    print("Lijst van de actie artikelen")
    for item in range(len(A_lijst)):
        print(A_lijst[item] + A_lijst_str[item])


def main():
    A_lijst = []
    A_lijst_vooraad = []
    S_lijst = []
    S_lijst_vooraad = []

    S_kaft = int(input("geef het aantal artikels in voorraad van het artikel S-kaftE34-5-100: "))
    if S_kaft < 100:
        S_lijst.append("S-kaftE34-5")
        S_lijst_vooraad.append(-(S_kaft - 100))

    S_DVD = int(input("geef het aantal artikels in voorraad van het artikel S-DVD345-1-124: "))
    if S_DVD < 124:
        S_lijst.append("S-DVD345-1-124")
        S_lijst_vooraad.append(-(S_DVD - 124))

    A_pen = int(input("geef het aantal artikels in voorraad van het artikel A-penD34-125: "))
    while A_pen > 125:
        print("Foute ingave! Zo veel artikels kunnen niet in vooraad zijn")
        A_pen = int(input("Opnieuw: geef het aantal artikels in voorraad van het artikel A-penD34-125: "))
    if A_pen > 0:
        A_lijst.append("A-penD34-")
        A_lijst_vooraad.append(A_pen)

    S_boek = int(input("geef het aantal artikels in voorraad van het artikel S-boekX33-3-256: "))
    if S_boek < 256:
        S_lijst.append("S-boekX33-3-256")
        S_lijst_vooraad.append(-(S_boek - 256))

    A_bal = int(input("geef het aantal artikels in voorraad van het artikel A-bal34-145: "))
    while A_bal > 145:
        print("Foute ingave! Zo veel artikels kunnen niet in vooraad zijn")
        A_bal = int(input("Opnieuw: geef het aantal artikels in voorraad van het artikel A-bal34-145: "))
    if A_bal > 0:
        A_lijst.append("A-bal34-")
        A_lijst_vooraad.append(A_bal)

    S_boekZ = int(input("geef het aantal artikels in voorraad van het artikel S-boekZ34-2-26: "))
    if S_boekZ < 26:
        S_lijst.append("S-boekZ34-2-26")
        S_lijst_vooraad.append(-(S_boekZ - 26))

    A_ballon = int(input("geef het aantal artikels in voorraad van het artikel A-ballon34-15: "))
    while A_ballon > 15:
        print("Foute ingave! Zo veel artikels kunnen niet in vooraad zijn")
        A_ballon = int(input("Opnieuw: geef het aantal artikels in voorraad van het artikel A-ballon34-15: "))
    if A_ballon > 0:
        A_lijst.append("A-ballon34-")
        A_lijst_vooraad.append(A_ballon)

    output(S_lijst, S_lijst_vooraad, A_lijst, A_lijst_vooraad)


if __name__ == "__main__":
    main()
