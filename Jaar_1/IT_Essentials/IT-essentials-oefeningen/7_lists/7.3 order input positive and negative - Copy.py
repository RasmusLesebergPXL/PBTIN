def main():
    teller = 1
    neg_lst = []
    pos_lst = []
    for i in range(0,10):
        getal = float(input("" + str(teller) + ". Geef een getal: "))
        teller += 1
        if getal < 0:
            neg_lst.append(getal)
        else:
            pos_lst.append(getal)
    print(len(pos_lst), len(neg_lst))
    print(pos_lst)
    print(neg_lst)


if __name__ == "__main__":
    main()