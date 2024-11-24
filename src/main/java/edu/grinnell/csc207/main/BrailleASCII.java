package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BrailleAsciiTables;

import java.io.PrintWriter;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   *
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Requires two parameters, received " + args.length);
      return;
    } // if
    String bits;
    PrintWriter pen = new PrintWriter(System.out, true);
    switch (args[0]) {
      case "ascii":
        bits = args[1];
        if ((bits.length() % 6) != 0) {
          System.err.println("Invalid length of bit string");
        } else {
          try {
            while (!"".equals(bits)) {
              pen.print(BrailleAsciiTables.toAscii(bits.substring(0, 6)));
              pen.flush();
              bits = bits.substring(6);
            } // while
            pen.println();
          } catch (Exception e) {
            pen.println();
            System.err.println("Trouble translating because " + e.getMessage());
          } // try/catch
        } // if/else
        break;

      case "braille":
        try {
          for (int i = 0; i < args[1].length(); i++) {
            pen.print(BrailleAsciiTables.toBraille(args[1].charAt(i)));
            pen.flush();
          } // for
          pen.println();
        } catch (Exception e) {
          pen.println();
          System.err.println("Trouble translating because " + e.getMessage());
        } // try/catch
        break;

      case "unicode":
        try {
          for (int i = 0; i < args[1].length(); i++) {
            bits = BrailleAsciiTables.toBraille(args[1].charAt(i));
            String uni = BrailleAsciiTables.toUnicode(bits);
            pen.print(uni);
            pen.flush();
          } // for
          pen.println();
        } catch (Exception e) {
          pen.println();
          System.err.println("Trouble translating because " + e.getMessage());
        } // try/catch
        break;

      default:
        System.err.println("Invalid target set: " + args[0]);
        break;
    } // switch

    pen.close();
  } // main(String[]

} // class BrailleASCII
