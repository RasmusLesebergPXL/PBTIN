from random import randint


def sommen():
    for i in range(1, 6):
        teller = 1
        print("reeks ", i)
        while teller <= 5:
            a = randint(1, 20)
            b = randint(1, 20)
            if a > b:
                print(teller, ")", a, "-", b, "=")
            else:
                print(teller, ")", b, "-", a, "=")
            teller += 1
        print()


def main():
    sommen()


if __name__ == '__main__':
    main()


