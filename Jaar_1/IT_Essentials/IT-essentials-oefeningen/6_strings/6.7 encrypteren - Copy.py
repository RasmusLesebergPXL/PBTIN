from random import randrange, randint


def encrypt(ascii_values):
    new_lst = []
    for i in ascii_values:
        if i > 127:
            i = randint(32, 127)
            new_lst.append(i)
        else:
            new_lst.append(i)
    for element in new_lst:
        print(chr(element), end="")


def main():
    tekst = input("Geef hier uw tekst: ")
    ascii_values = []
    for letters in tekst:
        ascii_values.append(ord(letters) + randrange(2, 24, 2))

    encrypt(ascii_values)


if __name__ == '__main__':
    main()
