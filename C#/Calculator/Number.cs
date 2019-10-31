using System.Globalization;

namespace Calculator
{
    class Number
    {
        internal Number(string num,string character)
        {
            Num = decimal.Parse(num,new CultureInfo("en-US"));
            Character = character;
        }
        internal decimal Num { get; set; }
        internal string Character { get; set; }
    }
}
