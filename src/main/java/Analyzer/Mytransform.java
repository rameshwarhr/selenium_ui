package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Mytransform implements IAnnotationTransformer
{
public void transform(ITestAnnotation anotation,Class testClass,Constructor testConstructor, Method testMethod)
{
	
	anotation.setRetryAnalyzer(RetryAnalyzer.class);
}
}
