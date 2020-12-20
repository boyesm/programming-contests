file = open("DATA21.txt", "r")
# input = file.readline()

import math
# find each combination of L

numberofVertexes = int(file.readline())
allVertexes =[]
for everyVertex in range(numberofVertexes):
    input = file.readline().split(" ")
    sortedInput=[]
    for i in input:
        sortedInput.append(str(int(i)))

    vertex = str(sortedInput[0] + "-" + sortedInput[1])
    allVertexes.append(vertex)


allCombinationsL=[]
for i in allVertexes:
    #find all possible combinations for L:
    for each in allVertexes:
        if i != each:
            allCombinationsL.append(i+ "-" + each)



counter = 0

for each in allCombinationsL:
    L = each.split("-")
    LstartX = int(L[0])
    LstartY = int(L[1])
    LendX = int(L[0])
    LendY = int(L[1])

    hypotenuseList=[]
    for every in allVertexes:
        sortedEvery = every.split("-")
        cX = int(sortedEvery[0])
        cY = int(sortedEvery[1])

        hypotenuse1 = (cX-LstartX)**2 + (cY-LstartY)**2
        hypotenuse1 = hypotenuse1
        hypotenuse2 = (LendX-cX)**2 + (LendY-cY)**2
        hypotenuse2 = hypotenuse2
        hypotenuseOut = str(hypotenuse1) + "-" + str(hypotenuse2)
        hypotenuseList.append(hypotenuseOut)
    # print(hypotenuseList)
    hypotenuseList.sort()


print(hypotuse)