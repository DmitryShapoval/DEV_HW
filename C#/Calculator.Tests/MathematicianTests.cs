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
        [TestCase(1.1f, 8.9f, 10)]
        [TestCase(2.3f, 4.5f, 6.8f)]
        [TestCase(0, 0, 0)]
        [TestCase(-32, 45, 13)]
        [TestCase(-67, 12, -55)]
        [TestCase(-1.234567f, -1, -2.234567f)]
        [TestCase(1.2345678f, 1, 2.2345678f)]
        [TestCase(0.0000001f, 1, 1.0000001f)]
        [TestCase(0.0000001f, 1, 1.0000001f)]
        public void ToFoldTests(float àrg1, float arg2, float exp)
        {
            Mathematician mathematician = new Mathematician();
            float result = mathematician.ToFold(àrg1, arg2);
            Assert.AreEqual(exp, result,0.000001);
        }

        [TestCase(10, 6, 4)]
        [TestCase(15, 0, 15)]
        [TestCase(0, 8, -8)]
        [TestCase(5.5f, 3, 2.5f)]
        [TestCase(4.9f, 1.1f, 3.8f)]
        [TestCase(-9, -7, -2)]//!
        [TestCase(-8.4f, 9.3f, -17.7f)]
        [TestCase(-9999, 9999, -19998)]
        [TestCase(-3232, 3234, -6466)]
        [TestCase(4.9999f, 5.3434f, -0.3435f)]
        [TestCase(2.1234567f, 1.9876543f, 0.1358024f)]
        [TestCase(21321.123f, 46.876f, 21274.247f)]
        [TestCase(7123.545f, 1.3f, 7122.245f)]
        [TestCase(-123.4f, 234342, -234465.4f)]//!
        [TestCase(234.777f, 234.777f, 0)]
        [TestCase(-465, -2, -463)]//!
        public void SubtractTests(float àrg1, float arg2, float exp)
        {
            Mathematician mathematician = new Mathematician();
            float result = mathematician.Subtract(àrg1, arg2);
            Assert.AreEqual(exp, result, 0.000001);
        }

        [TestCase(10,23,230)]
        [TestCase(0, 45, 0)]
        [TestCase(67, 0, 0)]
        [TestCase(1.1f, 8.9f, 9.79f)]
        [TestCase(2.3f, 4.5f, 10.35f)]
        [TestCase(0, 0, 0)]
        [TestCase(-35, 45, -1575)]
        [TestCase(-35, -45, 1575)]
        [TestCase(-8.9f, -2.3f, 20.47f)]
        [TestCase(0.9f, 0.3f, 0.27f)]
        [TestCase(8.9f, 0.3f, 2.67f)]
        [TestCase(-8, -0.3f, 2.4f)]
        [TestCase(8, 3, 24)]
        [TestCase(0.5f, 3, 1.5f)]
        [TestCase(0.25f, 1.356789f, 0.33919725f)]
        [TestCase(0.9545f, 1.356789f, 1.2950551005f)]
        [TestCase(2.123456789f, 1.9876543f, 4.2206980175f)]
        [TestCase(-4.951753f, 1.9876543f, -9.842373143f)]
        public void MultiplyTests(float àrg1, float arg2, float exp)
        {
            Mathematician mathematician = new Mathematician();
            float result = mathematician.Multiply(àrg1, arg2);
            Assert.AreEqual(exp, result, 0.000001);
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
            float result = mathematician.Share(àrg1, arg2);
            Assert.AreEqual(exp, result, 0.000001);
        }

        [TestCase("123" ,"123")]
        [TestCase("-456", "-456")]
        [TestCase("0", "0")]
        [TestCase("1234567891", "123456789")]
        [TestCase("-123456789", "-12345678")]
        [TestCase("-1.2345678", "-1.234567")]
        [TestCase("1.23456789", "1.2345678")]
        [TestCase("1.23456789", "1.2345678")]
        [TestCase("33.56789987", "33.567899")]
        [TestCase("-33.56789987", "-33.56789")]
        [TestCase("99999.98765", "99999.987")]
        [TestCase("-99999.98765", "-99999.98")]
        [TestCase("33.56789987", "33.567899")]
        [TestCase("-33.56789987", "-33.56789")]
        [TestCase("44444444.44444", "44444444")]
        [TestCase("-44444444.44444", "-44444444")]
        [TestCase("123456789123.3123123", "123456789")]
        [TestCase("-0.143456789f", "-0.143456")]
        public void CutDisplayTests(string àrg1, string exp)
        {
            Mathematician mathematician = new Mathematician();
            string result = mathematician.CutDisplay(àrg1);
            Assert.AreEqual(exp, result);
        }
    }
}