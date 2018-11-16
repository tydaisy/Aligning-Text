import java.util.ArrayList;

/**
 * AlignText class including main method and splitString method.
 * 
 * @author CS5001 Yao Tong (cs5001.yt27@st-andrews.ac.uk)
 * @version 1
 * @since 27th September, 2017
 */
public class AlignText {

    /**
     * Check if either argument is missing or invalid. If so, output specific
     * message Split up paragraphs and output the result in different formats
     * including left-align, right-align, centre-align and justify-align.
     * 
     * @param args are the input arguments for main.
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("usage: java AlignText file_name line_length <align_mode>");
        } else {
            String[] paragraphs = FileUtil.readFile(args[0]);
            int x = 0;
            try {
                x = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {

            }

            if (x <= 0) {
                System.out.println("usage: java AlignText file_name line_length <align_mode>");
            } else {

                for (int i = 0; i < paragraphs.length; i++) {
                    // scan every paragraph
                    ArrayList<String> eachParagraph = splitString(paragraphs, x, i);

                    for (int j = 0; j < eachParagraph.size(); j++) {
                        final int y = 3;
                        if (args.length == 2) {
                            Format.rightAlignFormat(eachParagraph, j, x);
                        } else if (args.length == y) {
                            if (args[2].equals("L")) {
                                Format.leftAlignFormat(eachParagraph, j);
                            } else if (args[2].equals("R")) {
                                Format.rightAlignFormat(eachParagraph, j, x);
                            } else if (args[2].equals("C")) {
                                Format.centreAlignFormat(eachParagraph, j, x);
                            } else if (args[2].equals("J")) {
                                if (j == eachParagraph.size() - 1) {
                                    Format.leftAlignFormat(eachParagraph, j);
                                } else {
                                    Format.justifyFormat(eachParagraph, j, x);
                                }
                            } else {                                             // if the third argument is invalid, output the massage
                                System.out.println("usage: java AlignText file_name line_length <align_mode>");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Split up every paragraph into eachParagraph[] each element in
     * eachParagraph[] represent output of each line.
     * 
     * @param paragraphs is a string array which includes each paragraph of text
     * @param lineLength is the length of each line
     * @param i is the index of paragraphs
     * @return eachParagraph
     */
    public static ArrayList<String> splitString(String[] paragraphs, int lineLength, int i) {
        paragraphs[i] = paragraphs[i] + " ";          // add space in the end of each paragraph to ensure variables(lastSpc and nextSpc) can be got
        int index1 = 0;
        int index2 = lineLength;

        ArrayList<String> eachParagraph = new ArrayList<String>();   // eachParagraph is an array used to collect the content of each line
        String str = null;

        do {

            int lastSpc = paragraphs[i].lastIndexOf(' ', index2);    // lastSpc is the index of space before index2
            int nextSpc = paragraphs[i].indexOf(' ', index2);        // nextSpc is the index of space after index2

            if (index2 > paragraphs[i].length()) {
                lastSpc = paragraphs[i].length();
            }
            if (lastSpc == index1 - 1) {         //if the length of required line is smaller than or equal to one word in paragraphs, do this loop
                lastSpc = nextSpc;
            }
            str = paragraphs[i].substring(index1, lastSpc);    // str is used to store the content of each line
            index2 = lastSpc;
            eachParagraph.add(str.trim());
            index2++;
            index1 = index2;                             // the beginning of next line
            index2 += lineLength;
        } while (index1 < paragraphs[i].length());   // split up each paragraph until reach to the last word.

        return eachParagraph;
    }
}
