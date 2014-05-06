package iitg.wiki.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
  
  
public class Tfidf {
  
    private static List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private static  Vector<Hashtable<String, Integer>> wordCountVect=new Vector<Hashtable<String, Integer>>(); //list of all distinct words in each document with its count
    private static List<Integer> countPerPage=new ArrayList<Integer>(); //count of all terms in each document
    
    /**
     * Method to get word list of testing data by API
     */
      
    public static void getWordList(String list) throws Exception {
        ArrayList<String> pageList=new ArrayList<String>(Arrays.asList(list.split(",")));
        WikiApi wiki=new WikiApi();
        int count, value;
        ArrayList<String> arr;
        String str[];
        Hashtable<String, Integer> wordMap;
          
        for (String page : pageList) {
        	 wordMap= new Hashtable<String, Integer>();
            System.out.println(page);
            arr=new ArrayList<String>();
            arr=wiki.getWordsByPageId(page);    //Our API
            System.out.println(arr);
            count=0;
            for (int i=0;i<arr.size();i++) {
                  
                str=arr.get(i).split(" ");
                //System.out.println(str);
                if(str.length==2)
                {
                    value=Integer.parseInt(str[1]);
                    count=count+value;
                    if (!allTerms.contains(str[0])) {  //avoid duplicate entry
                        allTerms.add(str[0]);
                    }
                    wordMap.put(str[0], value);
                }
                  
            }
            //System.out.println(allTerms);
            countPerPage.add(count);
            wordCountVect.add(wordMap);
            System.out.println(allTerms.size());
        }
    }
  
  
  
      
    /**
     * Method to create termVector according to its tfidf score.
     */
    public static ArrayList<double []> tfIdfCalculator(String list) throws Exception {
          
        allTerms.clear();
        wordCountVect.clear();
        countPerPage.clear();
        getWordList(list);
          
        ArrayList<double[]> tfidfDocsVector = new ArrayList<double[]>();    //list of tfidf
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term frequency inverse document frequency
        double countWords=0, wordperDoc=0;
        int count=0,i;
          
        for (Hashtable<String, Integer> pageWordsMap : wordCountVect) {
            i=0;
            double[] tfidfvectors = new double[allTerms.size()];
                for(String word : allTerms){
                	
                    countWords=0;
                    if(pageWordsMap.containsKey(word))
                        wordperDoc=(double)pageWordsMap.get(word);
                    else
                        wordperDoc=0;
                    tf=(double)(wordperDoc/countPerPage.get(count));
                    for(Hashtable<String, Integer> pageWords : wordCountVect) {
                        if(pageWords.containsKey(word)){
                            countWords++;
                        }
                    
                    }
                    
                    double div=(double)countPerPage.size()/countWords;
                    idf=(double)Math.log(div);
                    tfidf = tf * idf;
                    tfidfvectors[i] = tfidf;
                    
                    i++;
                }
            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;
            count++;
        }
       // System.out.println(tfidfDocsVector.size());
        return tfidfDocsVector;
    }
      
      
    public double cosineSimilarity(double[] docVector1, double[] docVector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;
  
        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {
            dotProduct += docVector1[i] * docVector2[i];  //a.b
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(docVector2[i], 2); //(b^2)
        }
  
        magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)
          
          
  
        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }
} 