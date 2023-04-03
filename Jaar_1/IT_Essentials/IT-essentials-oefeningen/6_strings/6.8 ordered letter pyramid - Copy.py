def main():
    row = int(input("Geef de hoeveelheid aan rows: "))
    begin_letter = input("Geef het beginletter: ")
    begin_letter = ord(begin_letter)

    for i in range(0, row):
        for j in range(0, i + 1):
            if begin_letter > 90:
                begin_letter = 65
                print(chr(begin_letter), end=" ")
                begin_letter += 1
            else:
                print(chr(begin_letter), end=" ")
                begin_letter += 1
        print()


if __name__ == '__main__':
    main()
