list = [15, 45, 45, 23, 87, 21, 20, 30, 40, 50, -200]
new_list = []
j = 0
for i in range(0, len(list)):
    j += list[i]
    new_list.append(j)

print(new_list)