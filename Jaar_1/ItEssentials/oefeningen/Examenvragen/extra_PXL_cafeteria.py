import random


def maaltijd_selectie(gerechten):
    gerecht = random.choice(gerechten)
    gerechten.remove(gerecht)
    return gerecht


def maaltijd_score(gerecht):
    if gerecht[0:3] == "veg" or gerecht[-4:-1] == "veg":
        return 0
    else:
        score_gerecht = 1000
        for letter in gerecht:
            if letter in ["f", "r", "i", "e", "t"]:
                score_gerecht += 100
            score_gerecht -= 3
        eerste = ord(gerecht[0].upper()) * 3
        laatste = ord(gerecht[-1].lower()) * 2
        if eerste > laatste:
            score_gerecht += 300
        score_gerecht = round(score_gerecht / 100, 1)
        return score_gerecht


def label(score):
    if score == 0:
        return "groen label"
    elif 0 < score < 13:
        return "oranje label"
    elif score > 13:
        return "rood label"


def main():
    gerechten = ["videe", "goulash", "vegetarische pasta", "pizza", "steak-friet", "tajine(veg)", "penne al forno",
                 "burger", "moussaka"]
    print()
    print("PXL Cafeteria Weekmenu \n")
    for dag in range(1, 6):
        gerecht = maaltijd_selectie(gerechten)
        score = maaltijd_score(gerecht)
        kleur = label(score)
        if score == 0:
            print("dag", dag, gerecht, "-->", kleur)
        else:
            print("dag", dag, gerecht, "-->", kleur, "(score = ", score, ")")


if __name__ == "__main__":
    main()
