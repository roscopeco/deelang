package com.roscopeco.deelang.compiler.commandline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.roscopeco.deelang.compiler.Compiler;
import com.roscopeco.deelang.compiler.CompilerError;
import com.roscopeco.deelang.compiler.deevm.CompiledScript;
import com.roscopeco.deelang.compiler.deevm.DVMCompilationUnit;
import com.roscopeco.deelang.parser.ParserError;
import com.roscopeco.deelang.runtime.deevm.ScriptDumper;

/**
 * Command-line compiler for Deelang. 
 * 
 * @author rosco
 * @deprectated To be removed (0.24)
 */
public class Command {
  
  private static final String USAGE = "Usage: java -jar deelang-complete.jar [-d] [-o outfile] <infile>";

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
  
  public void doCompile() throws IOException, ParserError, CompilerError {
    Scanner scanner = new Scanner( new File(infile), "UTF-8" ); 
    String code = scanner.useDelimiter("\\A").next();
    scanner.close();
    CompiledScript script = new Compiler().compile(new DVMCompilationUnit(), code).buildScript();

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
    System.err.println("NOTE: This command-line utility is DEPRECATED and will be removed in v0.24");
    try {
      new Command(args).doCompile();
    } catch (IOException e) {
      System.err.println("IO Error: " + e);
      System.exit(-1);
    } catch (ParserError e) {
      System.err.println("Parser Error: " + e);
      System.exit(-2);
    } catch (CompilerError e) {
      System.err.println("Compiler Error: " + e);
      System.exit(-3);
    }
    System.exit(0);
  }
}
