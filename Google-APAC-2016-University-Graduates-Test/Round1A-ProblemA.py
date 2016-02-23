import sys

def googolChar(cP, revs):
    ans = ''
    if (isPowTwoOrOneOff(cP)):
        if (cP % 2 == 0 or cP == 1):
            ans = '0'
        else:
            ans = '1'
        if (revs % 2 == 1):
            if (ans == '0'):
                ans = '1'
            else:
                ans = '0'
    else:
        powDif = abs(largestPowerOf2(cP) - cP) * 2;
        ans = googolChar(cP - powDif, revs + 1);

    return ans

def isPowTwoOrOneOff(x):
    ans = (x != 0) and ((x & (x - 1)) == 0)

    if not ans:
        x += 1
        ans = (x != 0) and ((x & (x - 1)) == 0)
    return ans

def largestPowerOf2(n):
    return 2**(n.bit_length() - 1)


ans = ''
filename = input("Enter filename: ")

with open(filename, 'r') as inputFile:
    with open(filename + '_out.o', 'w') as outputFile:
        sys.stdout = outputFile
        testCaseNum = int(inputFile.readline().replace('\n',''))

        for i in range(1, testCaseNum + 1):
            charPos = int(inputFile.readline().replace('\n',''))
            ans = googolChar(charPos, 0)
            print("Case #" + str(i) + ": " + ans)

