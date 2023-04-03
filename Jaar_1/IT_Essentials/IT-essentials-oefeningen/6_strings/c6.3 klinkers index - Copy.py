def main():
    tekst = "Dit is een lange tekst voor u"
    for letter in "aeiou":
        print("letter", letter, "komt voor op index:", end="")
        for i in range(len(tekst)):
            if tekst[i] == letter:
                print(i, end=" ")
        print()


if __name__ == '__main__':
    main()
