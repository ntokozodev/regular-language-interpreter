package za.ac.ukzn.cs.regexfa.lexer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

/**
 * Class Lexer provides a wrapper class for the lexer class ASMLexer that
 * JFlex writes for the 8085 assembler.
 *
 * Lexer provides three methods
 *      scanner        - gets and consumes the next token, returning it as
 *                       a Token object
 *
 *      lookAhead      - gets but does not consume the next token, returning it
 *						 as a Token object
 *
 *		nextToken      - gets but does not consume the next token, returning 
 *                       only the token type
 */
 
public class  Lexer 
{
   // Instance variables	
   private RegLexer lexer;           // JFlex lexer
   @SuppressWarnings("unused")
   private String   fName;           // Name of source file
   private Token    nextToken;       // Next token
   
   /**
    *  Constructs a new Lexer object to scan source file "fName" and gets the 
    *  first token.
    *
    *  If the file cannot be opened, the caller may be able to recover from 
    *  it,so the FileNotFoundException is thrown for the caller to deal with. 
    *
    *  If a file access error occurs in getting the first token, it is 
    *  unlikely that the caller can recover from it.  The exception is thus 
    *  caught here and the program is aborted
    *  
    */
   public Lexer(String fName) throws FileNotFoundException, IOException
   {   	 
   	    this.fName = fName;
   	    
   	    //lexer = new RegLexer(new FileReader(fName));  // Open source file 
   	    lexer = new RegLexer(new StringReader(fName));
        
   	    nextToken = lexer.yylex(); // Get first token    	    
   }     
   
   /**
    *  Returns and consumes the next token, returning it as a Token object.
    *  If a file access error occurs, it is unlikely that the caller can 
    *  recover from it.  The exception is thus caught here and the 
    *  program is aborted
    */
   public Token scanner() throws IOException    
   {  
      Token t = (Token) nextToken.clone();  // Save existing next token
      nextToken = lexer.yylex();            // Get new next token
      return t;                             // Return existing next token 	  
   }	   
          
   /**
    *  Returns but does not consume the next token, returning it as a Token 
    *  object.
    */    
   public Token lookAhead()
   {
       return nextToken;
   } 
    
   /**
    *  Gets but does not consume the next token, returning the type of the 
    *  Token only. 
    */    
   public int nextToken() 
   {
     return nextToken.getType();
   } 
}	 