package com.utunan.pojo.util;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Analyzer {
	/**
	 * @author  孙程程
	 * @description 分词器
	 * @date  15:42 2018/12/9
	 * @param  keyWord
	 * @return  java.util.List<java.lang.String>
	 */
	public List<String> Analyzer(String keyWord) throws Exception {
		IKAnalyzer analyzer = new IKAnalyzer();
		TokenStream ts= analyzer.tokenStream("", keyWord);
		CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
		List<String> keyWords=new ArrayList<>();
		ts.reset();
		while(ts.incrementToken()){
			keyWords.add(term.toString());
		}
		return keyWords;
	}

	public String filter(String keyWord){
		String[] symbol={"~","`","!","@","#","$","%","&","-","_","=","}",
						 ":",";","'","\"","/","\\","<",">",",","·","！","￥","……","（","）",
						 "—","【","】","、","“","”","’","‘","：","；","？","》","《","，","。","滚"};
		for(int i=0; i<symbol.length; i++){
			String s=symbol[i];
			if(keyWord.contains(s)){
				keyWord = keyWord.replaceAll(Matcher.quoteReplacement(s),"");
			}
		}
		keyWord=keyWord.replaceAll("[?]", "");
		keyWord=keyWord.replaceAll("[*]", "");
		keyWord=keyWord.replaceAll("[+]", "");
		keyWord=keyWord.replaceAll("\\^", "");
		keyWord=keyWord.replaceAll("[(]", "");
		keyWord=keyWord.replaceAll("[)]", "");
		keyWord=keyWord.replaceAll("\\[", "");
		keyWord=keyWord.replaceAll("\\]", "");
		keyWord=keyWord.replaceAll("[|]", "");
		keyWord=keyWord.replaceAll("[{]", "");
		keyWord=keyWord.replaceAll("[.]", "");
		return keyWord;
	}
}