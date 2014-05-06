package wiki.api.parser;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tr {

	public tr() {
		// TODO Auto-generated constructor stub
	}
	
	public static void kNNClassify() throws Exception {
		
		WikiApi wiki=new WikiApi();
		ArrayList<String> pages=new ArrayList<String>();
		ArrayList<double[]> tfidfDocsVector=new ArrayList<double[]>();
		int num_pages;
		double[][] similarity;
		
		//cricket, football and tennis are different categories in Wikipedia
		pages.addAll(wiki.getListOfPageIdByTitle("cricket"));
		pages.addAll(wiki.getListOfPageIdByTitle("football"));
		pages.addAll(wiki.getListOfPageIdByTitle("tennis"));
		
		tfidfDocsVector=wiki.getTfidf(pages);
		num_pages=tfidfDocsVector.size();
		similarity=new double[num_pages][num_pages];
		
        for (int i = 1; i < num_pages; i++) {
        	for (int j = 1; j < num_pages; j++) {
        		similarity[j][j]= cosineSimilarity(tfidfDocsVector.get(i), tfidfDocsVector.get(j));
        	}
        }
	}
	
    public static double cosineSimilarity(double[] docVector1, double[] docVector2) {
        double dotProd = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;
        
        for (int i = 0; i < docVector1.length; i++)
        {
            dotProd += docVector1[i] * docVector2[i];
            magnitude1 += Math.pow(docVector1[i], 2);
            magnitude2 += Math.pow(docVector2[i], 2);
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        if (magnitude1 != 0.0 | magnitude2 != 0.0) {
            cosineSimilarity = dotProd / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }


}
