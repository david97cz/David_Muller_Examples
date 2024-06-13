import unittest
from calculator import Calculator

# Test class for Calculator
class TestCalculator(unittest.TestCase):
    # setUp method is called before each test method
    def setUp(self):
        self.calculator = Calculator()

    # Test the add method
    def test_add(self):
        result = self.calculator.add(1, 2)
        print(f"1 + 2 = {result}")
        self.assertEqual(result, 3)

        result = self.calculator.add(-1, 1)
        print(f"-1 + 1 = {result}")
        self.assertEqual(result, 0)

        result = self.calculator.add(-1, -1)
        print(f"-1 + -1 = {result}")
        self.assertEqual(result, -2)

    # Test the subtract method
    def test_subtract(self):
        result = self.calculator.subtract(2, 1)
        print(f"2 - 1 = {result}")
        self.assertEqual(result, 1)

        result = self.calculator.subtract(-1, 1)
        print(f"-1 - 1 = {result}")
        self.assertEqual(result, -2)

        result = self.calculator.subtract(-1, -1)
        print(f"-1 - -1 = {result}")
        self.assertEqual(result, 0)

    # Test the multiply method
    def test_multiply(self):
        result = self.calculator.multiply(2, 3)
        print(f"2 * 3 = {result}")
        self.assertEqual(result, 6)

        result = self.calculator.multiply(-1, 1)
        print(f"-1 * 1 = {result}")
        self.assertEqual(result, -1)

        result = self.calculator.multiply(-1, -1)
        print(f"-1 * -1 = {result}")
        self.assertEqual(result, 1)

    # Test the divide method
    def test_divide(self):
        result = self.calculator.divide(6, 3)
        print(f"6 / 3 = {result}")
        self.assertEqual(result, 2)

        result = self.calculator.divide(-1, 1)
        print(f"-1 / 1 = {result}")
        self.assertEqual(result, -1)

        result = self.calculator.divide(-1, -1)
        print(f"-1 / -1 = {result}")
        self.assertEqual(result, 1)

        # Check that dividing by zero raises a ValueError
        with self.assertRaises(ValueError):
            self.calculator.divide(1, 0)
            print("1 / 0 = Error (Cannot divide by zero)")

# If this script is run directly, run the tests
if __name__ == '__main__':
    unittest.main()
