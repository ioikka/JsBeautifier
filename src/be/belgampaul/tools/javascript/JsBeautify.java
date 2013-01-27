package be.belgampaul.tools.javascript;

/**
 * User: ikka
 * Date: 27.01.13
 * Time: 5:51
 */

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsBeautify {

  public static final String BEAUTIFY_JS = "beautify.js";

  public static String jsBeautify(String jsCode, int indentSize) {
    Context cx = Context.enter();
    Scriptable scope = cx.initStandardObjects();
    InputStream resourceAsStream = JsBeautify.class.getResourceAsStream(BEAUTIFY_JS);

    try {
      Reader reader = new InputStreamReader(resourceAsStream);
      cx.evaluateReader(scope, reader, "__beautify.js", 1, null);
      reader.close();
    } catch (IOException e) {
      throw new Error("Error reading " + "beautify.js");
    }
    scope.put("jsCode", scope, jsCode);
    return (String) cx.evaluateString(scope, "js_beautify(jsCode, {indent_size:" + indentSize + "})",
        "inline", 1, null);
  }

  public static void main(String[] args) {
    if (args.length >= 1 && (args[1].equals("help") || args[1].equals("-help") || args[1].equals("--help"))) {
      System.out.println("USAGE: javascript indentation");
      System.out.println();
      System.out.println("javascript - \"javascript string to parse\"");
      System.out.println("indentation - indentation size");
      System.out.println();
      System.out.println("example: \"function f(){return;}\" 2");
    }
    if (args.length == 2) {
      System.out.println(JsBeautify.jsBeautify(args[0], Integer.parseInt(args[1])));
    }
  }
}