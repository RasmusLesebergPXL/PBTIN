from random import randint


def main():
    lst = []
    for i in range(0, 500):
        lst.append(randint(0, 10000))

    nieuwe_lst = []
    for getal in lst:
        if getal > 5000:
            nieuwe_lst.append(getal)

    laatste_lst = []
    if len(nieuwe_lst) > 250:
        for j in nieuwe_lst:
            if j > 8000:
                laatste_lst.append(j)
        print(laatste_lst)


if __name__ == "__main__":
    main()
