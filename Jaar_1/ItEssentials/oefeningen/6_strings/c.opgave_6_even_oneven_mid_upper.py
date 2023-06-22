def main():
    woord = str(input("Geef een woord in: "))
    index1 = len(woord) // 2
    if len(woord) % 2 == 0:
        resultaat = woord[:index1] + woord[index1:index1 + 1].upper() + woord[index1 + 1:]
    else:
        resultaat = woord[:index1] + woord[index1].upper() + woord[index1 + 1:]
    print(resultaat)


if __name__ == '__main__':
    main()
