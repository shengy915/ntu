class ListNode:
    def __init__(self, num):
        self.num = num
        self.next = None

def printList(head):
    cur = head
    while cur is not None:
        print(cur.num, end=" ")
        cur = cur.next
    print()

def findNode(head, index):
    if head is None or index < 0:
        return None
    cur = head
    while index > 0:
        cur = cur.next
        if cur is None:
            return None
        index -= 1
    return cur

def insertNode(ptrHead, index, value):
    newNode = ListNode(value)
    if ptrHead is None:
        return newNode
    if index == 0:
        newNode.next = ptrHead
        return newNode
    
    cur = ptrHead
    prev = None
    count = 0
    while cur is not None and count < index:
        prev = cur
        cur = cur.next
        count += 1
    if prev is not None:
        prev.next = newNode
        newNode.next = cur
    return ptrHead

def deleteList(ptrHead):
    cur = ptrHead
    while cur is not None:
        temp = cur.next
        cur.next = None  
        cur = temp
    return None

def split(head, EvenList, OddList):
    # write your code here #
    
    cur = head
    ptrEvenList = None
    ptrOddList = None
    
    while cur != None:
        if cur.num%2 == 0:
            EvenList.append(cur.num)
        else:
            OddList.append(cur.num)
        
        cur = cur.next
    print(OddList)
    print(EvenList)
    index = 0
    for i in EvenList:
        try:
            ptrEvenList = insertNode(ptrEvenList, index, i)
            print(f"Successfully inserted {i} at index {index}")
            index += 1
        except ValueError:
            pass

    index = 0
    for i in OddList:
        try:
            ptrOddList = insertNode(ptrOddList, index, i)
            print(f"Successfully inserted {i} at index {index}")
            index += 1
        except ValueError:
            pass
    return head,ptrEvenList,ptrOddList



if __name__ == "__main__":
    head = None
    oddHead = []
    evenHead = []
    index = 0
    
    print("Enter one number per line (press Enter after each number).")
    print("Enter any non-digit character to finish input:")
    try:
        while True:
            item = int(input())
            head = insertNode(head, index, item)
            print(f"Successfully inserted {item} at index {index}")
            index += 1
    except ValueError:
        pass

    print("\nBefore split() is called:")
    print("The original list:", end=" ")
    printList(head)
    
    head, evenHead, oddHead = split(head, evenHead, oddHead)
    
    print("\nAfter split() was called:")
    print("The original list:", end=" ")
    printList(head)
    print("The even list:", end=" ")
    printList(evenHead)
    print("The odd list:", end=" ")
    printList(oddHead)
    