import collections

user_antworden = ["A", "B", "C", "D", "E", "F", "G", "H", "I"]
juiste_antwoorden = ["A", "B", "C", "D", "E", "F", "G", "H", "I"]
if collections.Counter(user_antworden) == collections.Counter(juiste_antwoorden):
    print("The lists l1 and l2 are the same")
else:
    print("The lists l1 and l2 are not the same")
