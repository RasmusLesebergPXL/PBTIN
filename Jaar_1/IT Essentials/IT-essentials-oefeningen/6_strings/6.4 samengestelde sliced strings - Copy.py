tekstvariable_1 = "Dit is tekstavriable 1"
tekstvariable_2 = "Dit zou wellicht tekstvariable twee kunnen zijn"

if len(tekstvariable_1[0:3].strip()) < 4:
    tekstvariable_1 = tekstvariable_1[0:4].strip() + "*"

if len(tekstvariable_2[-4:]) < 4:
    tekstvariable_2 = tekstvariable_2[-4:].strip() + "+"

print(tekstvariable_1.upper()+ tekstvariable_2.lower())





