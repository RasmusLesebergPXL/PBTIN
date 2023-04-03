def main():
    user_count = []
    code_1_lst = []
    code_2_lst = []
    code_3_lst = []
    code_4_lst = []

    getal = int(input("Geef hier de code van diegene waarop u wilt stemmen: "))
    while getal != 0:
        user_count.append(getal)
        if getal == 1:
            code_1_lst.append(getal)
        elif getal == 2:
            code_2_lst.append(getal)
        elif getal == 3:
            code_3_lst.append(getal)
        else:
            code_4_lst.append(getal)
        getal = int(input("Geef hier de code van diegene waarop u wilt stemmen: "))

    print("Stemmingen per kandidaat: ")
    print()
    print("Stemmen voor An Jannsen: ", len(code_1_lst), "het procentueel aandeel is: ", round(len(code_1_lst)/len(user_count)*100, 2))
    print("Stemmen voor Bart Vriends: ", len(code_2_lst), "het procentueel aandeel is: ", round(len(code_2_lst)/len(user_count)*100, 2))
    print("Stemmen voor Andries Michels: ", len(code_3_lst), "het procentueel aandeel is: ", round(len(code_3_lst)/len(user_count)*100, 2))
    print("Stemmen voor Inge Kaas: ", len(code_4_lst), "het procentueel aandeel is: ", round(len(code_4_lst)/len(user_count)*100, 2))


if __name__ == "__main__":
    main()