using System;
using System.IO;

namespace RateSchedule
{
    class Program
    {
        static void Main(string[] args)
        {
            Tax taxCalc = null;
            decimal income = 0;

            Console.WriteLine("Enter your income :");
            income = ReadIncome();

            Console.WriteLine("Enter your situation : ");
            Console.WriteLine("1- Single");
            Console.WriteLine("2- Married filing Jointly or Qualifying Widow(er)");
            Console.WriteLine("3- Married Filing Separately");
            Console.WriteLine("4- Head of Household");

            taxCalc = Tax.GenerateInstanceFromSituation(ReadTaxSituation());

            Console.WriteLine(String.Format("Your estimated tax refund: {0:C}", taxCalc.Calculate(income)));

            Console.WriteLine("Press any key to continue...");
            Console.ReadKey();
        }

        private static decimal ReadIncome()
        {
            decimal result = 0.0m;

            while(!decimal.TryParse(Console.ReadLine(), out result))
            {
                Console.WriteLine("Incorrect value for income. Please try again.");
            }

            return result;
        }

        private static TaxSituation ReadTaxSituation()
        {
            int result = 1;

            while (!int.TryParse(Console.ReadLine(), out result) || result < 1 || result > 4)
            {
                Console.WriteLine("Incorrect choice. Please choose between 1 and 4.");
            }

            return (TaxSituation)result;
        }
    }
}
