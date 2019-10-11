using System.Globalization;

namespace Calculator
{
    class Number
    {
        internal Number(string num,string character)
        {
            Num = float.Parse(num,new CultureInfo("en-US"));
            Character = character;
        }
        internal float Num { get; set; }
        internal string Character { get; set; }
    }
}
