bedrag = int(input("Geef een bedrag in centen in:"))
twee_euro = int(bedrag/200)
bedrag = bedrag - twee_euro * 200
een_euro = int(bedrag/100)
bedrag = bedrag - een_euro * 100
vijftig_cent = int(bedrag/50)
bedrag = bedrag - vijftig_cent * 50
twintig_cent = int(bedrag/20)
bedrag = bedrag - twintig_cent *20
tien_cent = int(bedrag/10)
bedrag = bedrag - tien_cent * 10
vijf_cent = int(bedrag/5)
bedrag = bedrag - vijf_cent * 5
twee_cent = int(bedrag/2)
bedrag = bedrag - twee_cent * 2
een_cent = int(bedrag/1)

print(twee_euro, "* 2 euro", een_euro, "* 1 euro", vijftig_cent, "* 50 cent", twintig_cent, "* 20 cent", tien_cent, "* 10 cent", vijf_cent, "* 5 cent", twee_cent, "* 2 cent", een_cent, "* 1 cent")
