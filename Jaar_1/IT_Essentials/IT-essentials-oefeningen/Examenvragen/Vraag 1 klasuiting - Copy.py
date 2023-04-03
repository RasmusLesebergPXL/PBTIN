def voorspelling(temp_lst, regen_lst):
    teller_daguitstap = 0
    teller_overvloed = 0

    for dag in temp_lst:
        if dag < 15 or (min(temp_lst) < (sum(temp_lst) / len(temp_lst) * 0.2)):
            teller_daguitstap += 1
    for regen in regen_lst:
        if regen == "veel":
            teller_daguitstap += 1
        elif regen == "overvloed":
            teller_overvloed += 1

    if teller_overvloed > 0:
        conclusie = "We blijven thuis"
    elif teller_daguitstap > 0 and teller_overvloed == 0:
        conclusie = "daguitstap"
    else:
        conclusie = "tweedaagse"

    if "overvloed" in regen_lst:
        regen_lst.remove("overvloed")

    print("{:15s} {:15s} {:15s}".format("dag", "temperatuur", "neerslag"))
    for dag in range(len(regen_lst)):
        print("{:<15} {:<15} {:<15}".format(dag + 1, temp_lst[dag], regen_lst[dag]))
    print(conclusie)


def main():
    temp_lst = []
    regen_lst = []
    for i in range(0, 7):
        regen = input("Geef regen in: ")
        if regen == "overvloed":
            regen_lst.append(regen)
            voorspelling(temp_lst, regen_lst)
            return 0
        else:
            regen_lst.append(regen)
            temperatuur = int(input("Geef temperatuur in: "))
            temp_lst.append(temperatuur)
    voorspelling(temp_lst, regen_lst)


if __name__ == "__main__":
    main()
