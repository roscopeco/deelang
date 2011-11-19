package com.roscopeco.deelang.compiler.commandline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.roscopeco.deelang.ScriptDumper;
import com.roscopeco.deelang.compiler.CompiledScript;
import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;

/**
 * Command-line compiler for Deelang. 
 * 
 * @author rosco
 */
public class Command {
  
  private static final String USAGE = "Usage: java -jar deelang-complete.jar [-d] [-o outfile] <infile>";

  static String code =
    "Quux.qix = 42\n" +
    "Quux.foo(Quux.qix, bar(3+4), beezum) {\n" +
    "  booze() or {\n" +
    "    puts(\"hello in orblock\")\n" +
    "  }\n" +
  "}\n" + 
  "3.times() { puts(\"Hello\") }\n";

  private String infile;
  private String outfile;
  private boolean dumpMode = false;
  
  public Command(String[] args) {
    processOptions(args);
  }
  
  private void printUsageAndExit() {
    System.out.println(USAGE);
    Runtime.getRuntime().exit(-1);
  }
  
  private void processOptions(String[] args) {
    Options opts = new Options(args, 1, 1);
    opts.getSet().addOption("o", Options.Separator.BLANK, Options.Multiplicity.ZERO_OR_ONE);
    opts.getSet().addOption("d", Options.Multiplicity.ZERO_OR_ONE);
    
    if (!opts.check()) {
      System.out.println("Illegal arguments: " + opts.getCheckErrors());
      printUsageAndExit();
    } else {
      if (opts.getSet().isSet("o")) {
        outfile = opts.getSet().getOption("o").getResultValue(0);
      }
      
      if (opts.getSet().isSet("d")) {
        dumpMode = true;
      }
      
      infile = opts.getSet().getData().get(0);
      
      if (infile == null) {
        printUsageAndExit();
      } else {
        if (outfile == null) {
          outfile = infile.substring(0, infile.lastIndexOf(".")) + ".dlc";
        }
      }
    }
  }
  
  public void doCompile() throws IOException, CompilerError {
    String code = new Scanner( new File(infile), "UTF-8" ).useDelimiter("\\A").next();
    CompiledScript script = Compiler.staticCompile(code);

    if (dumpMode) {
      // Dump to STDOUT
      System.out.println(ScriptDumper.dumpScript(script)); 
    } else {
      // Actually compile
      FileOutputStream out = new FileOutputStream(outfile);
      script.store(out);
      out.close();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      new Command(args).doCompile();
    } catch (IOException e) {
      System.err.println("IO Error: " + e);
      System.exit(-1);
    } catch (CompilerError e) {
      System.err.println("Compiler Error: " + e);
      System.exit(-2);
    }
    System.exit(0);
  }
}
