/**
*   Name
*   Date
    Class name
    Description
******************************************************************* */

public class Rational
{
   private int numerator, denominator;

   /**----------------------------------------------------------------
   *  Sets up the rational number by ensuring a nonzero denominator
   *  and making only the numerator signed.
   *///----------------------------------------------------------------
   public Rational (int numer, int Denomintaor)
   {
      if (Denomintaor == 0)
         Denomintaor = 1;

      // Make the numerator "store" the sign
      if (Denomintaor < 0)
      {
         numer = numer * -1;
         Denomintaor = Denomintaor * -1;
      }

      numerator = numer;
      denominator = Denomintaor;

      reduce();
   }

   
   
   
   /**----------------------------------------------------------------
   *  Returns the numerator of this rational number.
   */
   public int getNumerator ()
   {
      return numerator;
   }

   
   
   
   /**----------------------------------------------------------------
   *  Returns the denominator of this rational number.
   */
   public int getDenominator ()
   {
      return denominator;
   }

   
   
   
   /**----------------------------------------------------------------
   *  Returns the reciprocal of this rational number.
   */
   public Rational reciprocal ()
   {
      return new Rational (denominator, numerator);
   }

   
   
   
   /**----------------------------------------------------------------
   *  Adds this rational number to the one passed as a parameter.
   *  A common denominator is found by multiplying the individual
   *  denominators.
   */
   public Rational add (Rational op2)
   {
       int new_numerator;
       int new_denominator;
       
       if (denominator == op2.getDenominator())
       {
           new_numerator = numerator+op2.getNumerator();
           new_denominator = denominator;
       }
       else
       {
           new_denominator = denominator * op2.getDenominator();
           new_numerator = (numerator * op2.getDenominator()) + (op2.getNumerator()*denominator);
       }
       
       reduce();
       
       return new Rational(new_numerator, new_denominator);
   }

   
   
   
   
   /**----------------------------------------------------------------
   *  Subtracts the rational number passed as a parameter from this
   *  rational number.
   */
   public Rational subtract (Rational op2)
   {
       int new_numerator;
       int new_denominator;
       
       if (denominator == op2.getDenominator())
       {
           new_numerator = numerator+op2.getNumerator();
           new_denominator = denominator;
       }
       else
       {
           new_denominator = denominator * op2.getDenominator();
           new_numerator = (numerator * op2.getDenominator()) - (op2.getNumerator()*denominator);
       }
       
       reduce();
       
       return new Rational(new_numerator, new_denominator);
   }

   
   
   
   /**----------------------------------------------------------------
   *  Multiplies this rational number by the one passed as a
   *  parameter.
   */
   public Rational multiply (Rational op2)
   {
       numerator = numerator * op2.getNumerator();
       denominator = denominator * op2.getDenominator();
       
       reduce();
       
       return new Rational (numerator, denominator);
   }

   
   
   
   /**----------------------------------------------------------------
   *  Divides this rational number by the one passed as a parameter
   *  by multiplying by the reciprocal of the second rational.
   */
   public Rational divide (Rational op2)
   {
       numerator = numerator * op2.getDenominator();
       denominator = denominator * op2.getNumerator();
       
       reduce();
       
       return new Rational (numerator, denominator);
   }

   
   
   
   /**----------------------------------------------------------------
   *  Determines if this rational number is equal to the one passed
   *  as a parameter.  Assumes they are both reduced.
   */
   public boolean equals (Rational op2)
   {
       return (this.getNumerator() == op2.getNumerator() && this.getDenominator() == op2.getDenominator());
   }

   
   
   
   /**----------------------------------------------------------------
   *  Returns this rational number as a string.
   */
   public String toString ()
   {
      String result = numerator + "/" + denominator;
      
      return result;
   }

   
   
   
   /**----------------------------------------------------------------
   *  Reduces this rational number by dividing both the numerator
   *  and the denominator by their greatest common divisor.
   */
   private void reduce ()
   {
      if (numerator != 0)
      {
         int common = gcd (Math.abs(numerator), denominator);

         numerator = numerator / common;
         
         denominator = denominator / common;
      }
   }

   
   
   
   /**----------------------------------------------------------------
   *  Computes and returns the greatest common divisor of the two
   *  positive parameters. Uses Euclid's algorithm.
   */
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
         
        if (num1 > num2)
            num1 = num1 - num2;
        else
            num2 = num2 - num1;

      return num1;
   }
}
