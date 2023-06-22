def main():
    bijbestellen_small = []
    bijbestellen_medium = []
    bijbestellen_large = []

    T_shirts = [[45, 102, 19, 55, 0], [79, 47, 58, 22, 46], [109, 33, 112, 0, 0]]
    totaal_small = sum(T_shirts[0]) * 0.3
    totaal_medium = sum(T_shirts[1]) * 0.3
    totaal_large = sum(T_shirts[2]) * 0.3

    for kleur in T_shirts[0]:
        if kleur < totaal_small:
            bijbestellen_small.append(kleur)
    for kleur in T_shirts[1]:
        if kleur < totaal_medium:
            bijbestellen_medium.append(kleur)
    for kleur in T_shirts[2]:
        if kleur < totaal_large:
            bijbestellen_large.append(kleur)
    str_small = [str(a) for a in bijbestellen_small]
    str_medium = [str(a) for a in bijbestellen_medium]
    str_large = [str(a) for a in bijbestellen_large]

    print("De maten die bijbesteld moeten worden van de maat small zijn: ",', '.join(str_small))
    print("De maten die bijbesteld moeten worden van de maat medium zijn: ", ', '.join(str_medium))
    print("De maten die bijbesteld moeten worden van de maat large zijn: ", ', '.join(str_large))


if __name__ == "__main__":
    main()
