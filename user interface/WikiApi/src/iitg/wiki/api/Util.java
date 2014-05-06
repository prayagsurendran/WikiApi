package iitg.wiki.api;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.StringTokenizer;

import net.spy.memcached.MemcachedClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


/******************************  END OF HEADERS *******************************************/


public class Util {
			
	public static Configuration conf = new Configuration();
	public static FileSystem fileSystem = null;
	public static String homePath="/home/hduser/Wikipedia/finalDataSets/";
	
	public static Map<String, String> pathMap = new HashMap<String, String>();
		
	public static MemcachedClient memcache;
	
	public static boolean firstTime=true;
	private static ArrayList<String> resultTable;;
	
	//memcache = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	public Util() throws Exception {
		startUp();
		
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
				
			if(word.equals("Home:"))
				homePath=(String)str.nextElement();
			
		}
		br.close();
	}
	
	public static void startUp()throws Exception{
		firstTime=false;
		System.out.println("startup");
		conf.addResource(new Path("/home/hduser/hadoop/conf/core-site.xml"));
		conf.addResource(new Path("/home/hduser/hadoop/conf/hdfs-site.xml"));
		memcache = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		fileSystem = FileSystem.get(conf);
		//setProperty();
		updatePathMap();
	}
	
	
	/*************Inserting path of all folders to Hash map************/
	
	public static void updatePathMap(){
		
		//Category
		  pathMap.put("checkCategoryId", "categoryDataSets/basics/checkCategoryId/");
		  pathMap.put("getCategoryIdByTitle", "categoryDataSets/basics/getCategoryIdByTitle/");
		  pathMap.put("checkCategoryTitle", "categoryDataSets/basics/checkCategoryTitle/");
		  pathMap.put("getCategoryTitleById", "categoryDataSets/basics/getCategoryTitleById/");

		  pathMap.put("getCategoryURLById", "categoryDataSets/url/getCategoryURLById/");
		  pathMap.put("getCategoryURLByTitle", "categoryDataSets/url/getCategoryURLByTitle/");

		  pathMap.put("getListOfChildrenIdById", "categoryDataSets/children/getListOfChildrenIdById/");
		  pathMap.put("getListOfChildrenIdByTitle", "categoryDataSets/children/getListOfChildrenIdByTitle/");
		  pathMap.put("getListOfChildrenTitleByTitle", "categoryDataSets/children/getListOfChildrenTitleByTitle/");
		  pathMap.put("getNoOfChildrenById", "categoryDataSets/children/getNoOfChildrenById/");
		  pathMap.put("getNoOfChildrenByTitle", "categoryDataSets/children/getNoOfChildrenByTitle/");

		  pathMap.put("getNoOfParentsById", "categoryDataSets/parent/getNoOfParentsById/");
		  pathMap.put("getNoOfParentsByTitle", "categoryDataSets/parent/getNoOfParentsByTitle/");
		  pathMap.put("getListOfParentsIdById", "categoryDataSets/parent/getListOfParentsIdById/");
		  pathMap.put("getListOfParentsIdByTitle", "categoryDataSets/parent/getListOfParentsIdByTitle/");
		  pathMap.put("getListOfParentsTitleByTitle", "categoryDataSets/parent/getListOfParentsTitleByTitle/");

		  pathMap.put("getNoOfPageById", "categoryDataSets/page/getNoOfPageById/");
		  pathMap.put("getNoOfPageByTitle", "categoryDataSets/page/getNoOfPageByTitle/");
		  pathMap.put("getListOfPageIdById", "categoryDataSets/page/getListOfPageIdById/");
		  pathMap.put("getListOfPageIdByTitle", "categoryDataSets/page/getListOfPageIdByTitle/");
		  pathMap.put("getListOfPageTitleByTitle", "categoryDataSets/page/getListOfPageTitleByTitle/");

		  //Page
		  pathMap.put("checkPageId", "pageDataSets/basics/checkPageId/");
		  pathMap.put("checkPageTitle", "pageDataSets/basics/checkPageTitle/");
		  pathMap.put("getPageIdByTitle", "pageDataSets/basics/getPageIdByTitle/");
		  pathMap.put("getPageTitleById", "pageDataSets/basics/getPageTitleById/");	

		  pathMap.put("getTotalCatById", "pageDataSets/category/getTotalCatById/");
		  pathMap.put("getTotalCatByTitle", "pageDataSets/category/getTotalCatByTitle/");
		  pathMap.put("getListOfCatById", "pageDataSets/category/getListOfCatById/");
		  pathMap.put("getListOfCatByTitle", "pageDataSets/category/getListOfCatByTitle/");	

		  pathMap.put("checkDisambiguationByTitle", "pageDataSets/disambiguation/checkDisambiguationByTitle/");
		  pathMap.put("checkDisambiguationById", "pageDataSets/disambiguation/checkDisambiguationById/");	//not using

		  pathMap.put("checkRedirectByTitle", "pageDataSets/redirect/checkRedirectByTitle/");
		  pathMap.put("checkRedirectById", "pageDataSets/redirect/checkRedirectById/");
		  pathMap.put("getTotalRedirectById", "pageDataSets/redirect/getTotalRedirectById/");
		  pathMap.put("getTotalRedirectByTitle", "pageDataSets/redirect/getTotalRedirectByTitle/");	
		  pathMap.put("getRedirectTitleByTitle", "pageDataSets/redirect/getRedirectTitleByTitle/");
		  pathMap.put("getRedirectTitleById", "pageDataSets/redirect/getRedirectTitleById/");
		  pathMap.put("getListOfRedirectTitleById", "pageDataSets/redirect/getListOfRedirectTitleById/");
		  pathMap.put("getListOfRedirectTitleByTitle", "pageDataSets/redirect/getListOfRedirectTitleByTitle/");	

		  pathMap.put("getPageURLById", "pageDataSets/url/getPageURLById/");
		  pathMap.put("getPageURLByTitle", "pageDataSets/url/getPageURLByTitle/");	

		  pathMap.put("getTotalInlinksById", "pageDataSets/inlinks/getTotalInlinksById/");
		  pathMap.put("getTotalInlinksByTitle", "pageDataSets/inlinks/getTotalInlinksByTitle/");
		  pathMap.put("getListOfInlinksIdById", "pageDataSets/inlinks/getListOfInlinksIdById/");	
		  pathMap.put("getListOfInlinksIdByTitle", "pageDataSets/inlinks/getListOfInlinksIdByTitle/");
		  pathMap.put("getListOfInlinksTitleByTitle", "pageDataSets/inlinks/getListOfInlinksTitleByTitle/");	

		  pathMap.put("getTotalOutlinksById", "pageDataSets/outlinks/getTotalOutlinksById/");
		  pathMap.put("getTotalOutlinksByTitle", "pageDataSets/outlinks/getTotalOutlinksByTitle/");
		  pathMap.put("getListOfOutlinksIdById", "pageDataSets/outlinks/getListOfOutlinksIdById/");	
		  pathMap.put("getListOfOutlinksIdByTitle", "pageDataSets/outlinks/getListOfOutlinksIdByTitle/");
		  pathMap.put("getListOfOutlinksTitleByTitle", "pageDataSets/outlinks/getListOfOutlinksTitleByTitle/");	

		  pathMap.put("getPlainTextById", "pageDataSets/text/getPlainTextById/");	
		  pathMap.put("getPlainTextByTitle", "pageDataSets/text/getPlainTextByTitle/");
		  pathMap.put("getXmlTextById", "pageDataSets/text/getXmlTextById/");
		  pathMap.put("getXmlTextByTitle", "pageDataSets/text/getXmlTextByTitle/");

		  //Word
		  pathMap.put("getWordById", "wordSearchDataSets/getWordById/");
		  pathMap.put("checkWord", "wordSearchDataSets/checkWord/");	
		  pathMap.put("getIdByWord", "wordSearchDataSets/getIdByWord/");
		  pathMap.put("frequencyCount", "wordSearchDataSets/frequencyCount/");
		  pathMap.put("getNoOfPagesContainsTheWord", "wordSearchDataSets/getNoOfPagesContainsTheWord/");
		  pathMap.put("getListOfPagesContainsTheWord", "wordSearchDataSets/getListOfPagesContainsTheWord/");
		  pathMap.put("getWordsByPageId", "wordSearchDataSets/getWordsByPageId/");		
	}
	
/**********************MetaData APIs***************************************/

	
	public static String getMetaData(String input) throws Exception { 
		
		if(memcache.get(input)!=null){
			return  (String)memcache.get(input);
		}
		String line = null;
		String metakey;
		String metavalue;

		String metadata = Util.homePath+"metaDatasets/metaData.txt";
		Path path = new Path(metadata);

		if (!fileSystem.exists(path)) {
			System.out.println("File " + metadata + " does not exists");
		}

		FSDataInputStream in = fileSystem.open(path);
		while ((line = in.readLine()) != null) {
			StringTokenizer st1 = new StringTokenizer(line);
			while (st1.hasMoreElements()) {
				metakey = (String) st1.nextElement();
				metavalue = (String) st1.nextElement();
				memcache.set(metakey, 3600, metavalue);
			}

		}
		
		return  (String)memcache.get(input);
	   
      }
	

	/**********************For returning boolean results***************************************/
	
	
	public static Boolean boolReturner(String input, String function) throws Exception{
		//input=input.toLowerCase();
		if(firstTime)
			startUp();
			
		Boolean resultBool=false;
		try{
			if(memcache.get(input+function)!=null)					//if already in memcache
			{
				//System.out.println("File does not exists");
				return (Boolean)memcache.get(input+function);
			}
		
		int index=getFileName(function, input);
		if(index<0){ 	//If no match it returns a -ve value that indicates where the key would fit in if you were to insert it.
			index = (-(index + 1))-1;
		}
		String file=homePath + pathMap.get(function);
		Path path=new Path(file+index);
		if(!fileSystem.exists(path)){
			System.out.println(path+" dosen't exist");
			return false;
		}
		
		FSDataInputStream fin=fileSystem.open(path);
		String line = null;
		String modifiedKey;
		StringTokenizer st;

		while ((line = fin.readLine()) != null) {
			st = new StringTokenizer(line,"\t");
			while (st.hasMoreElements()) {
				modifiedKey = (String) st.nextElement() + function;
				//Boolean bool = Integer.parseInt(st.nextElement().toString()) == 0 ? false:true;
				Boolean bool = Boolean.parseBoolean(st.nextElement().toString());
				memcache.set(modifiedKey, 3600, bool);
			}
		}
		//System.out.println((Boolean)memcache.get(input+function));
		if((Boolean)memcache.get(input+function)==null)
			resultBool=false;
		else
			resultBool = (Boolean)memcache.get(input+function);
		}
		catch(NullPointerException e){
			//System.out.println("Null value found  in boolretutner");
			//e.printStackTrace();
		}
		return resultBool;
		
	}
	
	public static int intReturner(String input, String function) throws Exception{
		//input=input.toLowerCase();
		if(firstTime)
			startUp();
		if((memcache.get(input+function))!=null)					//if already in memcache
			return Integer.parseInt(memcache.get(input+function).toString());
		
		String file=homePath + pathMap.get(function);
		int index=getFileName(function, input);
		if(index<0){ 	//If no match it returns a -ve value that indicates where the key would fit in if you were to insert it.
			index = (-(index + 1))-1;
		}
		Path path=new Path(file+index);
		if(!fileSystem.exists(path)){
			System.out.println(path+" dosen't exist");
			return -1;
		}
		
		FSDataInputStream fin=fileSystem.open(path);
		String line = null;
		String modifiedKey;
		int value;
		StringTokenizer st;

		while ((line = fin.readLine()) != null) {
			st = new StringTokenizer(line);
			while (st.hasMoreElements()) {
				modifiedKey = (String) st.nextElement() + function;
				value = Integer.parseInt((st.nextElement().toString().trim()));
				memcache.set(modifiedKey, 3600, value);
			}
		}
		//System.out.println((int)memcache.get(input+function));
		
		if(memcache.get(input+function)==null)
			return -1;
		else
		{
			Object tempObj= (memcache.get(input+function));
			String tempResult = tempObj.toString();
			return Integer.parseInt(tempResult);
		}
			
			
	}
	
	
	public static String stringReturner(String input, String function) throws Exception{
		//input=input.toLowerCase();
		if(firstTime){
			startUp();
			System.out.println("startup");
		}
			
		String output;;
		if((output=(String)memcache.get(input+function))!=null)					//if already in memcache
			return output;
		
		String file=homePath + pathMap.get(function);
		int index=getFileName(function, input);
		if(index<0){ 	//If no match it returns a -ve value that indicates where the key would fit in if you were to insert it.
			index = (-(index + 1))-1;
		}
		Path path=new Path(file+index);
		if(!fileSystem.exists(path)){
			System.out.println(path+" dosen't exist");
			return "Not_Valid";
		}
		System.out.println(path);
		FSDataInputStream fin=fileSystem.open(path);
		String line = null;
		String modifiedKey, value;
		StringTokenizer st;

		while ((line = fin.readLine()) != null) {
			st = new StringTokenizer(line,"\t");
			if (st.countTokens()==2) 
			{
				modifiedKey = (String) st.nextElement() + function;
				
				value=st.nextElement().toString();
				memcache.set(modifiedKey, 3600, value);
				if(modifiedKey.equalsIgnoreCase(input+function))
					System.out.println(value);
			}
			
				
		}
		//System.out.println(memcache.get(input+function));
		//System.out.println("prayagggggggggggggggg");
		if((output=(String)memcache.get(input+function))==null)
			return "Not_Valid";
		else
			return output;
	}
	
	
	public static ArrayList<String> arrayReturner(String input, String function) throws Exception{
		//input=input.toLowerCase();
		if(firstTime)
			startUp();
		ArrayList<String> output=new ArrayList<String>();
		if((output=(ArrayList<String>)memcache.get(input+function))!=null)					//if already in memcache
			return output;
		
		String file=homePath + pathMap.get(function);
		int index=getFileName(function, input);
		if(index<0){ 	//If no match it returns a -ve value that indicates where the key would fit in if you were to insert it.
			index = (-(index + 1))-1;
		}
		Path path=new Path(file+index);
		if(!fileSystem.exists(path)){
			output=new ArrayList<String>();
			System.out.println(path+" dosen't exist");
			output.add("-1");
			return output;
		}
		
		FSDataInputStream fin=fileSystem.open(path);
		String line = null;
		String modifiedKey, valueToken, value;
		StringTokenizer st, stValue;
		ArrayList<String> valueList=new ArrayList<String>();

		while ((line = fin.readLine()) != null) {
			st = new StringTokenizer(line,"\t");
			if (st.countTokens()==2) {
				modifiedKey = (String) st.nextElement() + function;
				valueToken=st.nextElement().toString();
				
				valueList=new ArrayList<String>(Arrays.asList(valueToken.split(",")));
				memcache.set(modifiedKey, 3600, valueList);
			}
		}
		//System.out.println(memcache.get(input+function));
		
		if((output=(ArrayList<String>)memcache.get(input+function))==null){
			output=new ArrayList<String>();
			output.add("-1");
			return output;
		}
		else
			return output;
	}
	
	
	
	//Method to return vector data
	
	public static ArrayList<double[]> getTfidfValue(String input, String function) throws Exception{
		if(firstTime)
			startUp();
		ArrayList<double[]> output=new ArrayList<double[]>();
		if((output=(ArrayList<double[]>)memcache.get(input+function))!=null)		//if already in memcache
			return output;
		
		else{
			Tfidf tf=new Tfidf();
			output= tf.tfIdfCalculator(input);
		}
		memcache.set(input+function, 3600, output);
		return output;
	}
	
	
	
	/*************** Read Table.txt which contains the file name *****************/
	

	
	public static ArrayList<String> readTable(String file) throws Exception{
		String line = null;
		String word;
		ArrayList<String> table=new ArrayList<String>();
		Path path = new Path(file);

		try{
			if (!fileSystem.exists(path)) {
				System.out.println("File " + file + " does not exists");
			}
			else{
		
				FSDataInputStream fin = fileSystem.open(path);
				while ((line = fin.readLine()) != null) {
					StringTokenizer str = new StringTokenizer(line);
					if (str.hasMoreElements()) {
						word = (String) str.nextElement();
						table.add(word);
						
					}
				}		
			}
			
		}
		catch(NullPointerException e){
			System.out.println("Null value found while reading table");
		}
		if(table.isEmpty())
			table.add("-1");
	
		return table;

	}
	
	/*************** Reading the file name from table *****************/
	
	public static int getFileName(String function, String input)throws Exception{
		String file=homePath + pathMap.get(function);
		ArrayList<String> table=new ArrayList<String>();
		int index=-1;
		
		try{
			if(memcache.get(function)!=null)
				table= (ArrayList<String>)memcache.get(function);
		
		
			if(Collections.binarySearch(table, input)==-1)
			{
				table=readTable(file+"table.txt");
				memcache.set(function, 3600, table);
			}
			
			
			index=Collections.binarySearch(table, input);
			
			
			
			//System.out.println(index);
		}
		catch(NullPointerException e){
			System.out.println("Null value found  while reading file name");
			e.printStackTrace();
		}
		return index;
	}
		
	public static void main(String args[]) throws Exception{
		//Util util=new Util();
		//startUp();
		String b;
		//System.out.println(boolReturner("1039","checkCategoryTitle"));
		//System.out.println(arrayReturner("1438","getListOfChildrenTitleByTitle"));
		//System.out.println(arrayReturner("10006263","getListOfChildrenById"));
		//System.out.println(boolReturner("100BC","checkPageTitle"));
		long startTime, endTime, execTime;
		Object out;
		

		startTime=System.nanoTime();
		//int a=2+3;
		b=(String)memcache.get("1000005"+"c");
		endTime=System.nanoTime();
		execTime=endTime-startTime;
		System.out.println(execTime);
		out=null;
		System.out.print((String)out);
	}

}