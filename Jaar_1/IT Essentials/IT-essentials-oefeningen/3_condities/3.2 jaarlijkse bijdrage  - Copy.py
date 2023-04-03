brutto = float(input("Geef de bruttoloon in:"))
vakantie = brutto*0.05
if (vakantie>350):
    print("jaarlijkse bijdrage bedraagt", 350*0.08)
else:
    print("jaarlijkse bijdrage bedraagt", vakantie*0.08)

print("Uw bruttoloon is:", brutto, "euro")
print("Uw vakantiegeld bedraagt", vakantie, "euro")
