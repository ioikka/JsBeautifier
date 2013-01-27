package be.belgampaul.tools.javascript;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: ikka
 * Date: 27.01.13
 * Time: 8:33
 */
public class JsBeautifyTest {
  @Test
  public void testJsBeautify() throws Exception {
    //indent 2
    Assert.assertEquals(JsBeautify.jsBeautify(
        "Ext.create('Ext.Component', { html: 'Hello world!', width: 300, height: 200, padding: 20, style: { color: '#FFFFFF', backgroundColor:'#000000' }, renderTo: Ext.getBody() });", 2),
        "Ext.create('Ext.Component', {\n" +
        "  html: 'Hello world!',\n" +
        "  width: 300,\n" +
        "  height: 200,\n" +
        "  padding: 20,\n" +
        "  style: {\n" +
        "    color: '#FFFFFF',\n" +
        "    backgroundColor: '#000000'\n" +
        "  },\n" +
        "  renderTo: Ext.getBody()\n" +
        "});");

    //indent by 4, indented by 2
    Assert.assertNotSame(JsBeautify.jsBeautify(
        "Ext.create('Ext.Component', { html: 'Hello world!', width: 300, height: 200, padding: 20, style: { color: '#FFFFFF', backgroundColor:'#000000' }, renderTo: Ext.getBody() });", 4),
        "Ext.create('Ext.Component', {\n" +
            "  html: 'Hello world!',\n" +
            "  width: 300,\n" +
            "  height: 200,\n" +
            "  padding: 20,\n" +
            "  style: {\n" +
            "    color: '#FFFFFF',\n" +
            "    backgroundColor: '#000000'\n" +
            "  },\n" +
            "  renderTo: Ext.getBody()\n" +
            "});");

    //indent by 4, indented by 4
    Assert.assertEquals(JsBeautify.jsBeautify(
        "Ext.create('Ext.Component', { html: 'Hello world!', width: 300, height: 200, padding: 20, style: { color: '#FFFFFF', backgroundColor:'#000000' }, renderTo: Ext.getBody() });", 4),
        "Ext.create('Ext.Component', {\n" +
            "    html: 'Hello world!',\n" +
            "    width: 300,\n" +
            "    height: 200,\n" +
            "    padding: 20,\n" +
            "    style: {\n" +
            "        color: '#FFFFFF',\n" +
            "        backgroundColor: '#000000'\n" +
            "    },\n" +
            "    renderTo: Ext.getBody()\n" +
            "});");

  }
}
