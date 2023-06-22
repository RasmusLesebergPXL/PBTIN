
def main():
    maan = float(input("pecentage van uw gewicht ten overwicht vand de aarde op de maan:")) #maan = 0.165
    jupiter = float(input("pecentage van uw gewicht ten overwicht vand de aarde op jupiter: ")) #jupiter = 2.537
    mars = float(input("pecentage van uw gewicht ten overwicht vand de aarde op mars: ")) #mars = 0.378

    persoon = float(input("Geef het gewicht van een persoon:"))
    if persoon == "stop":
        return 0
    else:
        maan_gewicht = persoon * 0.165
        jupiter_gewicht = persoon * 2.537
        mars_gewicht = persoon * 0.378
        print("Het gewicht van een persoon te opzichte van de andere planeten is: ")
        print("Aarde: ", persoon)
        print("Maan: ", maan_gewicht)
        print("Jupiter: ", jupiter_gewicht)
        print("Mars: ", mars_gewicht)
        print()


if __name__ == "__main__":
    main()




