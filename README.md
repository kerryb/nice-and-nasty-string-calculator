Demo code for the [String Calculator kata](https://osherove.com/tdd-kata-1).

There are two branches, `nasty` and `nice`. Both were written test-first, but the `nasty` branch omitted the refactoring
steps, and didn’t follow good practice in general.

The description of the kata (only the first five steps from the link above are included) is as follows:

----

1. Create a simple String calculator with a method signature:

```java
class StringCalculator {
    public int add(String input);
}
```

The method can take up to two numbers, separated by commas, and will return their sum.
for example `"""` or `"1"` or `"1,2"` as inputs.

(for an empty string it will return 0)

Hints:

  * Start with the simplest test case of an empty string and move to one and two numbers
  * Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
  * Remember to refactor after each passing test

----

2. Allow the `add` method to handle an unknown amount of numbers

----

3. Allow the Add method to handle new lines between numbers (instead of commas).

  * the following input is ok: `"1\n2,3"` (will equal 6)
  * the following input is NOT ok: `"1,\n"` (not need to prove it – just clarifying)

----

4. Support different delimiters

  * to change a delimiter, the beginning of the string will contain a separate line that looks like
    this: `//[delimiter]\n[numbers…]`
  * for example `"//;\n1;2"` should return three, where the default delimiter is `";"`.
  * the first line is optional. all existing scenarios should still be supported

----

5. Calling Add with a negative number will throw an exception `"Negatives not allowed: "`, and the negative that was passed.

  * if there are multiple negatives, show all of them in the exception message.