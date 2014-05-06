package wiki.api.parser;
import java.io.BufferedReader;
import java.io.FileInputStream;import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class WikiXmlParser {
	
	public static String server="http://www.iitg.ernet.in/cseweb/WikiApi/";
	//public static String server="http://172.16.26.129:8080/WikiApi/services/WikiApi/";
	//public static String server="http://localhost:8080/MyWiki/services/MyWikiApi/";
	public static int waitingTime;
	public static URL url;
	public static URLConnection con;
	public static InputStream in;
	public static Boolean firstTime=true;
	
	
	public static InputStream setUrl(String input)throws Exception{
		try{
			if(firstTime)
			{
				setProperty();
				firstTime=false;
			}
			
			url = new URL(server+input);
			con = url.openConnection();
			//con.setConnectTimeout(waitingTime);
			//con.setReadTimeout(waitingTime);
			in = con.getInputStream();
		 }catch (IOException e) {
	       System.err.println("aborted parsing due to I/O: " + e.getMessage());
	         
     }
		return in;
	}
	
	/******* To set values from property.txt **********/
	public static void setProperty() throws Exception{
		FileInputStream fis=new FileInputStream("property.txt");
		BufferedReader br =new BufferedReader(new InputStreamReader(fis));
		String line;
		while((line=br.readLine())!=null)
		{
			StringTokenizer str= new StringTokenizer(line);
			String word=(String)str.nextElement();
				
			if(word.equals("Server:"))
				server=(String)str.nextElement();
			if(word.equals("WaitingTime(ms):"))
				waitingTime=Integer.parseInt((String)(str.nextElement()));
		}
		br.close();
	}
	
	
	/**************** Parse Xml Page to String ************************/  
	
	public String stringParser(String input, String function) {
		//int startTime =System.nanoTime();
		  NodeList nList=null;
		  try {
			  
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				//Document doc = dBuilder.parse(setUrl(function+"?input="+input));
				Document doc = dBuilder.parse(server+function+"?input="+input);
			 	doc.getDocumentElement().normalize();
			 
				nList = doc.getElementsByTagName("ns:return");
	 				
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  //int stopTime =System.nanoTime();
		  //System.out.println(stopTime-startTime);
		  
	    return nList.item(0).getTextContent().trim();
	}
	 
	/**************** Parse Xml Page to Long ************************/
	  
	  public int intParser(String input, String function) throws NumberFormatException {
		  //int startTime =System.nanoTime();	 
		  NodeList nList=null;
		  int id=-1;
		  try {
	
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				//Document doc = dBuilder.parse(setUrl(function+"?input="+input));
				Document doc = dBuilder.parse(server+function+"?input="+input);
			 	doc.getDocumentElement().normalize();
			 	nList = doc.getElementsByTagName("ns:return");
			 
		   }catch (Exception e) {
			e.printStackTrace();
		    }
		  
			try{
				id=Integer.parseInt(nList.item(0).getTextContent().trim());
			
		    } catch (NumberFormatException e) {
		    	
	    	  }
			//int stopTime =System.nanoTime();
			  //System.out.println(stopTime-startTime);
	    return id;
	}
	  
	  /**************** Parse Xml Page to Boolean ************************/
	  
	  public Boolean booleanParser(String input, String function) {
		  //int startTime =System.nanoTime();
		  NodeList nList=null;
		  Boolean bool=false;
		  try {
	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(server+function+"?input="+input);
		 	doc.getDocumentElement().normalize();
		 
			nList = doc.getElementsByTagName("ns:return");
			//System.out.println(nList.item(0).getTextContent().trim());
			bool=Boolean.parseBoolean(nList.item(0).getTextContent().trim());
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  //int stopTime =System.nanoTime();
		  //System.out.println(stopTime-startTime);
		  
	    return bool;
	}
	  
	  
	  /**************** Parse Xml Page to ArrayList ************************/
	  
	  
	  public ArrayList<String> arrayListParser(String input, String function) {
		  //int startTime =System.nanoTime();
		  NodeList nList=null;
		  ArrayList<String> aListResult=new ArrayList<String>();
		  try {
	
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				//Document doc = dBuilder.parse(setUrl(function+"?input="+input));
				Document doc = dBuilder.parse(server+function+"?input="+input);
			 	doc.getDocumentElement().normalize();
			 
				nList = doc.getElementsByTagName("ns:return");
			 				
				for(int i=0;i<nList.getLength();i++){
					//System.out.println(nList.item(i).getTextContent().trim());
					String temp=nList.item(i).getTextContent().trim();
					aListResult.add(temp);
			}
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  //int stopTime =System.nanoTime();
		  //System.out.println(stopTime-startTime);
	    return aListResult;
	}
	  
/**************** Parse Xml Page to Vector ************************/
	  
	  
	  public HashMap<String, Integer> hashMapParser(String input, String function) {
		  HashMap<String, Integer> result=new HashMap<String, Integer>();
		  
		  NodeList nList=null;
		  int value;
		  String str[],key;
		  //ArrayList<String> aListResult=new ArrayList<String>();
		  try {
	
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				//Document doc = dBuilder.parse(setUrl(function+"?input="+input));
				Document doc = dBuilder.parse(server+function+"?input="+input);
				//Document doc = dBuilder.parse("/home/hduser/Desktop/getWordsByPageId");
			 	doc.getDocumentElement().normalize();
			 
				nList = doc.getElementsByTagName("ns:return");
			 				
				for(int i=0;i<nList.getLength();i++){
					
					str=nList.item(i).getTextContent().trim().split(" ");
					key=str[0];
					value=Integer.parseInt(str[1]);
					result.put(key, value);
			}
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  
	    return result;
	}
	  

	  /**************** Parse Xml Page to ArrayList ************************/
	  
	  
	  public ArrayList<double[]> doubleArrayParser(String input, String function) throws NullPointerException {
		  //int startTime =System.nanoTime();
		  NodeList nList=null;
		  NodeList nListArray=null;
		  NodeList arr=null;
		  double[] doubleArray=null;
		  ArrayList<double[]> aListResult=new ArrayList<double[]>();
		  try {
	
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				//Document doc = dBuilder.parse(setUrl(function+"?input="+input));
				Document doc = dBuilder.parse(server+function+"?input="+input);
			 	doc.getDocumentElement().normalize();
			 
				nList = doc.getElementsByTagName("ns:return");
			 				
				for(int i=0;i<nList.getLength();i++){
					//arr = (NodeList)nList.item(i);
	 				nListArray=(NodeList)nList.item(i);
	 				System.out.println(nListArray.getLength());
					doubleArray=new double[nListArray.getLength()];
					for(int j=0;j<nListArray.getLength();j++){
						//System.out.println(nList.item(i).getTextContent().trim());
						if(nListArray.item(j).getTextContent().trim()!=null)
						{
							String temp=nListArray.item(j).getTextContent().trim();
							doubleArray[j]=Double.parseDouble(temp);
							//System.out.println(doubleArray[j]);
						}
				}
						
				aListResult.add(doubleArray);
				
			}
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  //int stopTime =System.nanoTime();
		  //System.out.println(stopTime-startTime);
	    return aListResult;
	}

	  
	  public static void setServer(String url){
		  server=url;
	  }
	  
	  
	  
	  
	  public static void main(String args[]) throws Exception{
		  WikiXmlParser xp=new WikiXmlParser();
//		  System.out.println(xp.arrayListParser("/home/hduser/Desktop/GetListofChildrenTitlebyTitle"));
		 // setProperty();
		  //System.out.println(server);
		  System.out.println(xp.intParser("12", "getTotalCatById"));
		  //System.out.println(waitingTime);
		  
		  
	  }
	  
	 
}


