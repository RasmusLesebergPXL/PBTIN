def schikkeljaar():
    print(True)


teller = 1
while teller > 0:
    jaar = int(input("Geef aan welk jaar u wilt proeven:"))
    if jaar % 4 == 0 or jaar % 400 == 0:
        schikkeljaar()
    else:
        print(False)
