import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

    public class lz77 {
        public static String addChar(String str, char c)
        {
            return str.substring(0, str.length()) + c;
        }
            public static void main(String[] args) {
            String tess ="";
                try {
                    File  input = new File("data.txt");
                    Scanner myReader = new Scanner(input);
                    tess = myReader.nextLine();
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                System.out.println("Enter the String :");
                int window_size=0;
                int look=tess.length();
                String window="";String look_ahead="";
                for (int i=0;i<window_size;i++){
                    window=addChar(window,tess.charAt(i));
                }
                for (int i=window_size;i<tess.length();i++){
                    look_ahead=addChar(look_ahead,tess.charAt(i));
                }

                int start=0;String search="";boolean ok=true;
                for (int i=0;i<look_ahead.length();i++){
                    int indx=window.lastIndexOf(search+look_ahead.charAt(i));
                    if(indx!=-1){
                        search=addChar(search,look_ahead.charAt(i));
                    }
                    else{
                        //pos size next_char
                        System.out.println((window.length())-window.lastIndexOf(search)+" "+search.length()+" "+look_ahead.charAt(i));
                        if(i==look_ahead.length()-1){
                            ok=false;
                        }
                        window=window.concat(search);
                        window=addChar(window,look_ahead.charAt(i));
                        search="";
                    }
                }
               if(ok==true) {
                   System.out.println((window.length())-window.lastIndexOf(search)+" "+search.length()+" "+"NULL");
               }

            }
    }
