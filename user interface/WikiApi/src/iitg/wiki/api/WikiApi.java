package iitg.wiki.api;

import java.util.ArrayList;

public class WikiApi {
	

	/**********************MetaData APIs***************************************/

	
	public String getMetaData(String input) throws Exception { 
		
		return Util.getMetaData(input);
	   
      }

	
	
	/**********************Category APIs***************************************/
	
	
		public boolean checkCategoryId(String input) throws Exception{
			return Util.boolReturner(input, "checkCategoryId");
		}
		
		
		public boolean checkCategoryTitle(String input)throws Exception{	
			return Util.boolReturner(input, "checkCategoryTitle");
		}
		
		
		public String getCategoryTitleById(String input) throws Exception{
			return Util.stringReturner(input, "getCategoryTitleById");
		}
		
		public int getCategoryIdByTitle(String input) throws Exception{
			return Util.intReturner(input, "getCategoryIdByTitle");
		}
		
		public String getCategoryURLById(String input) throws Exception {
			return Util.stringReturner(input, "getCategoryURLById");
		}
			
		public String getCategoryURLByTitle(String input) throws Exception {
			return Util.stringReturner(input, "getCategoryURLByTitle");
		}
			
			
		public int getNoOfParentsById(String input) throws Exception {
				return Util.intReturner(input, "getNoOfParentsById");
		}
		
		public int getNoOfParentsByTitle(String input) throws Exception {
			return Util.intReturner(input, "getNoOfParentsById");
		}
		
		public ArrayList<String> getListOfParentsIdById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfParentsIdById");
		}
					
		
		public ArrayList<String> getListOfParentsIdByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfParentsIdByTitle");
		}
			
		
		public ArrayList<String> getListOfParentsTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfParentsTitleByTitle");
		}
			
		public int getNoOfChildrenById(String input) throws Exception {
			return Util.intReturner(input, "getNoOfChildrenById");
		}
		
		public int getNoOfChildrenByTitle(String input) throws Exception {
			return Util.intReturner(input, "getNoOfChildrenByTitle");
		}
		
		public ArrayList<String> getListOfChildrenIdById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfChildrenIdById");
		}
		
		public ArrayList<String> getListOfChildrenIdByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfChildrenIdByTitle");
		}
		
		public ArrayList<String> getListOfChildrenTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfChildrenTitleByTitle");
		}
		
		public int getNoOfPageById(String input) throws Exception {
			return Util.intReturner(input, "getNoOfPageById");
		}
		
		public int getNoOfPageByTitle(String input) throws Exception {
			return Util.intReturner(input, "getNoOfPageByTitle");
		}
		
		public ArrayList<String> getListOfPageIdById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfPageIdById");
		}
					
		public ArrayList<String> getListOfPageIdByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfPageIdByTitle");
		}
					
		public ArrayList<String> getListOfPageTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfPageTitleByTitle");
		}
		
		
		/**********************Page APIs***************************************/
		
		
		public boolean checkPageId(String input) throws Exception {
			return Util.boolReturner(input, "checkPageId");
		}
							
		public String getPageTitleById(String input) throws Exception {
			return Util.stringReturner(input, "getPageTitleById");
		}
	
		public boolean checkPageTitle(String input)throws Exception{
			return Util.boolReturner(input, "checkPageTitle");
		}
		
		public int getPageIdByTitle(String input)throws Exception{
			return Util.intReturner(input, "getPageIdByTitle");
		}
		
		public boolean checkDisambiguationById(String input) throws Exception {
			return Util.boolReturner(input, "CheckDisambiguationById");
		}
	
		public boolean checkDisambiguationByTitle(String input)throws Exception{
			return Util.boolReturner(input, "checkDisambiguationByTitle");
		}
		
		public int getTotalCatById(String input) throws Exception {
			return Util.intReturner(input, "getTotalCatById");
		}
		
		public int getTotalCatByTitle(String input) throws Exception {
			return Util.intReturner(input, "getTotalCatByTitle");
		}
		
		public ArrayList<String> getListOfCatById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfCatById");
		}
		
		public ArrayList<String> getListOfCatByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfCatByTitle");
		}
		
		 
		public int getTotalInlinksById(String input) throws Exception {
			return Util.intReturner(input, "getTotalInlinksById");
		}
		
		public int getTotalInlinksByTitle(String input) throws Exception {
			return Util.intReturner(input, "getTotalInlinksByTitle");
		}  
		  
		public ArrayList<String> getListOfInlinksIdById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfInlinksIdById");
		}
			
		public ArrayList<String> getListOfInlinksTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfInlinksTitleByTitle");
		}
		
		public ArrayList<String> getListOfInlinkTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfInlinkTitleByTitle");
		}
		
		public int getTotalOutlinksById(String input) throws Exception {
			return Util.intReturner(input, "getTotalOutlinksById");
		}
		
		public int getTotalOutlinksByTitle(String input) throws Exception {
			return Util.intReturner(input, "getTotalOutlinksByTitle");
		}
		
		public ArrayList<String> getListOfOutlinksIdById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfOutlinksIdById");
		}
		
		public ArrayList<String> getListOfOutlinksIdByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfOutlinksIdByTitle");
		}
		
		public ArrayList<String> getListOfOutlinksTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfOutlinksTitleByTitle");
		}
		
		public String getPageURLById(String input) throws Exception {
			return Util.stringReturner(input, "getPageURLById");
		}
		
		public String getPageURLByTitle(String input) throws Exception {
			return Util.stringReturner(input, "getPageURLByTitle");
		}
		
		public String getPlainTextById(String input) throws Exception {
			return Util.stringReturner(input, "getPlainTextById");
		}
		
		public String getPlainTextByTitle(String input) throws Exception {
			return Util.stringReturner(input, "getPlainTextByTitle");
		}
		
		public String getXmlTextById(String input) throws Exception {
			return Util.stringReturner(input, "getXmlTextById");
		}
		
		public String getXmlTextByTitle(String input) throws Exception {
			return Util.stringReturner(input, "getXmlTextByTitle");
		}

		public String checkRedirectById(String input) throws Exception {
			return Util.stringReturner(input, "checkRedirectById");
		}
		
		public String checkRedirectByTitle(String input)throws Exception{
			return Util.stringReturner(input, "checkRedirectByTitle");
		}
		
		public int getTotalRedirectById(String input) throws Exception {
			return Util.intReturner(input, "getTotalRedirectById");
		}
		
		public int getTotalRedirectByTitle(String input) throws Exception {
			return Util.intReturner(input, "getTotalRedirectByTitle");
		}
		
		public ArrayList<String> getListOfRedirectTitleByTitle(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfRedirectTitleByTitle");
		}
		
		public ArrayList<String> getListOfRedirectTitleById(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfRedirectTitleById");
		}
		
		public String getRedirectTitleByTitle(String input) throws Exception {
			return Util.stringReturner(input, "getRedirectTitleByTitle");
		}
		
		public String getRedirectTitleById(String input) throws Exception {
			return Util.stringReturner(input, "getRedirectTitleById");
		}
		
		/**********************Word APIs***************************************/
		
		public String getWordById(String input) throws Exception {
			return Util.stringReturner(input, "getWordById");
		}
					
	
		public boolean checkWord(String input)throws Exception{
			return Util.boolReturner(input, "checkWord");
		}
		
		public int getIdByWord(String input)throws Exception{
			return Util.intReturner(input, "getIdByWord");
		}
		
		public int frequencyCount(String input)throws Exception{
			return Util.intReturner(input, "frequencyCount");
		}
		
		public int getNoOfPagesContainTheWord(String input)throws Exception{
			return Util.intReturner(input, "getNoOfPagesContainTheWord");
		}
		
		public ArrayList<String> getListOfPagesContainsTheWord(String input) throws Exception {
			return Util.arrayReturner(input, "getListOfPagesContainsTheWord");
		}
		
				
		public ArrayList<String> getWordsByPageId(String input) throws Exception {
			return Util.arrayReturner(input, "getWordsByPageId");		}
		
		public ArrayList<double[]> getTfidf(String input) throws Exception {
			return Util.getTfidfValue(input, "getTfidf");
		}

		
		

	public static void main(String[] args) throws Exception {
		WikiApi m=new WikiApi();
		//m.getMetaData("getMetaData");
		//m.checkCategoryTitle("AccessibleComputing");
		//m.listOfPagesContainTheWord("and");
		long startTime, endTime, execTime;
		//Object out;
		//System.out.println(execTime);
		startTime=System.nanoTime();
		//m.getTfidf("1000,12");
		endTime=System.nanoTime();
		execTime=endTime-startTime;
		System.out.println(execTime);
		
		
		startTime=System.nanoTime();
		System.out.println(m.checkCategoryTitle("Football"));
		endTime=System.nanoTime();
		execTime=endTime-startTime;
		System.out.println(execTime);
		startTime=System.nanoTime();
		System.out.println(m.checkCategoryTitle("12"));
		endTime=System.nanoTime();
		execTime=endTime-startTime;
		System.out.println(execTime);
		startTime=System.nanoTime();
		System.out.println(m.checkCategoryTitle("12"));
		endTime=System.nanoTime();
		execTime=endTime-startTime;
		System.out.println(execTime);
	}
}