file = open("DATA11.txt", "r")

def removeAllDuplicates(list):
    seen = set()
    seen_add = seen.add
    return [x for x in list if not (x in seen or seen_add(x))]

for j in range(10):
    N = file.readline()
    N = int(N)
    output = []
    for emailN in range(N):
        input = file.readline()
        email = input.split("@")
        emailUserName = email[0]
        emailDomain = email[1]
        emailDomain = emailDomain.lower()

        emailUserName = emailUserName.split("+")
        emailUserName = emailUserName[0].lower()

        i = 0
        while i < len(emailUserName):
            if emailUserName[i] == ".":
                emailUserName = emailUserName[0: i] + emailUserName[i + 1:]
            else:
                i += 1
        finalEmail = emailUserName + "@" + emailDomain
        output.append(finalEmail)

    output = removeAllDuplicates(output)
    print(len(output))
