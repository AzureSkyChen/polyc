---
title: PolyC Tutorials
---

PolyC Tutorials
===
# Introduction
This reference manual describes the PolyC programming language.
## What's PolyC?
*PolyC* is a novel programming language that characterizes the property of polynomial-time computablility. In other words, the set of problems that can be solved by PolyC is precisely the complexity class **FP**. In fact, the style of programs in PolyC does not differ significantly from the current mainstream imperative programming languages. By cleverly imposing certain restrictions in its syntax, we ensure that the capabilities of the language align precisely with the class **FP**.

## Using the PolyC Intepreter
```bash=
java -jar polyc.jar file_name.pc arg1 arg2 ...
```
# Basics
## Variables
In programming languages, a *variable* is a named storage location that holds a value or data. It acts as a symbolic representation for a memory address where data can be stored and retrieved during program execution. For example,
```cpp
a=3;
b=4;
c=a+b;
```
There are three different variables here, named `a`, `b`, and `c`. The value of `a` is `3`, the value of `b` is `4`, and after the assignment operation, the value of `c` is `7`.

Obviously, the name of a variable is crucial as it serves as a significant identifier to distinguish it from other variables. In PolyC, not all names are considered valid identifiers. We will introduce the rules that constitute a valid identifier later.

### Identifiers
An *identifier*, in programming, is a name used to identify a variable, function or other entity. It is a user-defined name that provides a unique and meaningful label for a specific element within a program. In PolyC, a valid identifier must adhere to the following rules:

1. The identifier must start with a letter (`a-z`, `A-Z`) or an underscore (`_`). It cannot start with a number or any other special character.
3. After the first character, the identifier can contain letters, digits (`0-9`), or underscores. It should not contain any spaces, punctuations or special characters such as `@, #, $, %`, etc.
4. The identifier should not be a reserved keyword or a predefined identifier.
5. PolyC is a case-sensitive language, which means that two identifiers that differ only in their letter casing are considered different. For example, the `var` variable is not the same as the `VAR` variable or the `Var` variable.

Regarding the third point mentioned above, it is important to provide detailed clarification. In PolyC, there are several reserved keywords used for naming operations, data types, and more. Therefore, they cannot be used as identifiers. These reserved keywords are:
```cpp
and
array
bool
break
case
continue
default
dict
do
else
false
if
int
iterable
not
or
print
return
size
string
switch
true
void
while
```

Here are a few examples of valid identifiers in PolyC:
```cpp
var
my_variable
_x
counter1
```
Here are some examples of invalid identifiers:
```cpp
123abc // starts with a digit
my-variable // contains a hyphen
$money // starts with a special character
string // a reserved keyword
3Dshape // starts with a digit
my.variable // contains a period
my variable // contains a space
```

Remember that these examples violate the rules for valid identifiers in PolyC. It is important to follow the rules and choose appropriate names for identifiers to ensure code correctness and readability.

### Types
We can think of variables as blocks of memory that store specific values. However, when we attempt to retrieve the value of a variable, not only the location where the value is stored but also the size of the memory block becomes crucial. In other words, in the case of storing an integer or a string, for example, the required memory size may differ. Therefore, different variables are often assigned different types to record this information.

*Types* in PolyC or any other programming language, refer to the classifications or categories of data that variables or expressions can hold. Types define the kind of data that can be stored in a variable and determine the operations that can be performed on that data.

#### Fundamental Types
In PolyC, we provide three fundamental types. They are:
1. Integer (`int`): Represents whole numbers without decimal points, such as `1`, `-5`, or `1000`. In PolyC, integer type can provide a representation for sufficiently large integers without concerns of overflow, as long as the memory allows it.
2. String (`string`): Represents a sequence of characters. In PolyC, we enclose strings within double quotation marks, such as `"abc"`, `"This is a string."`.
3. Boolean (`bool`): Represents a logical value of either `true` or `false`.
4. Void (`void`): Represents a type that indicates the absence of a value. It is used to declare functions or methods that do not return a value.

In addition to above four fundamental types, PolyC also provides some compound types like `array` and `dict`, which will be introduced in subsequent sections. These types allow for storing and manipulating different kinds of data in a PolyC program.

#### Iterable Types
In addition to fundamental types, PolyC also provides a special category of types identified by the term "iterable." Examples of iterable types include `iterable int`, `iterable bool`, and so on. However, there is no `iterable void` type. The purpose and usage of these types will be explained in detail in the subsequent sections.

### Declaration
PolyC is a strongly typed language. All variables must be explicitly declared with their types before they can be used. Once a variable is declared with a specific type, its type cannot be changed during its usage. The `declaration` of a variable refers to the process of binding the variable name with its type.

In PolyC, variable declaration is straightforward. You simply need to explicitly write the type name before the variable identifier. For example,
```cpp
int x;
string str;
bool flag;
```
The semicolon `;` represents the end of a declaration. Here are three declaration statements. The first statement declares a variable named `x` of type `int`. The second statement declares a variable named `str` of type `string`. The third statement declares a variable named `flag` of type `bool`.This represents that the variable `flag` can only have a value of `true` or `false`. The variable `x` must have a value that is an integer, such as `1`, and not a string like `"1"`. The variable `str` must have a value that is a string of characters and cannot be assigned a boolean value like `true`.

If there are multiple variables that we want to declare with the same type, we can also accomplish it in a single declaration statement by separating the variable names with commas. For example,
```cpp
int x,y,z;
```
This has the exact same effect as writing three separate declaration statements; it's just a more concise way of doing it.

### Initialization
After declaring a variable, we need to assign a value to it before using it. *Initialization* refers to the process of assigning an initial value to a variable at the time of its declaration. When a variable is initialized, it means that we can safely used it in the program.

In PolyC, initialization can be done using an explicit assignment operator (`=`) followed by the desired initial value. For example:
```cpp
int x=1;
string str="Hello, world!";
bool flag=true;
int x=1,y=2,z=3;
```
Here we declare and initialize three variables: `x` of type `int` with an initial value of `1`, `str` of type `string` with an initial value of ``"Hello, world!"``, and `flag` of type `bool` with an initial value of `true`.

For convenience, uninitialized variables are assigned default values in PolyC, as follows:

| Type   | Default Value |
| ------ | ------------- |
| int    | `0`             |
| string | `""`            |
| bool   | `false`         | 
`""` represents an empty string.

But we still need to emphasise that initializing variables is important because it ensures that they have a proper value before they are accessed or used in calculations. It helps avoid unexpected behavior or errors that can occur due to using uninitialized variables with default values.

## Constants
In PolyC, we do not provide constant expressions. Instead, we only provide literal constants. A *literal constant*, also known as a literal, is a fixed value that appears directly in the source code of a program. It is a specific value that is written in a program's code without any variables or calculations.

Based on the types, we have three different categories of constants.

### Integer Literals
Here are some examples of interger literal constants in PolyC:
```cpp
0;
10;
-4;
0b111;
0B101;
```
The first three literals are decimal, while the last two are binary. After the prefix `0b/0B`, only `0` or `1` can follow.

In PolyC, leading zeros are not allowed before decimal numbers. Although we may consider `01` to be equivalent to `1`, in PolyC, the former is not allowed.

### String Literals
In PolyC, string constants can consist of zero characters (an empty string) or one or more characters.

```cpp
"Hello, world!";
"This is a string";
"";
```

Note that strings cannot contain line breaks or carriage returns, and they cannot include backslashes (`\`) or quotation marks (`"`). Therefore, the following examples are invalid strings:

```cpp
"12
   34";
"\";
""";
```

When we need to include these special characters, we use *escape sequences*. PolyC provides the following escape sequences:

| Escape Sequence | Meaning         |
| --------------- | --------------- |
| \n              | newline         |
| \r              | carriage return |
| \t              | tab             |
| \s              | space           |
| \b              | backspace       |
| \f              | form feed       |
| \\'             | single quote    |
| \\"             | double quote    |
| \\\\            | backslash       |

For example:

```cpp
"\"how are you?\n\"";
"x\ty\tz";
```

If we print the first string, it will be displayed as `"how are you?"`, and the second one will appear as `x    y    z`.

### Boolean Literals
There are only two kinds of boolean literals, i.e., `true` and `false`.

In PolyC, literal constants are used to initialize variables, pass function parameters, and construct expressions. For example,
```cpp
int x=1;
int y=(x+3)/2;
fun(x,true,"");
```
## Operators
An *operation* in programming refers to a specific action or computation performed on data or variables. It can involve mathematical calculations, logical comparisons, string manipulations, and more. Operations are typically represented by symbols or keywords and are used to perform specific tasks or transformations on data.

In PolyC, we provide the following operations:


| Operators                         | Operand Types                     | Result Types |
| --------------------------------- | --------------------------------- | ------------ |
| Arithmetic Operators              | `int`                             | `int`        |
| Bitwise Operators                 | `int`                             | `int`        |
| Logical Operators                 | `bool`                            | `bool`       |
| Equality Operators                | `t`         | `bool`       |
| Comparison Operators              | `int`                             | `int`        |
| Assignment Operators              | `t` | `void`       |
| Compound Assignment Operators     | `int`                             | `ref`        |
| Increment and Decrement Operators | `int`                             | `int`        |
| Comma Operator                    | `t1,t2,...,tn`                    | `tn`         |
| Ternary Operator                  | `bool?t:t`                        | `t`          |
| Size Operator                     | `t`                               | `int`        |
| Int Operator                      | `t`                               | `int`        |
| String Operator                   | `t`                               | `string`             |

In PolyC, outside of the loop body, these operations can freely act on the corresponding types, regardless of whether the type is iterable or not. Inside the loop body, there are certain restrictions on operations that change variable values:

1. For assignment operations, the left side of the equal sign cannot be `iterable`.
2. For increment/decrement operations, the operand cannot be `iterable`.

Regarding loop statements, we will cover them in the next section.

### Arithmetic Operations
*Arithmetic operations* are mathematical operations performed on integer values to perform calculations. In PolyC, arithmetic operations include:


| Operator          | Description                                   |
| ----------------- | --------------------------------------------- |
| Addition (`+`)    | Adds two or more numbers together.            |
| Subtraction (`-`) | Subtracts one number from another.            |
| Division(`/`)     | Divides one number by another.                |
| Modulo(`%`)       | Returns the remainder of a division operation. | 

It is worth noting that the division mentioned here refers to integer division and the divisor cannot be zero.   For example,

```cpp
1+3; // 4
3-1; // 2 
100%3; // 1
100/3; // 33
```

In PolyC, there is **no multiplication(`*`) operation**. This is an important point to be aware of.

### Bitwise Operations
*Bitwise operations* are operations that manipulate individual bits of binary representations of data. They operate on the binary representation of integers or binary values, performing operations at the bit level. Bitwise operations include:

| Operator | Description         |
| -------- | ------------------- |
| `&`      | Bitwise AND         |
| `|`      | Bitwise OR          |
| `^`      | BitWise XOR         |
| `~`      | Bitwise NOT         |
| `>>`     | Bitwise right shift | 

The bitwise right shift `x<<k` is equivalent to $\lfloor x/2^k\rfloor$, regardless of whether x is positive or negative. However, `k` must be a non-negative value. For example,
```cpp
100&23; // 4
0b100|0b101; // 0b101
~0b101; // 0b1010
0b11011^0b10100; // 0b1111
101>>2; // 25
```

In PolyC, there is **no bitwise left shift(`*`) operation**.

### Logical Operations
*Logical operations* are used to perform logical evaluations and comparisons on Boolean values. In PolyC, there are three basic logical operations:
| Operator      | Description |
| ------------- | ----------- |
| `&&` or `and` | AND         |
| `||` or `or`  | OR          |
| `!` or `not`       | NOT         |


For example,
```cpp
bool x=true;
x&&false; // false
x||false; // true
not false; // true
```

These logical operations are often used in conditional statements, loops, and other control flow constructs to make decisions based on certain conditions.

### Relational Operations
*Relational operations* are used to compare values and determine their relationship or equality. In PolyC, relational operations typically involve two operands and return a `bool` result (`true` or `false`) based on the comparison result.
#### Equality
| Operator | Description                                |
| -------- | ------------------------------------------ |
| `==`     | returns true if both operands are equal    |
| `!=`     | returns true if the operands are not equal |

For example,
```cpp
int x=1,y=2;
x==y; // false
x==y-1; // true
true!=false; // true
"123"=="123"; // true
```

The operands on both sides of the equality operator must be of the same type and can be either `int`, `string` or `bool`. Here are some incorrect operations:
```cpp
true==10; // Mixing different types
int x,y;
(x==y)+1; // return values of == are bool, not int
```

#### Comparision
| Operator | Description                                                                    |
| -------- | ------------------------------------------------------------------------------ |
| `>`      | returns true if the left operand is greater than the right operand             |
| `<`      | returns true if the left operand is less than the right operand                |
| `>=`     | returns true if the left operand is greater than or equal to the right operand |
| `<=`     | returns true if the left operand is less than or equal to the right operand    |
For example,
```cpp
int x=10,y=5;
x>y; // true
x>=y+5; // true
x<y; // false
x<=y+5; // true
```

Only `int` type variables and constants can be compared using comparison operators. Here are some incorrect operations:
```cpp
5>"3"; // "3" is a string literal
```
### Assignment Operations
*Assignment operations* are used to assign a value to a variable. In PolyC, the assignment operator is denoted by the equals sign (`=`). It assigns the value on the right-hand side to the variable on the left-hand side.

For example:
```cpp
int x=5;  // Assigns the value 5 to the variable x
string str="Hello";  // Assigns the string "Hello" to the variable str
bool flag=true;  // Assigns the value true to the variable flag
```

The assignment operator can also be combined with other operators to perform *compound assignment*.  For example:
```cpp
int x=1;
x+=5; // x=6 now
```
In this case, the compound assignment operator (`+=`) adds the value on the right-hand side (`5`) to the current value of the variable(`1`) and assigns the result (`6`) back to the variable `x`.

There are also other compound assignment operators in PolyC, including
```cpp
int x,y;
y+=x;  // Equivalent to y=y+x
y-=x;  // Equivalent to y=y-x
y/=x;  // Equivalent to y=y/x
y%=x;  // Equivalent to y=y%x
y&=x;  // Equivalent to y=y&x
y|=x;  // Equivalent to y=y|x
y^=x;  // Equivalent to y=y^x
y>>=x;  // Equivalent to y=y>>x
```
Assignment operations are allowed to be nested in PolyC. For example:
```cpp
int x = 0;
(x = 5) += 1;  // x is assigned the value 5, then incremented by 1 (resulting in x = 6)
```
In this case, the inner assignment `(x = 5)` assigns the value 5 to the variable x, and then the compound assignment `(x += 1)` increments the value of x by 1, resulting in x being equal to 6.

### Increment and Decrement Operations
The increment and decrement operations in PolyC are used to increase or decrease the value of a variable by 1. They are denoted by the symbols `++` and `--`, respectively.

The increment operation `++` adds 1 to the variable, while the decrement operation `--` subtracts 1 from the variable. These operations can be only applied to `int` variables.

Here's an example:
```cpp
int x = 5;
x++;  // x=6
```

Similarly, the decrement operation works in the opposite way:
```cpp
int y = 10;
y--;  // y=9
```

This operation cannot be nested. For example, the following operation is invalid.
```cpp
int x=0;
(x++)++; // invalid
```

### Comma operator
In PolyC, the comma operator(`,`) allows multiple expressions to be evaluated sequentially, where each expression is separated by a comma. The comma operator evaluates each expression from left to right and returns the value of the last expression.

For example:
```cpp
int a = 5, b = 10, c;
c = (a++, b++, a + b);
```

In the above example, the expressions `a++` and `b++` are evaluated first, incrementing the values of `a` and `b`. Then, the expression `a + b` is evaluated, and the result is assigned to `c`. The value of `c` will be the sum of the incremented values of `a` and `b`, i.e., `17`.

### Ternary Operator
The *ternary operator* `?:`, also known as the conditional operator, is a special operator used to simplify conditional expressions. The syntax of the ternary operator is as follows:
```cpp
condition ? expression1 : expression2
```

In this syntax, `condition` is a conditional expression used to evaluate true or false. If `condition` is true, the value of `expression1` is returned; if `condition` is false, the value of `expression2` is returned. Note that the types of `expression1` and `expression2` must be the same.

For example:
```cpp
int a = 10;
int b = 20;
int max = (a > b) ? a : b;
```

In the above example, if `a` is greater than `b`, the value of `max` will be `a`; otherwise, the value of `max` will be `b`. Of course we have `a<b` in this case, so `max` will be assigned with `20`.

The ternary operator can make conditional expressions more concise and clear, especially in simple conditional scenarios.

### Size Operator
The *size operator* is a special operator in PolyC. It is a unary operator which can be applied to all fundamental types except `void`. For example,
```cpp
size(-10);
size(4);
size(true);
size("Hello world!);
```
For integer variables, the `size` function returns the binary length of their absolute value. The `size(0)` is defined as 0, meaning that $\mathrm{size}(x) = \lceil\log (\vert x\vert+1)\rceil$. For boolean variables, the `size` function always returns `1`. For string variables, the `size` function returns the number of characters in the string. An empty string naturally corresponds to `0`. Hence, the values of the above examples are `size(-10)=4`， `size(4)=3`，`size(true)=1` and `size("Hello world!")=12`.

### Explicit Type Casting Operators
In PolyC, we do not allow implicit type conversions. Therefore, we provide several explicit type casting operators that allow you to convert the value of a variable to the corresponding value of another type. For example,
```cpp
int("100"); // 100, string->int
int(true); // 1, bool->int
string(10); // "10", int->string
string(false); // "false", bool->string
```
To convert any value to its corresponding string representation, the result is simply the value surrounded by quotation marks. However, when converting a string to an integer, you need to ensure that all characters within the string are numeric; otherwise, the casting cannot be executed. For example, `int("abc")` is an incorrect usage. In the case of boolean types, `true` corresponds to `1`, and `false` corresponds to `0`. We do not provide explicit casting operators to convert other types to boolean because this can be easily achieved using relational operations.

## I/O
*I/O* stands for Input/Output. It refers to the process of exchanging data between a program and its external environment, such as reading input from the user or displaying output to the user. *Input* refers to the data or information that a program receives from the external environment, while *output* refers to the data or information that a program sends to the external environment.

### Input
<p style="color:green;">
    TODO
</p>

### Output

In PolyC, we provide the `print` function. Its purpose is to print a string to the console. For example:
```cpp
print("Hello World!");
```
If we want to output the values of other types, we can use the `string` function introduced earlier. For example:
```cpp
int x = 100;
print(string(x++));
print(string(x == 100));
```
Here, we first evaluate `x++`, whose result is `101`. Then we convert the result to the corresponding string `"101"` by `string` and print it by `print`. Next, we evaluate `x == 100`, which results in `false`, and we print it to the console as well. Note that `print` does not automatically add a newline, so the final result is:
```cpp
101false
```

# Program structure
Now let's provide a simple PolyC code snippet to give you an initial impression.

```cpp
int add(int x, int y){
    return x+y;
}

int main(){
    // initialization
    array<int> fib=[]; 
    
    // calculation
    while(i<15){
        switch(i){
        case 0:fib.append(1);break;
        case 1:fib.append(1);break;
        default:fib.append(add(fib.get(i-1),fib.get(i-2)));
        }
    }
    
    // output
    print(fib[14]);
    return 0;
}
```

In this code snippet, we have implemented the algorithm for computing the famous Fibonacci sequence, which satisfies the following definition:

$$
f(0)=f(1)=0
$$

$$
f(i)=f(i-1)+f(i-2),\quad i>=2
$$

The computing results of the first 15 terms of the sequence are stored in an array named `fib`. Next, we use the `print` function to print out the variable `fib` to the screen. The output of the program would be:

```cpp
[1:1:2:3:5:8:13:21:34:55:89:144:233:377:610:nil]
```

Finally, we return `0` from the `main` function, indicating a successful program execution.

Although the functionality of programs may vary greatly, their structures are often similar and follow certain rules. In the following section, we will provide a detailed explanation of the main structure of a program.
## Comments
*Comments* are used to add explanatory or descriptive text within the code. They are ignored by the interpreter and do not affect the execution of the program. Comments play an important role in improving code readability and maintainability.

In PolyC, there are two types of comments:

### Single-line comments
These comments start with `//` and extend until the end of the line. Anything after `//` on the same line is treated as a comment and is not executed. For example:
```cpp
int x = 10; // This is a single-line comment
```

### Multi-line comments
These comments start with `/*` and end with `*/`. Anything between `/*` and `*/` is treated as a comment and can span across multiple lines. For example:
```cpp
/* This is a
   multi-line 
   comment */
int y = 20;
```

## Expressions
An *expression* is a combination of values, variables, operators, and function calls that can be evaluated to produce a result. In programming, expressions are used to perform calculations, manipulate data, make decisions, and more.

Expressions can be simple, such as a single value or variable, or they can be complex, involving multiple operators and operands.

We mainly have three types of expressions:
1. Arithmetic expressions:
    ```cpp
    3+3;
    a/b;
    x%3-1;
    x^(y>>k);
    ```
2. Logical expressions
    ```cpp
    x==y && x!=z;
    a+b>c or b+c>a;
    not flag1&&flag2;
    ```
3. Assignment expressions
    ```cpp
    x=b==0?-1:a/b;
    bool flag=a+b>c||b+c>a;
    y-=1;
    ```
### Iterability
As mentioned before, each fundamental type can be either iterable or non-iterable. For an expression, if all the variables involved are iterable, we consider it as *iterable*. For example,
```cpp
iterable int x,y;
int a,b;
a+x; // non-iterable
x+y+100; // iterable
```

### Precedence
*Precedence* refers to the order in which operators are evaluated in an expression. It determines the priority of operators when there are multiple operators present in an expression. Operators with higher precedence are evaluated before operators with lower precedence.

In PolyC, operators are assigned precedence levels based on their priority. For example, in the expression `a+b/c`, the division operator `/` has a higher precedence than the addition operator `+`. Therefore, `b/c` is evaluated first, and the result is then added to `a`.

Parentheses can change the precedence of operations. If the above expression is changed to `(a+b)/c`, we should first evaluate the expression inside the parentheses `a+b`, and then divide the sum by `c`.

### Associativity
*Associativity* refers to the order in which operators of the same precedence are evaluated when they appear consecutively in an expression. It determines how the operands are grouped during evaluation.

There are two types of associativity:

1. Left-associativity: Operators that are left-associative are evaluated from left to right when they have the same precedence.

2. Right-associativity: Operators that are right-associative are evaluated from right to left when they have the same precedence.

More specifically, the precedence and associativity of the operators we have discussed earlier are as follows:


<table>
	<tr>
	    <th>Precedence</th>
	    <th>Operator</th>
	    <th>Description</th>
        <th>Associativity</th>
	</tr>
    <tr>
        <td>0</td>
        <td>()</td>
        <td>parenthesis</td>
        <td></td>
    </tr>
	<tr >
	    <td rowspan="3">1</td>
	    <td>++, --</td>
	    <td>posfix increment/decrement</td>
        <td rowspan="3">left</td>
	</tr>
	<tr>
	    <td>()</td>
	    <td>functional forms</td>
	</tr>
	<tr>
	    <td>[]</td>
	    <td>subscript</td>
	</tr>
	<tr>
        <td rowspan="3">2</td>
	    <td>++, --</td>
	    <td>prefix increment/decrement</td>
        <td rowspan="3">right</td>
	</tr>
	<tr>
        <td>!, ~</td>
	    <td>logical NOT, bitwise NOT</td>
	</tr>
	<tr>
	    <td>+, -</td>
	    <td>sign</td>
	</tr>
	<tr>
        <td rowspan="3">3</td>
	    <td>/, %</td>
	    <td>devide, modulo</td>
        <td rowspan="3">left</td>
	</tr>
	<tr>
	    <td>+, -</td>
	    <td>addition, subtraction</td>
	</tr>
	<tr>
	    <td >>></td>
	    <td>shift</td>
	</tr>
	<tr>
        <td rowspan="2">4</td>
	    <td> >, <, >=, <=</td>
	    <td>comparision</td>
        <td rowspan="2">left</td>
	</tr>
	<tr>
	    <td >==, !=</td>
	    <td >equality</td>
	</tr>
	<tr>
        <td rowspan="3">5</td>
	    <td >&</td>
	    <td >bitwise AND</td>
        <td rowspan="3">left</td>
	</tr>
	<tr>
	    <td >^</td>
	    <td >bitwise XOR</td>
	</tr>
	<tr>
	    <td >|</td>
	    <td >bitwise OR</td>
	</tr> 
    <tr>
        <td rowspan="2">6</td>
	    <td >&&</td>
	    <td >logical AND</td>
	    <td rowspan="2">left</td>
	</tr> 
    <tr>
	    <td >||</td>
	    <td >logical OR</td>
	</tr> 
    <tr>
        <td rowspan="2">7</td>
	    <td >=, +=, -=, /=, %=, |=, &=, ^=, >>=</td>
	    <td >assignment</td>
	    <td rowspan="2">right</td>
	</tr>
    <tr>
	    <td >?:</td>
	    <td >ternary operator</td>
	</tr> 
    <tr>
        <td>8</td>
	    <td >,</td>
	    <td >comma</td>
	    <td >left</td>
	</tr> 
</table>

## Statements
A *statement* is a unit of code that carries out a specific task. Statements are the building blocks of a program, and they are executed sequentially or conditionally, depending on the program's control flow.

In PolyC, a statement is typically terminated by a semicolon (`;`).
### Empty Statement
An *empty statement* is represented by a semicolon (`;`) and it has no effect. However, if you accidentally include multiple semicolons at the end of a statement, the program can still run without any issues.

### Sequential Statement
A *sequential statement*, in PolyC, refers to a statement or a group of statements that are executed in a sequential order, one after the other. Each statement is executed only after the previous statement has been completed. Sequential statements are the most basic type of statements in programming, and they form the foundation of program execution flow.

### Compound Statement
We can use curly braces to create blocks of code, as follows:
```cpp
{
    statement1;
    statement2;
    ...
}
```
The code within the curly braces forms a *compound statement*, which is a sequence of statements. The block can be seen as a single unit and is often used to group statements together. It allows for the execution of multiple statements within a specific context or scope. The statements inside the block are executed sequentially as we mentioned before, once the block is reached during program execution.

### Expression Statement
An *expression statement* is a type of statement that consists of an expression. An expression statement is used to carry out a computation based on the evaluation of the expression. The result of the expression may or may not be used or stored. For example, here is a sequence of expression statements.
```cpp
x+1;
x++;
y+=a%3;
```
The first statement has no effect. The results of the second and third statements are respectively stored in variables `x` and `y`.

### Declaration Statement
Variable declaration can also be considered as a *declaration statement*. For example,
```cpp
int x=1,y=2;
int z=x+y;
```

### Conditional Statements
A *conditional statement*, also known as a selection statement, allows the program to make decisions and execute different blocks of code based on a specified condition.

#### If Statements
The *if statement* is used to execute a statement if a certain condition is true. If the condition is false, the statement is skipped, and the program continues to the next statement after the "if" block. The general syntax of the "if" statement is as follows:

```cpp
if (condition) statement
```
The statement can be any statement like a compound statement or another `if` statement.

#### If-Else Statements
The if-else statement* allows for two different statement to be executed based on the evaluation of a condition. If the condition is true, the first statement is executed; otherwise, if the condition is false, the second statement is executed. The general syntax of the if-else statement is as follows:

```cpp
if (condition) statement1 else statement2
```

Here's an example:

```cpp
int x = 10;
if (x > 5) {
   print("x is greater than 5");
} else {
   print("x is not greater than 5");
}
```

#### Switch Statements
A *switch statement* is a control flow statement that allows the program to evaluate an expression and perform different actions based on the value of that expression. It provides an alternative way to write multiple nested if-else statements for multi-way branching.

The general syntax of a switch statement is as follows:

```cpp
switch (expression) {
    case value1:
        // Code to be executed if expression matches value1
        break;
    case value2:
        // Code to be executed if expression matches value2
        break;
    case value3:
        // Code to be executed if expression matches value3
        break;
    // ... more cases
    default:
        // Code to be executed if expression doesn't match any of the cases
        break;
}
```

Here's an example:

```cpp
int day = 3;
switch (day) {
    case 1:
        print("Monday");
        break;
    case 2:
        print("Tuesday");
        break;
    case 3:
        print("Wednesday");
        break;
    case 4:
        print("Thursday");
        break;
    case 5:
        print("Friday");
        break;
    default:
        print("Weekend");
        break;
}
```

The break statement is used to exit the switch statement after executing a particular case block. It prevents the code from falling through to the next case. The default block is optional and is executed when none of the cases match the expression.

### Iteration Statements
An *iteration statement* is a control flow statement that allows a block of code to be repeatedly executed based on a specified condition. It provides a way to perform repetitive tasks efficiently.

There are two types of iteration statements in most PolyC, including:

#### While Loop
The *while loop* repeatedly executes a block of code as long as a specified condition is true. The condition is evaluated before each iteration. The syntax of this statement is:

```cpp
while(i<size(IterableExpression)) statement
while(i<IntegerConstant) statement
```

Here, `i` is a loop variable. Within the loop body, we cannot change the value of `i`, but after each execution of the statements within the loop body, `i` is automatically incremented by `1`.

In the first case, the `size` operation is evaluated only once when the `while` statement is first encountered, and the operand **must be an iterable expression**. The return value of the `size` operation is the upper bound of the loop iteration count.

In the second case, we use an integer constant as the upper bound of the loop iteration count.


#### Do-While Loop
The *do-while loop* is similar to the while loop, but the condition is evaluated after each iteration. This guarantees that the loop body is executed at least once.

```cpp
do statement while (i<size(IterableExpression));
do statement while (i<IntegerConstant);
```
The meaning of the loop condition is the same as that of a while loop.

The statements that are repeatedly executed can be compound statements, and loops can also be nested. We refer to this as the loop body. It's important to note that **within the loop body, we cannot change the value of iterable variables nor declare a new iterable variable.** For example, the following programs are valid PolyC programs:
```cpp
iterable int x=10;
int y;
while(i<size(x)){
    y++;
}
```
```cpp
iterable int x=10,y=10;
int z;
while(i<size(x)){
    while(i<size(y)){
        z++;
    }
}
```
But the following are not:
```cpp
iterable int x=10, y;
while(i<size(x)){
    y++; // Assignment to an iterable variable `y` is not allowed.
}
```
```cpp
int x=10, y;
while(i<size(x)){ // `x` is non iterable
    y++;
}
```
```cpp
iterable int x=10,y=10,z;
while(i<size(x)){
    while(i<size(y)){
        z++; // Assignment to an iterable variable `z` is not allowed.
    }
}
```
```cpp
int x=10,y=10,z;
while(i<size(x)){ // `x` is non iterable
    while(i<size(y)){ // `y` is non iterable
        z++;
    }
}
```
### Jump Statements
*Jump statements* are used to control the flow of execution within a program. They allow the program to jump to a different section of code or terminate the execution of a loop or function.


Jump statements provide flexibility in controlling the program's execution flow and are often used in combination with conditional statements and loops to achieve desired control structures.

PolyC provides the following jump statements:

#### Break Statement
The *break statement* is used to exit from a loop or a switch statement. When encountered within a loop or a switch statement, it immediately terminates the loop and transfers control to the next statement after the loop.
```cpp
iterable int x=100;
while(i<size(x)){
    if(i>10){
        break;
    }
}
```

### Continue Statement
The *continue statement* is used to skip the remaining statements within a loop iteration and move to the next iteration. It jumps to the beginning of the loop and starts the next iteration.
```cpp
iterable int x=100;
while(i<size(x)){
    if(i>10){
        continue;
    }
}
```

### Return Statement
The *return statement* is used to exit from a function and return a value (if the function has a return type). It transfers control back to the caller of the function and optionally returns a value.
```cpp
int main(){
    print("Hello World!");
    return 0;
}
```
## Functions
A *function* is a block of code that performs a specific task. It is a reusable piece of code that can be called from different parts of a program, allowing for modular and organized code structure.

### Declaration
In PolyC, functions are defined using the following syntax:

```cpp
return_type function_name(parameter_list) {
    function_body
}
```
For example,
```cpp
int add(int x,int y){
    return x+y;
}
```

#### Function Name

The *function_name* is the name assigned to the function, which can be used to call the function from other parts of the program.
The function name is also an identifier, and its rules for construction are the same as for variable names. The function in the above example is called `add`.

#### Return Type

The *return type* specifies the data type of the value returned by the function. It can be any valid PolyC data type or `void` if the function does not return a value. The return type of `add` is `int`.

#### Parameter List
The *parameter list* consists of zero or more parameters that are passed to the function. Each parameter has a data type and a name, separated by commas. These parameters act as placeholders for values that can be passed into the function when it is called. The function `add` has two parameters named `x` and `y`, both of which are of type `int`.

#### Function Body
The *function body* contains the actual code to be executed when the function is called. It includes variable declarations, statements, and optionally, a return statement to return a value back to the caller (if the type of this function is not `void`).

It's important to note that **we cannot change the value of iterable variables nor delare a new iterable variable within the function body, unless it is the `main` function.** For example,
```cpp
int add(int x,int y){
    iterable int z=x+y;
    return z;
}
```
In this example, we declare a new iterable variable `z` inside function `add`, which is not allowed.

### Function Call
To use a function, you call it by its name followed by parentheses, optionally passing arguments if the function expects any. For example:

```cpp
int result = add(3, 5);
```

In this example, the `add` function is called with arguments `3` and `5`, and the returned value `8` is assigned to the variable `result`.

### Iterability
Note that we mentioned earlier that the return value can be any data type, including iterable types. Therefore, special attention needs to be paid when making function calls:
#### Parameter
1. If function parameters are declared as iterable types, the arguments passed during the function call must be iterable expressions.
2. If function parameters are not iterable types, any expressions can be used during the function call.

For example,
```cpp
int iterable_add(iterable int x, iterable int y){
    return x+y;
}
int a,b;
add(a,b); // Error, because a and b are not iterable
add(1,1); // Correct
```
#### Return Value
1. If the function return value is declared as iterable, the return statement must return the value of an iterable expression. The function call can be part of an iterable expression.
2. If the function return value is declared as non-iterable, any expression can follow the return statement. Expressions that include this function call are considered non-iterable.

### Default Values
We can also set optional parameters for functions by adding `=` followed by the default value after the parameter name. For example,
```cpp
int add(int x,int y=1){
    return x+y;
}
```
If we can call `add(100)`, the default value of `y` is assigned as `1`. The function will then return `101`.


Note that once a parameter with a default value is defined, all subsequent parameters must also have default values assigned. For example,
```cpp
int add(int x=1,int y){
    return x+y;
}
```
is not a valid function declartion.

### Overload
<p style="color:green;">
    TODO
</p>

### Recursivity
Recursion is not allowed in PolyC.

## Name Scope
*Scope* refers to the visibility and accessibility of variables, functions, and other identifiers within a program. It defines the part of the program where a particular identifier is recognized and can be used. In other words, scope determines the portion of the code where a variable or function is valid and can be accessed.
### Global Scope
*Global scope* refers to the outermost scope in a program, where variables, functions, and other identifiers are accessible from anywhere within the program. In PolyC, global variables are declared outside of any functions or blocks, typically at the top of the program. For example,

```cpp
string s="Hello World!";
int x=0;
int main(){
    print(s);
    x+=1;
    return 0;
}
```
Here, `s` and `x` are both variables with global scope. They can be accessed in the main function.

### Block Scope
*Block scope* refers to the portion of code within a set of curly braces `{}`. Variables declared within a block are only accessible within that block and its nested blocks. Once the block is exited, the variables declared within it are no longer accessible. Within the same scope, a name can be declared at most once. For example,
```cpp
int main(){
    int x=0;
    {
        int x=1;
    }
    print(string(x));
    return 0;
}
```
The final result printed by this program is `0` because the variable `x` declared within the curly braces `{}` has a block scope, and it is not accessible outside of that block. Once the program exits the curly braces, the variable `x` is no longer available, and the value of the first `x` is used for the print statement, which is `0`.

Block scope helps to limit the visibility and lifespan of variables, preventing naming conflicts and promoting code modularity.

## Program
A PolyC program consists of a sequence of global variable declaration statements, function declaration statements and exactly one main function.
### Main Function
The *main function* is a special function in a PolyC program that serves as the entry point of the program's execution. It is the starting point from which the program begins its execution and where the program terminates. The main function contains the code that defines the sequence of instructions to be executed when the program runs. In PolyC, the main function has the following syntax:

```cpp
int main() {
    // Code statements
    return 0;
}
```

The main function can have several `int`p arameters, although the most common form is the one shown above, where no parameters are specified. The return type of the main function is typically `int`, indicating the exit status of the program. The code statements within the main function define the actions to be performed when the program runs, and the `return 0` statement signifies a successful program termination.

# Compound Data Type
A *compound data type* is a data type that allows you to group together multiple values of different or the same types into a single entity. It is called "compound" because it combines or compounds multiple values into a larger unit.

In PolyC, compound data types include arrays, dictionaries and Strings. These data types allow you to organize and manipulate related data more efficiently.
## Array
An *array* allows you to store multiple values of the same data type. It provides a way to organize and access a collection of elements using a single variable name.
### Declaration
In PolyC, arrays can be declared by specifying the data type of the elements and the size of the array. For example, you can declare an integer array of size `5` as follows:

```cpp
array<int> arr=array(5);
```

This declares an array named `arr` that can store `5` integers.

After initialization, the elements of an array are in an undefined state. Using them directly without initializing them will result in an error. It is necessary to initialize each element individually before using them.

When the array is not too long, we can use another method to explicitly provide all the elements:
```cpp
array<int> arr=[1,2,3,4,5];
array<int> nil=[];
```
The latter represents an empty array.

### Access
The elements of the array are accessed using indices, starting from `0`. For example, to access or modify the third element of the array, you would use the index `2`:

```cpp
arr[2] = 10;
int x = arr[2];
```
You can also use the `get:[t]->t` and `set:t->void` method to retrieve or modify the value of an array.
```cpp
arr.set(2,10);
int x = arr.get(2);
```
### Append
`append:t->void` is a method that adds an element to the end of an array. It increases the size of the array by one and assigns the given element to the new position.
```cpp
array<int> arr=[];
arr.append(1);
int x=arr.get(0);
print(string(x));
```
The program's output is as follows:
```cpp
1
```
### Length
`len:[t]->int` method is used to determine the number of elements in an array. For example,
```cpp
int length=arr.len();
```

### Pop
The `pop:[t]->t` method is used to remove and return an element from an array.
```cpp
array<int> arr=[1,2,3,4,5];
int last_element=arr.pop();
int length=arr.len();
print(string(last_element));
print("\n");
print(string(length));
```
The program's output is as follows:
```cpp
5
4
```

## Dictionary
A *dictionary* stores data in key-value pairs. Each key in the dictionary is unique, and it is used to access its corresponding value. Dictionaries are also known as hash maps in other programming languages.
### Declaration
In PolyC, a dict is declared by specifying the types of its keys and values. For example,
```cpp
dict<int,int> map;
```
It can also be initialized by directly listing the key-value pairs.

```cpp
dict<string,string> info = {
    "name": "Alice",
    "age": "20"
};
dict<int,int> map={};
```
`{}` is an empty map.
### Get
The `get:k->v` method is used to access the value associated with a specific key in a dictionary. It takes the key as a parameter and returns the corresponding value. Here's an example:
```cpp
string name=info.get("name");
string age=info.get("age");
print(name);
print("\n");
print(age)
```
The program's output is:
```cpp
Alice
20
```
We can also use a subscript operator to get the values:
```cpp
string name=info["name"];
string age=info["age"];
print(name);
print("\n");
print(age)
```

The two usage methods mentioned are actually the same.

### Put
The `put:k,v->void` method is used to add or update key-value pairs in a dictionary. For example:
```cpp
dict<int,int> map={};
map.put(1,1);
map.put(2,4);
map.put(3,9);
print(string(map.get(3)));
```
The program's output is:
```cpp
9
```
We can also write these statements in another style:
```cpp
dict<int,int> map={};
map[1]=1;
map[2]=4;
map[3]=9;
print(string(map[3]);
```
### Remove
The `remove:k->v` method is used to remove a key-value pair from the dictionary. For example,
```cpp
dict<int,int> map={1:1,2:4,3:9};
map.remove(1);
map.remove(2);
map.remove(3);
```
After executing these statements, the value of `map` is an empty dictionary.

### Empty
The `isEmpty:void->int` method is used to determined whether the dictionary is empty. For example,
```cpp
dict<int,int> map={};
print(string(map.isEmpty())+"\n");
map[1]=1;
print(string(map.isEmpty())+"\n");
map.remove(1);
print(string(map.isEmpty())+"\n");
```
The result of this piece of code is
```cpp
true
false
true
```

### Contain
The `containsKey:k->bool` method is used to determined whether the dictionary contains the specific key. For example,
```cpp
dict<int,int> map={};
print(string(map.containsKey(1))+"\n");
map[1]=1;
print(string(map.containsKey(1))+"\n");
map.remove(1);
print(string(map.containsKey(1))+"\n");
```
The result of this piece of code is
```cpp
false
true
false
```

## String
A *string* is a sequence of characters, which is often used to store and manipulate text or textual data. In PolyC, strings are enclosed in double quotation (`""`), not single quotes (`''`). They can contain letters, numbers, symbols, and special characters.


### Subscript
We can access different characters in a string by `[]`. For example,
```cpp
string s="123";
print(s[1]);
```
The output is:
```cpp
2
```

### Concatenation
String concatenation is represented using the `+:string,iterable string->string` operator in C++. It can be used to concatenate a string with an iterable string. Here's an example:

```cpp
string s = "123" + "345\n";
print(s);
```

The result is:

```
123456
```

