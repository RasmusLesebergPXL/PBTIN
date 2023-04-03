
def main():
    som = 0
    for i in range(0, 5):
        c = input("Geef hier uw input: ")
        if 65 <= ord(c) <= 90:
            print("hoofdletter")
        elif 48 <= ord(c) <= 57:
             som += ord(c)
        elif 97 <= ord(c) <= 122:
            print("kleine letter")
        else:
            print("onbekend")
    print("uiteindelijke som van ord's: ", som)

if __name__ == '__main__':
    main()
