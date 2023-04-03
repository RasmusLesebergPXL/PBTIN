gerechten = ["videe", "goulash", "vegetarische pasta", "pizza", "steak-friet", "tajine(veg)", "penne al forno",
             "burger", "moussaka"]

for maaltijd in gerechten:
    if maaltijd[0:3] == "veg" or maaltijd[-4:-1] == "veg":
        print("groen label")
    else:
        score_gerecht = 1000
        for letter in maaltijd:
            if letter in ["f", "r", "i", "e", "t"]:
                score_gerecht += 100
            score_gerecht -= 3
        eerste = ord(maaltijd[0].upper()) * 3
        laatste = ord(maaltijd[-1].lower()) * 2
        if eerste > laatste:
            score_gerecht += 300
        score_gerecht = round(score_gerecht / 100, 1)
        print(score_gerecht)