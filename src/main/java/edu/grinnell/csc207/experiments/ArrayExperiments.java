package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.MultiDimArray;

/**
 * Experiments with multi-dimensional arrays.
 */
public class ArrayExperiments {
  public static void main(String[] args) throws Exception {
    MultiDimArray<String> stringMDA = new MultiDimArray<String>(new int[]{2, 2, 2});
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(stringMDA.toString());
    stringMDA.set("000",new int[]{0, 0, 0});
    stringMDA.set("100",new int[]{1, 0, 0});
    stringMDA.set("010",new int[]{0, 1, 0});
    stringMDA.set("110",new int[]{1, 1, 0});
    stringMDA.set("001",new int[]{0, 0, 1});
    stringMDA.set("101",new int[]{1, 0, 1});
    stringMDA.set("011",new int[]{0, 1, 1});
    stringMDA.set("111",new int[]{1, 1, 1});
    pen.println(stringMDA.toString());
    pen.close();
  } // main (String[])
} // MDAExperiments
