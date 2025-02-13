"""
on odd pass -> left to right
on even pass -> right to left [-1] vs [-2] until -len()
for i in n/2
"""

def cocktail(L):
    length = len(L)
    counter = 1
    for i in range(length):
        swapped = 0
        if counter%2 !=0:
            for i in range(length-1):
                if L[i] > L[i+1]:
                    temp = L[i]
                    L[i] = L[i+1]
                    L[i+1] = temp
                    swapped = 1
            counter += 1
        else: #even
            for i in range(length-1):
                if L[length-1-i] < L[length-2-i]:
                    temp = L[length-1-i]
                    L[length-1-i] = L[length-2-i]
                    L[length-2-i] = temp
                    swapped = 1
            counter += 1
        if not swapped:
            break
        
        print(counter,"  ",L)


L = [5,9,4,6,2,7]
cocktail(L)

def merge_sort(data, key):
    def splitting(data, key):
        length = len(data)
        if length == 1:
            return data
        else:
            half = length//2
            left = splitting(data[:half],key)
            right = splitting(data[half:],key)
            return merge(left,right,key)
    return splitting(data,key)

"""
Merges two sorted lists of dictionaries into a single sorted list.

Parameters:
left (list): The first sorted list of dictionaries.
right (list): The second sorted list of dictionaries.
key (str): The key in the dictionaries to sort by.

Returns:
list: A merged and sorted list of dictionaries.
"""
def merge(left, right, key):
    length = len(left)+ len(right)
    result =[]
    for i in range(length):
        if left[0][key] <= right[0][key]:
            result.append(left[0])
            left.pop(0)
        else:
            result.append(right[0])
            right.pop(0)
        if not left:
            result.extend(right)
            break
        elif not right:
            result.extend(left)
            break    
    return result


persons = [
    {"name": "bob", "age": 15},
    {"name": "alice", "age": 12},
    {"name": "dave", "age": 13},
    {"name": "carol", "age": 10},
]

sorted_data = merge_sort(persons, "name")
for index, person in enumerate(sorted_data):
    print(f"[{index+1}] Name: {person['name']}   \tAge: {person['age']}")

def linear(L,number):
    for i in L:
        if i == number:
            return i
        else:
            continue

def binary(L, target):
    def search(L,target,steps=1):
        middle = len(L)//2
        try:
            if target == L[middle]:
                return steps
            elif target > middle:
                return search(L[middle+1:],target,steps + 1)
            elif target < middle:
                return search(L[:middle],target, steps + 1)
        except:
            return "not found"
        
        
    return search(L, target)

def binary2(L,target,low = 0, high = None):
    if high == None:
        high = len(L) -1
    if low> high:
        return " not found"
    middle = (low + high)//2
    
    if L[middle] == target:
        return ("target found", L[middle])
    elif middle < target:
        return binary2(L,target,low = middle + 1,high = high)
    else:
        return binary2(L,target,low = 0, high = middle )


numbers = list(range(20))
print(list(numbers))
print(linear(numbers,5))
print(binary2(numbers,20))


def word(L):
    high = 0
    high_word = L[0]
    for word in L:
        score = 0
        used = []
        minus = []
        for letter in word:
            if letter in used and letter not in minus:
                score -= 1
                minus.append(letter)
            elif letter in used and letter in minus:
                continue
            else:
                score += 1
                used.append(letter)
        if score > high:
            high = score
            high_word = word
        print(score)
    return high_word


L = ["aabbccddeeffgg","qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm"]
print(word(L))