file = open("DATA11.txt", "r")

def findMatchingChars(string1, string2):
    matchingChars = []
    for i in range(len(string1)):
        j = 0
        while j < len(string2):
            if string1[i] == string2[j]:
                matchingChars.append(string1[i])
                j = len(string2)
            else:
                j+=1
    return matchingChars

def removeChar(string, char):
    i = string.find(char)
    string = string[0 : i] + string[i + 1 :]
    return string

# for i in range(1):
input = file.readline()
input = input.split("/")
originalVal = int(input[0])/int(input[1])
matchingNums = findMatchingChars(input[0], input[1])
i = 0
temp1 = input[0]
temp2 = input[1]
output = temp1 + "/" + temp2
while i < len(matchingNums):
    print(output)
    temp1 = removeChar(temp1, matchingNums[i])
    temp2 = removeChar(temp2, matchingNums[i])
    newVal = int(temp1)/int(temp2)
    print(str(newVal) + ", " + str(originalVal))
    if newVal == originalVal:
        output += " = " + str(temp1) + "/" + str(temp2)
    elif (len(output) > 7) and (len(temp1) == 1) and (len(temp2) == 1):
        i = len(matchingNums)
    else:
        output += " cannot be simplified by the bogus method"
print(output)
