''' Problem 1 '''

# Recursive, but no accumulator
def list_length1(L):
    if L:
        return 1 + list_length1(L[1:])
    return 0

# Tail-recursive with accumulator
def list_length2(L):
    return list_length2_helper(L)

def list_length2_helper(L, n=0):
    if L:
        return list_length2_helper(L[1:], n+1)
    return n

# Iteration
def list_length3(L):
    n = 0
    for i in L:
        n += 1
    return n

''' Problem 2 '''

# Recursive, but no accumulator
def count_vowels1(S): 
    if not S:
        return 0

    vowels = "aeiouAEIOU"

    if S[0] not in vowels:
        return count_vowels1(S[1:])

    return 1 + count_vowels1(S[1:])

# Tail-recursive with accumulator
def count_vowels2(S):
    return count_vowels_helper(S)

def count_vowels2_helper(S, n=0):
    if not S:
        return n

    vowels = "aeiouAEIOU"

    if S[0] not in vowels:
        return count_vowels_helper(S[1:], n)

    return count_vowels_helper(S[1:], n+1)


# Iteration
def count_vowels3(S):
    vowels = "aeiouAEIOU"
    n = 0
    for c in S:
        if c in vowels:
            n += 1
    return n

''' Problem 3 '''

def binary_strings(n):
    return binary_strings_helper(n)

def binary_strings_helper(n, prefix=""):
    if n == 0:
        return [prefix]
    else:
        results = []
        if prefix == "" or prefix[-1] == "1":
            results.extend(binary_strings_helper(n - 1, prefix + "0"))
        results.extend(binary_strings_helper(n - 1, prefix + "1"))
        return results

''' Problem 4 '''

def binary_strings_hw(n, c):
    return binary_strings_hw_helper(n, c)


def binary_strings_hw_helper(n, c, prefix = "", hw_so_far=0):
    if n == 0 and hw_so_far <= c:
        return [prefix]
    else:
        results = []
        if hw_so_far < c:
            results.extend(binary_strings_hw_helper(n - 1, c, prefix + "1", hw_so_far + 1))
        results.extend(binary_strings_hw_helper(n - 1, c, prefix + "0", hw_so_far))
        return results