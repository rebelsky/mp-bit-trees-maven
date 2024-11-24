# mp-bit-trees-maven

A mini-project exploring bit trees (a form of binary tree) and their use in translating between alphabets, particularly in translating to and from braille.

**Authors**

* Samuel A. Rebelsky (sample solution)

**Instructions for use**

From the command line, use

    $ java -cp target/classes edu.grinnell.csc207.main.BrailleASCII CHARSET SOURCE

Where `CHARSET` is `ascii`, `braille`, or `unicode` and represents the target character set.

The source should be corresponding source to translate. For a target of `ascii`, it's a braille 0/1 string. For `braille` and `unicode` it's an ASCII string consisting of only letters and spaces.

---

This code may be found at <https://github.com/rebelsky/mp-bit-trees-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-bit-trees-maven>.
