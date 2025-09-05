def is_palindrome(s):
    return s == s[::-1]

w = input("Enter a word: ")
print("Palindrome!" if is_palindrome(w) else "Not a palindrome.")
