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
            if (result.Length > 8)
            {
                string newResult = result.Substring(0, 9);

                if (newResult[newResult.Length - 1] == '.')
                {
                    newResult = newResult.Substring(0, newResult.Length - 1);
                }

                return newResult;
            }
            else
            {
                return result;
            }
        }


        internal float ToCount(float a, float b, string character)
        {
            float result;
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
                result = a / b;
            }


            if (float.IsNaN(result) || float.IsPositiveInfinity(result) || float.IsNegativeInfinity(result))
            {
                result = 0;
            }

            return result;
        }

        public float ToFold(float a, float b)
        {
            return ToCount(a, b, "+");
        }

        public float Subtract(float a, float b)
        {
            return ToCount(a, b, "-");
        }

        public float Multiply(float a, float b)
        {
            return ToCount(a, b, "*");
        }

        public float Share(float a, float b)
        {
            return ToCount(a, b, "/");
        }
    }
}
