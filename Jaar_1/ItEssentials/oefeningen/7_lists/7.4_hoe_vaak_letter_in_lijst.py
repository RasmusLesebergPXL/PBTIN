import string


def main():
    tekst = input("Geef hier uw input: ").lower()
    for letter in string.ascii_lowercase:
        if letter in list(tekst):
            print(letter, tekst.count(letter))
        tekst = tekst.replace(letter, "")


if __name__ == "__main__":
    main()
