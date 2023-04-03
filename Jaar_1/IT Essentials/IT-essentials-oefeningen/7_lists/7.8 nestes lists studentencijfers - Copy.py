def main():
    vak_1, vak_2, vak_3, vak_4 = [], [], [], []
    tabel = [[12, 4, 12, 9], [14, 5, 9, 11], [8, 9, 7, 12], [7, 12, 11, 10], [11, 18, 10, 14]]
    for student in tabel:
        vak_1.append(student[0])
        vak_2.append(student[1])
        vak_3.append(student[2])
        vak_4.append(student[3])
    index_min_1 = min(range(len(vak_1)), key=vak_1.__getitem__)
    index_min_2 = min(range(len(vak_2)), key=vak_2.__getitem__)
    index_min_3 = min(range(len(vak_3)), key=vak_3.__getitem__)
    index_min_4 = min(range(len(vak_4)), key=vak_4.__getitem__)

    print("Het laagst behaalde cijfer voor vak", 1, "was: ", min(vak_1), "en het gemiddelde was: ",
          round(sum(vak_1) / len(vak_1), 1))
    print("Het laagst behaalde cijfer voor vak", 2, "was: ", min(vak_2), "en het gemiddelde was: ",
          round(sum(vak_2) / len(vak_2), 1))
    print("Het laagst behaalde cijfer voor vak", 3, "was: ", min(vak_3), "en het gemiddelde was: ",
          round(sum(vak_3) / len(vak_3), 1))
    print("Het laagst behaalde cijfer voor vak", 4, "was: ", min(vak_4), "en het gemiddelde was: ",
          round(sum(vak_4) / len(vak_4), 1))
    print("laagst behaalde cijfer in vak 1 was van stud", index_min_1 + 1)
    print("laagst behaalde cijfer in vak 1 was van stud", index_min_2 + 1)
    print("laagst behaalde cijfer in vak 1 was van stud", index_min_3 + 1)
    print("laagst behaalde cijfer in vak 1 was van stud", index_min_4 + 1)


if __name__ == "__main__":
    main()
