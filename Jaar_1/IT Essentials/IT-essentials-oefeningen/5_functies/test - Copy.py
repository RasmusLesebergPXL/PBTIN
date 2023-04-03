from random import randrange, randint

text = input("enter a string to convert into ascii values:")
ascii_values = []
for character in text:
    ascii_values.append(ord(character) + randrange(2,24,2))

print(ascii_values)