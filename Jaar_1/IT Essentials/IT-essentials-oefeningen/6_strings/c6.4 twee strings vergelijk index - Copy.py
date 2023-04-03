def main():
    tekst_1 = input("Geef de eerste tekst:")
    tekst_2 = input("Geef de tweede tekst:")
    kortste = len(tekst_1)
    if len(tekst_2) < len(tekst_1):
        kortste = len(tekst_2)
    for i in range(kortste):
        if tekst_1[i] == tekst_2[i]:
            print(tekst_1[i], i)


if __name__ == '__main__':
    main()