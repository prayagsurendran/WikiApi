package wiki.api.parser;

import java.util.ArrayList;
import java.util.HashMap;

public class WikiApi {
	
		WikiXmlParser wxParser;
	

	public WikiApi() throws Exception {
		
		wxParser= new WikiXmlParser();


	}
	
	/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  METADATA_APIS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
	
	public String getMetaData(String input) throws Exception { 
		return wxParser.stringParser(input, "getMetaData");	   
      }

		
	/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  CATEGORY_APIS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
	
	
		public boolean checkCategoryId(int input) throws Exception{
			return wxParser.booleanParser(input+"", "checkCategoryId");
		}
	
		public boolean checkCategoryTitle(String input)throws Exception{	
			return wxParser.booleanParser(input, "checkCategoryTitle");
		}
		
		public String getCategoryTitleById(int input) throws Exception{
			return wxParser.stringParser(input+"", "getCategoryTitleById");
		}
		
		public int getCategoryIdByTitle(String input) throws Exception{
			return wxParser.intParser(input, "getCategoryIdByTitle");
		}
		
		
		public String getCategoryURLById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getCategoryURLById");
		}
			
		public String getCategoryURLByTitle(String input) throws Exception {
			return wxParser.stringParser(input, "getCategoryURLByTitle");
		}
			
			
		public int getNoOfParentsById(int input) throws Exception {
				return wxParser.intParser(input+"", "getNoOfParentsById");
		}
		
		public int getNoOfParentsByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getNoOfParentsByTitle");
		}
			
		public ArrayList<String> getListOfParentsById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfParentsById");
		}
					
		
		public ArrayList<String> getListOfParentsIdByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfParentsIdByTitle");
		}
			
		
		public ArrayList<String> getListOfParentsTitleByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfParentsTitleByTitle");
		}
			
		public int getNoOfChildrenById(int input) throws Exception {
			return wxParser.intParser(input+"", "getNoOfChildrenById");
		}
		
		public int getNoOfChildrenByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getNoOfChildrenByTitle");
		}
		
		public ArrayList<String> getListOfChildrenById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfChildrenById");
		}
		
		public ArrayList<String>getListOfChildrenIdByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfChildrenIdByTitle");
		}
		
		public ArrayList<String> getListOfChildrenTitleByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfChildrenTitleByTitle");
		}
		
		
		/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  PAGE_APIS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
		
		
		public int getNoOfPageById(int input) throws Exception {
			return wxParser.intParser(input+"", "getNoOfPageById");
		}
		
		public int getNoOfPageByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getNoOfPageByTitle");
		}
		
		public ArrayList<String> getListOfPageIdById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfPageIdById");
		}
					
		public ArrayList<String>getListOfPageIdByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfPageIdByTitle");
		}
					
		public ArrayList<String> getListOfPageTitleByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfPageTitleByTitle");
		}
	
		public boolean checkPageId(int input) throws Exception {
			return wxParser.booleanParser(input+"", "checkPageId");
		}
	
		public String getPageTitleById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getPageTitleById");
		}
		
		
		public boolean checkPageTitle(String input)throws Exception{
			return wxParser.booleanParser(input, "checkPageTitle");
		}
		
		public int getPageIdByTitle(String input)throws Exception{
			return wxParser.intParser(input, "getPageIdByTitle");
		}
		
		public String checkDisambiguationById(int input) throws Exception {
			return wxParser.stringParser(input+"", "checkDisambiguationById");
		}
		
		public String checkDisambiguationByTitle(String input)throws Exception{
			return wxParser.stringParser(input, "checkDisambiguationByTitle");
		}
		
		public int getTotalCatById(int input) throws Exception {
			return wxParser.intParser(input+"", "getTotalCatById");
		}
		
		public int getTotalCatByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getTotalCatByTitle");
		}
		
		public ArrayList<String> getListOfCatById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfCatById");
		}
		
		public ArrayList<String> getListOfCatByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfCatByTitle");
		}
		
		public int getTotalInlinksById(int input) throws Exception {
			return wxParser.intParser(input+"", "getTotalInlinksById");
		}
		
		public int getTotalInlinksByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getTotalInlinksByTitle");
		}  
		  
		public ArrayList<String> getListOfInlinksIdById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfInlinksIdById");
		}
			
		public ArrayList<String> getListOfInlinksIdByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfInlinksIdByTitle");
		}
		
		public ArrayList<String> getListOfInlinkTitleByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfInlinkTitleByTitle");
		}
		
		public int getTotalOutlinksById(int input) throws Exception {
			return wxParser.intParser(input+"", "getTotalOutlinksById");
		}
		
		public int getTotalOutlinksByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getTotalOutlinksByTitle");
		}
		
		public ArrayList<String> getListOfOutlinksIdById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfOutlinksIdById");
		}
		
		public ArrayList<String> getListOfOutlinksIdByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfOutlinksIdByTitle");
		}
		
		public ArrayList<String> getListOfOutlinksTitleByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfOutlinksTitleByTitle");
		}
		
		public String getPageURLById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getPageURLById");
		}
		
		public String getPageURLByTitle(String input) throws Exception {
			return wxParser.stringParser(input, "getPageURLByTitle");
		}
		
		public String getPlainTextById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getPlainTextById");
		}
		
		public String getPlainTextByTitle(String input) throws Exception {
			return wxParser.stringParser(input, "getPlainTextByTitle");
		}
		
		public String getXmlTextById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getXmlTextById");
		}
		
		public String getXmlTextByTitle(String input) throws Exception {
			return wxParser.stringParser(input, "getXmlTextByTitle");
		}

		public String checkRedirectById(int input) throws Exception {
			return wxParser.stringParser(input+"", "checkRedirectById");
		}
		
		public String checkRedirectByTitle(String input)throws Exception{
			return wxParser.stringParser(input, "checkRedirectByTitle");
		}
		
		public int getTotalRedirectById(int input) throws Exception {
			return wxParser.intParser(input+"", "getTotalRedirectById");
		}
		
		public int getTotalRedirectByTitle(String input) throws Exception {
			return wxParser.intParser(input, "getTotalRedirectByTitle");
		}
		
		public ArrayList<String> getListOfRedirectTitleByTitle(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfRedirectTitleByTitle");
		}
		
		public ArrayList<String> getListOfRedirectTitleById(int input) throws Exception {
			return wxParser.arrayListParser(input+"", "getListOfRedirectTitleById");
		}
		
		public String getRedirectTitleByTitle(String input) throws Exception {
			return wxParser.stringParser(input+"", "getRedirectTitleByTitle");
		}
		
		public String getRedirectTitleById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getRedirectTitleById");
		}
	
	/**********************WordSearch API's***************************************/
	
		public boolean checkWord(String input)throws Exception{
			return wxParser.booleanParser(input, "checkWord");
		}
		
		public String getWordById(int input) throws Exception {
			return wxParser.stringParser(input+"", "getWordById");
		}
		
		public int getIdByWord(String input)throws Exception{
			return wxParser.intParser(input, "getIdByWord");
		}
		
		public int frequencyCount(String input)throws Exception{
			return wxParser.intParser(input, "frequencyCount");
		}
		
		public int getNoOfPagesContainsTheWord(String input)throws Exception{
			return wxParser.intParser(input, "getNoOfPagesContainsTheWord");
		}
	
		public ArrayList<String> getListOfPagesContainsTheWord(String input) throws Exception {
			return wxParser.arrayListParser(input, "getListOfPagesContainsTheWord");
		}
		
		public HashMap<String, Integer> getWordsByPageId(int input) throws Exception {
			return wxParser.hashMapParser(input+"", "getWordsByPageId");
		}
		
		
		
		public ArrayList<double[]> getTfidf(ArrayList<String> input) throws Exception {
			String newInput=input.toString().replace(" ","");
			return wxParser.doubleArrayParser(newInput.substring(1, newInput.length()-1), "getTfidf");
		}
	
		
	
	
	
	
	
	/********************************* MAIN_METHOD *************************************************************/

	public static void main(String[] args) throws Exception {
		
	
		WikiApi m=new WikiApi();
		ArrayList<String> input=new ArrayList<String>();
		input.add("12");
		input.add("1000");
		System.out.print(m.getTfidf(input));
		
		//System.out.print(m.getListOfChildrenTitleByTitle("'s-Hertogenbosch"));
		//System.out.print(wp.checkPageTitle("12")+"\n");
		//System.out.print(wp.getCategoryTitleById(1200));
		
		/*long startTime, endTime, execTime;
		//Object out;
		startTime=System.currentTimeMillis();
		m.getMetaData("GetLanguage");
		endTime=System.currentTimeMillis();
		execTime=endTime-startTime;
		System.out.println(m.getMetaData("GetLanguage"));
		System.out.println(execTime);
		startTime=System.currentTimeMillis();
		m.checkCategoryTitle("1035");
		endTime=System.currentTimeMillis();
		execTime=endTime-startTime;
		System.out.println(execTime);
		startTime=System.currentTimeMillis();
		m.checkCategoryTitle("1035");
		endTime=System.currentTimeMillis();
		execTime=endTime-startTime;
		System.out.println(execTime);
		*/
	}
}