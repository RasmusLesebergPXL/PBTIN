uur_vertrek = int(input("Geef het vertrekuur:"))
minuut_vertrek = int(input("Geef het vertrekminuut:"))
duur = int(input("Geef de duur van de vlucht:"))

uur = int(duur/60)
duur = duur - uur * 60
minuut = duur

aankomst_uur = uur_vertrek + uur
aankomst_minuut = minuut_vertrek + minuut

if aankomst_uur==24:
    aankomst_uur = 0

elif aankomst_uur > 24:
    aankomst_uur = aankomst_uur - 24

if aankomst_minuut >= 60 or (aankomst_minuut + minuut) >= 60:
    aankomst_uur = aankomst_uur + 1

if aankomst_minuut ==60:
    aankomst_minuut = 0

print("Uw aankomst tijd is: ", aankomst_uur,"uur",  aankomst_minuut, "minuten")
