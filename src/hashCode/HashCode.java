package hashCode;

import java.io.*;
import java.util.Arrays;


/**
 * Created by jyami on 2020/02/21
 */
public class HashCode {

    public static BufferedReader br;
    public static PrintWriter outStream;

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File("src/hashCode/data/c_incunabula.txt"));
//        OutputStream out = new FileOutputStream("../output/a_example.txt");
        br = new BufferedReader(new InputStreamReader(in));
        outStream=new PrintWriter("src/hashCode/output/c_incunabula.txt");

        BasicInfo basicInfo = new BasicInfo();
        Library[] librariesArray = new Library[basicInfo.libraries];
        for(int i=0; i<basicInfo.libraries; i++){
            librariesArray[i] = new Library(i);
        }

        int lIndex = makeSolution(librariesArray, basicInfo);

        outStream.println(lIndex);
        for(int i =0 ; i<lIndex; i++){
            outStream.println(librariesArray[i].index + " " + librariesArray[i].getInputBooks());
            outStream.println(librariesArray[i].getBooksResult());
        }
        outStream.close();

    }

    private static int makeSolution(Library[] libraries, BasicInfo basicInfo){

        Arrays.sort(libraries, (o1, o2) -> Integer.compare(o2.ship, o1.ship));

        int lIndex = 0;
        int score = 0;
        int signUpday = 0;
        boolean first = true;

        for(int d = 0; d < basicInfo.days; d++){
            if(lIndex >= basicInfo.libraries){
                return lIndex;
            }
            int signup = libraries[lIndex].signup;

            if( d == signUpday + signup){
                signUpday += libraries[lIndex].signup;
                lIndex++;
                first = false;
            }else if(d < signUpday + signup && first){
                continue;
            }

            for(int l =0; l < lIndex; l++){
                for(int s =0; s < libraries[l].ship; s++){
                    int libraryBookIndex = libraries[l].getLibraryBookIndex(basicInfo);
                    if(libraryBookIndex >= libraries[l].books.length){
                        continue;
                    }
                    int libraryBook = libraries[l].books[libraryBookIndex];

                    if(libraryBookIndex < libraries[l].books.length && !basicInfo.validateBook[libraryBook]){ // false인 경우 = default
                        libraries[l].setInputBooksTrue(libraryBookIndex);
                        score += basicInfo.bookScore[libraryBookIndex];
                        basicInfo.setValidateBookTrue(libraryBookIndex);
                    }
                }
            }

        }
        return lIndex;
    }

    private static int[] makeIntegerArray(String[] stringArray){
        int[] integerArray = new int[stringArray.length];
        for(int i=0; i< integerArray.length; i++){
            integerArray[i] = Integer.parseInt(stringArray[i]);
        }
        return integerArray;
    }

    static class BasicInfo{

        public int books;
        public int libraries;
        public int days;
        public int[] bookScore;
        public boolean[] validateBook;

        public BasicInfo() throws IOException {
            String[] info = br.readLine().split(" ");
            this.books = Integer.parseInt(info[0]);
            this.libraries = Integer.parseInt(info[1]);
            this.days = Integer.parseInt(info[2]);
            this.bookScore = makeIntegerArray(br.readLine().split(" "));
            this.validateBook = new boolean[bookScore.length];
        }

        public void setValidateBookTrue(int index){
            this.validateBook[index] = true;
        }
    }

    static class Library{
        public int[] books;
        public boolean[] inputBooks;
        public int signup;
        public int ship;
        public int libraryBookIndex = 0;
        public int index;

        public Library(int index) throws IOException {
            String[] info = br.readLine().split(" ");
            int[] books = makeIntegerArray(br.readLine().split(" "));
            int signup = Integer.parseInt(info[1]);
            int ship = Integer.parseInt(info[2]);

            this.books = books;
            this.signup = signup;
            this.ship = ship;
            this.index = index;
            this.inputBooks = new boolean[books.length];
        }

        public void setInputBooksTrue(int index){
            this.inputBooks[index] = true;
        }

        public int getLibraryBookIndex(BasicInfo basicInfo){
            while(libraryBookIndex < books.length && basicInfo.validateBook[books[libraryBookIndex]]){
                libraryBookIndex++;
            }
            return libraryBookIndex;
        }

        public String getBooksResult(){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i<books.length; i++){
                if(inputBooks[i])
                    stringBuilder.append(books[i] + " ");
            }
            return stringBuilder.toString();
        }

        public int getInputBooks(){
            int count =0;
            for(int i = 0; i<inputBooks.length; i++){
                if(inputBooks[i])
                    count++;
            }
            return count;
        }


    }
}
