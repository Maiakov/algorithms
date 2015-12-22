package com.maiakov.lexicalanalyzer;

import com.maiakov.lexicalanalyzer.ast.exception.ParserException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class LexicalAnalyzerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEvaluate1() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2+2");
        System.out.println(actualResult);
        assertThat(4.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate2() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2*3");
        System.out.println(actualResult);
        assertThat(6.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate3() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2*3-6");
        System.out.println(actualResult);
        assertThat(0.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate4() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("10/5+2*3-6");
        System.out.println(actualResult);
        assertThat(2.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate5() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("1+1+1*100");
        System.out.println(actualResult);
        assertThat(102.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate6() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2*(3-6)");
        System.out.println(actualResult);
        assertThat(-6.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate7() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2*3-6");
        System.out.println(actualResult);
        assertThat(0.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate8() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2*3-(6+1)*3-2*(2+5)");
        System.out.println(actualResult);
        assertThat(-29.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate9() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("10+((10-2)/4-10)");
        System.out.println(actualResult);
        assertThat(2.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate10() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2*3-6");
        System.out.println(actualResult);
        assertThat(0.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate11() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2.5*2-5");
        System.out.println(actualResult);
        assertThat(0.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluate12() throws Exception {
        double actualResult = LexicalAnalyzer.evaluate("2.5*2-5+10.999*0");
        System.out.println(actualResult);
        assertThat(0.0, equalTo(actualResult));
    }

    @Test
    public void testEvaluateWhenExpressionIncorrect() throws Exception {
        expectedException.expect(ParserException.class);
        LexicalAnalyzer.evaluate("2*3-6+");
    }

    @Test
    public void testEvaluateWhenMissedBrace() throws Exception {
        expectedException.expect(ParserException.class);
        LexicalAnalyzer.evaluate("2*3-(6+1");
    }


}