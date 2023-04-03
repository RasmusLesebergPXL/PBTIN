def verander(tekst):
    resultaat = ""
    eerste_letter = tekst[0].lower()
    index = 1
    while index < len(tekst):
        if tekst[index].lower() == eerste_letter:
            resultaat += '$'
        else:
            resultaat += tekst[index]
        index += 1
    return resultaat

def main():
    print(verander("abracADaBra"))


if __name__ == '__main__':
    main()