# bank_account.py

class BankAccount:
    def __init__(self, owner, balance=0):
        self.owner = owner
        self.balance = balance

    def deposit(self, amount):
        if amount <= 0:
            print("Deposit must be positive.")
            return
        self.balance += amount
        print(f"💰 Deposited: {amount}, New Balance: {self.balance}")

    def withdraw(self, amount):
        if amount > self.balance:
            print("❌ Insufficient funds.")
        elif amount <= 0:
            print("Withdrawal must be positive.")
        else:
            self.balance -= amount
            print(f"💸 Withdrawn: {amount}, New Balance: {self.balance}")

    def get_balance(self):
        return self.balance


# Demo usage
if __name__ == "__main__":
    acc = BankAccount("Alice", 500)
    acc.deposit(200)
    acc.withdraw(100)
    acc.withdraw(700)
    print(f"Final Balance for {acc.owner}: {acc.get_balance()}")
