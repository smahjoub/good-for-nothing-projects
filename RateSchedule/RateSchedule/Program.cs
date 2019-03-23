using System;

namespace RateSchedule
{
    class Program
    {
        static void Main(string[] args)
        {
            Tax taxCalc = null;
            decimal income = 0;
            decimal tax = 0;
            int type = 0;

            Console.WriteLine("Enter your income :");
            income = decimal.Parse(Console.ReadLine());

            Console.WriteLine("Enter your situation : ");
            Console.WriteLine("1- Single");
            Console.WriteLine("2- Married filing Jointly or Qualifying Widow(er)");
            Console.WriteLine("3- Married Filing Separately");
            Console.WriteLine("4- Head of Household");
            type = int.Parse(Console.ReadLine());
            switch (type)
            {
                case 1:
                    taxCalc = new SingleTax();
                    break;
                case 2:
                    taxCalc = new MFJOrQWTax();
                    break;
                case 3:
                    taxCalc = new MFSTax();
                    break;
                case 4:
                    taxCalc = new HHTax();
                    break;
                default:
                    throw new ArgumentException();
            }


            tax = taxCalc.Calculate(income);

            Console.WriteLine(String.Format("Your estimated tax refund: {0:C}", tax));

            Console.WriteLine("Press any key to continue...");
            Console.ReadKey();
        }
    }
}
