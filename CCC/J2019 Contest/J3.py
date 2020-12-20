n = int(input())

for x in range(n):
    numofchar = 0
    line = input()
    # if len(line) == 1:
    #     finalstr = "1 " + str(line)
    # else:
    finalstr = ""
    x = 0
    y = 1
    while (x < len(line)):
        if line[x] == line[y]:
            numofchar += 1
        else:
            finalstr += (str(numofchar) + " " + str(line[x]) + " ")
            numofchar = 0
            print(finalstr)
        x += 1
        y += 1
