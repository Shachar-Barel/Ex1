# Ex1: Number Converter and Calculator

Hello, This is my project for Ex1. It's a simple program that works with numbers in different bases like binary, decimal, and hexadecimal. You can convert numbers between these bases, do some math with them, and check if they're valid.

## Files

### 1. **Ex1.java**
This is where all the important stuff happens. It has:
- Functions to check if a number is in the right format (like `1011b2` for binary).
- Functions to convert numbers from one base to another (like from binary to decimal).
- A function to find the biggest number from an array.
- A function that checks if the value of any number in any base equals to another number.

### 2. **Ex1Main.java**
This is the main part of the program that actually runs. It:
- Asks you for two numbers.
- Lets you pick a base for the results.
- Shows the sum and product of the numbers in the base you chose.
- Finds the largest number from the results and shows it.

### 3. **Ex1Test.java**
This file has some tests to make sure everything is working. It uses JUnit to check:
- If the numbers are valid.
- If the conversions between bases work right.
- If the functions of Ex1 works correctly.

## Features
- **Convert Numbers**: You can convert numbers between binary, decimal, hexadecimal, and other bases.
- **Validate Numbers**: The program checks if the numbers are in the right format.
- **Find the Largest Number**: The program finds the biggest number in a list.

## How to Use

### Running the Program
1. Open `Ex1Main.java` in your IDE (IntelliJ, Eclipse, or whatever you're using).
2. Run it.

### Input Format
- You need to enter numbers like this: `<number>b<base>` (e.g., `1011b2` for binary or `123bA` for decimal).
- Bases can be any number from 2 to 16.

### What You Do
1. The program will ask you to enter two numbers.
2. Then, you'll pick a base (2 to 16) to show the results in.
3. The program will:
   - Check if the numbers are valid.
   - Add and multiply them.
   - Show the results in the base you picked.
   - Tell you which number is the biggest.

### Quitting the Program
- If you want to stop, just type `quit` when it asks for input.

## Example
So, let's say you do this:
1. Enter:
   - `num1 = 1011b2`
   - `num2 = 5`
   - `base = 16`
2. The program will show:
  - 1011b2 + 5 = 10bG
  - 1011b2 * 5 = 37bG
  - Max number over [1011b2,5,10bG,37bG] is: 37bG

## How to Install
1. git clone https://github.com/Shachar-Barel/Ex1.git
2. Open the project in your IDE and run `Ex1Main.java`.

## Testing
Run the JUnit tests in `Ex1Test.java` to verify everything works.

## Author
- **Shachar Barel**  
- GitHub: [Shachar-Barel](https://github.com/Shachar-Barel/Ex1)

## License
This project is for educational use.

Let me know if you need more info!
