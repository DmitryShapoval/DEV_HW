using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Mathematician
    {
        public Mathematician()
        {
            CultureInfo.CurrentCulture = new CultureInfo("en-US");
        }

        public string CutDisplay(string result)
        {
            if (result.Length > 9)
            {
                //string newResult = result.Substring(0, 9);

                //if (newResult[newResult.Length - 1] == '.')
                //{
                //    newResult = newResult.Substring(0, newResult.Length - 1);
                //}

                return "error";
            }
            else
            {
                return result;
            }
        }


        internal decimal ToCount(decimal a, decimal b, string character)
        {
            decimal result;
            if (character == "+")
            {
                result = a + b;
            }
            else if (character == "-")
            {
                result = a - b;
            }
            else if (character == "*")
            {
                result = a * b;
            }
            else
            {
                try
                {
                    result = a / b;
                }
                catch (DivideByZeroException)
                {
                    return 0;
                }
            }

            

            return result;
        }

        public decimal ToFold(decimal a, decimal b)
        {
            return ToCount(a, b, "+");
        }

        public decimal Subtract(decimal a, decimal b)
        {
            return ToCount(a, b, "-");
        }

        public decimal Multiply(decimal a, decimal b)
        {
            return ToCount(a, b, "*");
        }

        public decimal Share(decimal a, decimal b)
        {
            return ToCount(a, b, "/");
        }
    }
}
