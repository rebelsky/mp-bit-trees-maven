package edu.grinnell.csc207.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

/**
 *
 *
 * @author Samuel A. Rebelsky (Sample Solution)
 */
public class BrailleAsciiTables {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * Conversions from braille to ASCII.
   */
  static final String b2a = 
      "100000,A\n"
      + "110000,B\n"
      + "100100,C\n"
      + "100110,D\n"
      + "100010,E\n"
      + "110100,F\n"
      + "110110,G\n"
      + "110010,H\n"
      + "010100,I\n"
      + "010110,J\n"
      + "101000,K\n"
      + "111000,L\n"
      + "101100,M\n"
      + "101110,N\n"
      + "101010,O\n"
      + "111100,P\n"
      + "111110,Q\n"
      + "111010,R\n"
      + "011100,S\n"
      + "011110,T\n"
      + "101001,U\n"
      + "111001,V\n"
      + "101101,X\n"
      + "101111,Y\n"
      + "101011,Z\n"
      + "010111,W\n"
      + "000000, \n";

  // +---------------+-----------------------------------------------
  // | Static fields |
  // +---------------+

  /**
   * A tree that maps ASCII to Braille.
   */
  static BitTree a2bTree = null;

  /**
   *
   */
  static BitTree b2aTree = null;

  /**
   *
   */
  static BitTree b2uTree = null;

  // +-----------------------+---------------------------------------
  // | Static helper methods |
  // +-----------------------+

  /**
   * Convert a character to a bit string.
   */
  static String char2bits(char letter) {
    int val = (int) letter;
    StringBuilder builder = new StringBuilder();
    int pos = 128;
    while (pos >= 1) {
      builder.append((val > pos) ? '1' : '0');
      val = val % pos;
      pos = pos / 2;
    } // while
    return builder.toString();
  } // char2bits(char)

  /**
   * Load a tree.
   */
  static BitTree loadTree(int depth, String source) {
    BitTree tree = new BitTree(depth);
    InputStream stream = new ByteArrayInputStream(source.getBytes());
    tree.load(stream);
    try {
      stream.close();
    } catch (IOException e) {
      // We don't care if we can't close the stream.
    } // try/catch
    return tree;
  } // loadTree(int, String)

  // +----------------+----------------------------------------------
  // | Static methods |
  // +----------------+

  /**
   *
   */
  public static String toBraille(char letter) {
    return "";  // STUB
  } // toBraille(char)

  /**
   *
   */
  public static String toAscii(String bits) {
    // Make sure we've loaded the braille-to-ASCII tree.
    if (null == b2aTree) {
      b2aTree = loadTree(6, b2a);
    } // if
    return b2aTree.get(bits);
  } // toAscii(String)

  /**
   *
   */
  public static String toUnicode(String bits) {
    return "";  // STUB
  } // toUnicode(String)
} // BrailleAsciiTables
