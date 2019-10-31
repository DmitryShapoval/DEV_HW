using NUnit.Framework;
using Calculator;
using System.Globalization;

namespace Tests
{
    public class MathematicianTests
    {
        [SetUp]
        public void SetUp()
        {
            CultureInfo.CurrentCulture = new CultureInfo("en-US");
        }

        [TestCase(10, 23, 33)]
        [TestCase(0, 45, 45)]
        [TestCase(67, 0, 67)]
        [TestCase(1.1, 8.9, 10)]
        [TestCase(2.3, 4.5, 6.8)]
        [TestCase(0, 0, 0)]
        [TestCase(-32, 45, 13)]
        [TestCase(-67, 12, -55)]
        [TestCase(-1.234567, -1, -2.234567)]
        [TestCase(1.2345678, 1, 2.2345678)]
        [TestCase(0.0000001, 1, 1.0000001)]
        [TestCase(0.0000001, 1, 1.0000001)]
        public void ToFoldTests(decimal àrg1, decimal arg2, decimal exp)
        {
            Mathematician mathematician = new Mathematician();
            decimal result = mathematician.ToFold(àrg1, arg2);
            Assert.AreEqual(exp, result);
        }

        [TestCase(10, 6, 4)]
        [TestCase(15, 0, 15)]
        [TestCase(0, 8, -8)]
        [TestCase(5.5, 3, 2.5)]
        [TestCase(4.9, 1.1, 3.8)]
        [TestCase(-9, -7, -2)]//!
        [TestCase(-8.4, 9.3, -17.7)]
        [TestCase(-9999, 9999, -19998)]
        [TestCase(-3232, 3234, -6466)]
        [TestCase(4.9999, 5.3434, -0.3435)]
        [TestCase(2.1234567, 1.9876543, 0.1358024)]
        [TestCase(21321.123, 46.876, 21274.247)]
        [TestCase(7123.545, 1.3, 7122.245)]
        [TestCase(-123.4, 234342, -234465.4)]//!
        [TestCase(234.777, 234.777, 0)]
        [TestCase(-465, -2, -463)]//!
        public void SubtractTests(decimal àrg1, decimal arg2, decimal exp)
        {
            Mathematician mathematician = new Mathematician();
            decimal result = mathematician.Subtract(àrg1, arg2);
            Assert.AreEqual(exp, result);
        }

        [TestCase(10,23,230)]
        [TestCase(0, 45, 0)]
        [TestCase(67, 0, 0)]
        [TestCase(1.1, 8.9, 9.79)]
        [TestCase(2.3, 4.5, 10.35)]
        [TestCase(0, 0, 0)]
        [TestCase(-35, 45, -1575)]
        [TestCase(-35, -45, 1575)]
        [TestCase(-8.9, -2.3, 20.47)]
        [TestCase(0.9, 0.3, 0.27)]
        [TestCase(8.9, 0.3, 2.67)]
        [TestCase(-8, -0.3, 2.4)]
        [TestCase(8, 3, 24)]
        [TestCase(0.5, 3, 1.5)]
        [TestCase(0.25, 1.356789, 0.33919725)]
        [TestCase(0.9545, 1.356789, 1.2950551005)]
        [TestCase(-4.951753, 1.9876543, -9.8423731429879)]
        public void MultiplyTests(decimal àrg1, decimal arg2, decimal exp)
        {
            Mathematician mathematician = new Mathematician();
            decimal result = mathematician.Multiply(àrg1, arg2);
            Assert.AreEqual((float)exp, (float)result,0.000001);
        }

        [TestCase(10 ,23, 0.4347826f)]
        [TestCase(0, 45, 0)]
        [TestCase(67, 0, 0)]
        [TestCase(10, 10, 1)]
        [TestCase(333, 44, 7.5681818f)]
        [TestCase(0, 0, 0)]
        [TestCase(45.6f, 12.3f, 3.7073170f)]
        [TestCase(-8.9f, 2, -4.45f)]
        public void ShareTests(float àrg1, float arg2, float exp)
        {
            Mathematician mathematician = new Mathematician();
            decimal result = mathematician.Share((decimal)àrg1, (decimal)arg2);
            Assert.AreEqual(exp, (float)result, 0.00001);
        }

        [TestCase("123" ,"123")]
        [TestCase("-456", "-456")]
        [TestCase("0", "0")]
        [TestCase("1234567891", "error")]
        [TestCase("-123456789", "error")]
        [TestCase("-1.2345678", "error")]
        [TestCase("1.23456789", "error")]
        [TestCase("1.23456789", "error")]
        [TestCase("33.56789987", "error")]
        [TestCase("-33.56789987", "error")]
        [TestCase("99999.98765", "error")]
        [TestCase("-99999.98765", "error")]
        [TestCase("33.56789987", "error")]
        [TestCase("-33.56789987", "error")]
        [TestCase("44444444.44444", "error")]
        [TestCase("-44444444.44444", "error")]
        [TestCase("123456789123.3123123", "error")]
        [TestCase("-0.143456789", "error")]
        public void CutDisplayTests(string àrg1, string exp)
        {
            Mathematician mathematician = new Mathematician();
            string result = mathematician.CutDisplay(àrg1);
            Assert.AreEqual(exp, result);
        }
    }
}