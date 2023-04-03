# Rasmus Leseberg - 1 TINK

def bepaal_aantal_wortels(aantal_paarden, hoogte_paarden):
    wortels = 2 * len(aantal_paarden)
    if 50 not in hoogte_paarden or 70 not in hoogte_paarden or 90 not in hoogte_paarden or 110 not in hoogte_paarden:
        wortels -= wortels * 0.2
    teller_110 = 0
    for paard in hoogte_paarden:
        if paard == 110:
            teller_110 += 1
    if teller_110 > len(hoogte_paarden) // 2:
        wortels += wortels * 0.3
    wortels = wortels // 1
    return round(wortels)


def print_aantal_wortels(wortels):
    for i in range(0, wortels):
        for j in range(0, i + 1):
            print("Wortel", end="")
        print("\r")


def main():
    aantal_paarden = []
    hoogte_paarden = []

    teller = 1
    naam = input("Geef naam paard: ")

    while teller <= 8:
        if naam in aantal_paarden and teller >= 3:
            wortels = bepaal_aantal_wortels(aantal_paarden, hoogte_paarden)
            print("het aantal wortels is: ", wortels)
            print("het aantal deelnemende paarden is: ", len(aantal_paarden))
            print_aantal_wortels(wortels)

            return 0
        else:
            aantal_paarden.append(naam)
            hoogte = int(input("Geef de hoogte die je wil springen: "))
            hoogte_2 = int(input("Ben je zeker? Geef de hoogte die je wil springen: "))
            while hoogte_2 != hoogte:
                hoogte = int(input("je hebt twee keer een andere hoogte ingegeven. Wat wil je nu precies? "))
                if hoogte != hoogte_2:
                    hoogte_2 = int(input("je hebt twee keer een andere hoogte ingegeven. Wat wil je nu precies? "))
            hoogte_paarden.append(hoogte_2)
        naam = input("Geef naam paard: ")
        teller += 1
    wortels = bepaal_aantal_wortels(aantal_paarden, hoogte_paarden)
    print("het aantal wortels is: ", wortels)
    print("het aantal deelnemende paarden is: ", len(aantal_paarden))
    print_aantal_wortels(wortels)


if __name__ == "__main__":
    main()
