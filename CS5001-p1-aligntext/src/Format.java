import java.util.ArrayList;

/**
 * Format class to output each line in a specific format Format.
 * 
 * @author CS5001 Yao Tong (cs5001.yt27@st-andrews.ac.uk)
 * @version 1
 * @since 27th September, 2017
 */
public class Format {

    /**
     * Output each line in left-align format.
     * 
     * @param eachParagraph
     *            is an array used to collect the content of each line
     * @param j
     *            is the size of eachParagh array
     */
    public static void leftAlignFormat(ArrayList<String> eachParagraph, int j) {
        System.out.println(eachParagraph.get(j));
    }

    /**
     * Output each line in right-align format.
     * 
     * @param eachParagraph
     *            is an array used to collect the content of each line
     * @param j
     *            is the size of eachParagh array
     * @param lineLength
     *            is the length of each line
     */
    public static void rightAlignFormat(ArrayList<String> eachParagraph, int j, int lineLength) {
        int k = 0;
        while (k + eachParagraph.get(j).length() < lineLength) {
            System.out.print(" ");
            k++;
        }
        System.out.println(eachParagraph.get(j));
    }

    /**
     * Output each line in centre-align format.
     * 
     * @param eachParagraph
     *            is an array used to collect the content of each line
     * @param j
     *            is the size of eachParagh array
     * @param lineLength
     *            is the length of each line
     */
    public static void centreAlignFormat(ArrayList<String> eachParagraph, int j, int lineLength) {
        if ((lineLength - eachParagraph.get(j).length()) % 2 == 0) {
            int m;
            for (m = 0; m < ((lineLength - eachParagraph.get(j).length()) / 2); m++) {
                System.out.print(" ");
            }
            System.out.println(eachParagraph.get(j));
        } else {
            int n;
            if (lineLength <= eachParagraph.get(j).length()) {
                System.out.println(eachParagraph.get(j));
            } else {
                for (n = 0; n <= (lineLength - eachParagraph.get(j).length()) / 2; n++) {
                    System.out.print(" ");
                }
                System.out.println(eachParagraph.get(j));
            }
        }
    }

    /**
     * Output each line in justify format.
     * 
     * @param eachParagraph
     *            is an array used to collect the content of each line
     * @param j
     *            is the size of eachParagh array
     * @param lineLength
     *            is the length of each line
     */
    public static void justifyFormat(ArrayList<String> eachParagraph, int j, int lineLength) {
        String str = eachParagraph.get(j);
        int x = lineLength - str.length();
        int i = str.length();
        int spaceCount = 0;
        for (char a : str.toCharArray()) {     //find the number of spaces in a line
            if (a == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount == 0) {
            System.out.println(eachParagraph.get(j));    // do left-align there is only one word one line
        } else {
            while (x > 0) {                              // while there is extra spaces, insert spaces from right to left
                i = str.lastIndexOf(' ', i);
                str = str.substring(0, i) + " " + str.substring(i, str.length());
                x--;
                i--;
                if (i <= str.indexOf(' ')) {          // if there is no space to left, return to the very right
                    i = str.length();
                }
            }

            System.out.println(str);             // print justify format
        }
    }
}
