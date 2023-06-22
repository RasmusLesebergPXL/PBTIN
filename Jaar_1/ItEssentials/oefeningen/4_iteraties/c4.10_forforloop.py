for i in range(2):
    print("De buitenste loop begint met i =", i)
    for j in range(2):
        print("De binnenste loop begint met j =", j)
        print("(i,j) = (" + str(i) + "," + str(j) + ")")
        print("De binnenste loop eindigt met j =", j)
    print("De buitenste loop eindigt met i =", i )