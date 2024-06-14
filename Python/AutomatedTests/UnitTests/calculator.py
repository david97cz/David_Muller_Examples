class Calculator:
    # Method to add two numbers
    def add(self, a, b):
        return a + b

    # Method to subtract the second number from the first
    def subtract(self, a, b):
        return a - b

    # Method to multiply two numbers
    def multiply(self, a, b):
        return a * b

    # Method to divide the first number by the second
    # Raises a ValueError if an attempt is made to divide by zero
    def divide(self, a, b):
        if b == 0:
            raise ValueError("Cannot divide by zero")
        return a / b
