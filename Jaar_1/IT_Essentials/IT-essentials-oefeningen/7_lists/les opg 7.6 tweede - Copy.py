from random import randint

def cum_sum(lijst):
    for i in range(len(lijst)-1):
        lijst[i + 1] = lijst[i] + lijst[i +1]

def main():
    lijst = []
    for i in range(10):
        lijst.append(randint(1,10))
    print(lijst)
    cum_sum(lijst)
    print(lijst)



if __name__ == '__main__':
    main()