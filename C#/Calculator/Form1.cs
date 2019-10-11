using System;
using System.Collections.Generic;
using System.Globalization;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Calculator : Form
    {
        public Calculator()
        {
            InitializeComponent();
            number = "0";
            equation = "";
            CultureInfo.CurrentCulture = new CultureInfo("en-US");
        }

        int countOfOperation = 0;

        int countOfSymbol = 0;

        private string number;

        private string equation;

        private List<Number> numbers = new List<Number>();

        private float result = 0;

        private bool solved = false;

        private bool isMinus = false;

        private Mathematician mathematician = new Mathematician();

        private void one_Click(object sender, EventArgs e)
        {
            AddNumber("1");
        }

        private void two_Click(object sender, EventArgs e)
        {
            AddNumber("2");
        }

        private void three_Click(object sender, EventArgs e)
        {
            AddNumber("3");
        }

        private void four_Click(object sender, EventArgs e)
        {
            AddNumber("4");
        }

        private void five_Click(object sender, EventArgs e)
        {
            AddNumber("5");
        }

        private void six_Click(object sender, EventArgs e)
        {
            AddNumber("6");
        }

        private void seven_Click(object sender, EventArgs e)
        {
            AddNumber("7");
        }

        private void eight_Click(object sender, EventArgs e)
        {
            AddNumber("8");
        }

        private void nine_Click(object sender, EventArgs e)
        {
            AddNumber("9");
        }

        private void zero_Click(object sender, EventArgs e)
        {
            AddNumber("0");
        }

        private void AddNumber(string num)
        {
            
            if (solved)
            {
                countOfSymbol = 0;
                number = "";
                solved = false;
            }

            if (countOfSymbol > 8)
            {
                return;
            }

            if (number == "")
            {
                UpdateResult();
            }

            if (number == "0")
            {
                number = num;
                countOfSymbol++;
            }
            else
            {
                number += num;
                countOfSymbol++;
            }
            UpdateResult();
        }

        private void dot_Click(object sender, EventArgs e)
        {
            if(number.Length == 0)
            {
                number += "0.";
                countOfSymbol += 2;
            }
            else if (number.Contains("."))
            {
                return;
            }
            else
            {
                number += ".";
                countOfSymbol++;
            }

            UpdateResult();
        }

        private void equally_Click(object sender, EventArgs e)
        {
            if (number == "")
            {
                numbers.Add(new Number("0", null));
            }
            else
            {
                numbers.Add(new Number(number, null));
            }
            Calculate();
            display.Text = mathematician.CutDisplay(result.ToString());
            //TheEquation.Text = "";
            number = mathematician.CutDisplay(result.ToString());
            equation = "";
            numbers.Clear();
            solved = true;
            isMinus = false;

        }

       

        private void UpdateEquation(string character)
        {
            if (solved)
            {
                equation += number + character;
                numbers.Add(new Number(number, character));
                solved = false;
                countOfOperation = 1;
            }
            else
            {

                if (number.Length == 0)
                {
                    if (equation.Length == 0)
                    {
                        equation += "0" + character;
                        numbers.Add(new Number("0", character));
                        GetPreviousResult();
                        countOfOperation++;
                    }
                    else
                    {
                        equation = equation.Substring(0, equation.Length - 1);
                        equation += character;
                        numbers[numbers.Count - 1].Character = character;
                    }
                }
                else
                {
                    equation += number + character;
                    numbers.Add(new Number(number, character));
                    GetPreviousResult();
                    countOfOperation++;
                }

            }

            number = "";
            countOfSymbol = 0;

            if(character == "-")
            {
                isMinus = true;
                countOfSymbol++;
            }
            else
            {
                isMinus = false;
            }
            //TheEquation.Text = equation;
        }

        private void GetPreviousResult()
        {
            if(countOfOperation > 0)
            {
                Calculate();
                display.Text = result.ToString();
            }
        }



        private void UpdateResult()
        {
            if (isMinus)
            {
                display.Text = "-" + number;
            }
            else
            {
                display.Text = number;
            }
        }

        private void Calculate()
        {
            while(numbers.Count > 2)
            {
                Number num = new Number(mathematician.ToCount(numbers[0].Num, numbers[1].Num, numbers[0].Character).ToString(), numbers[1].Character);
                numbers.RemoveAt(1);
                numbers.RemoveAt(0);
                numbers.Insert(0, num);

            }
            if(numbers.Count == 1)
            {
                result = numbers[0].Num;
            }
            else if(numbers.Count == 0)
            {
                result = 0;
            }
            else
            {
                result = mathematician.ToCount(numbers[0].Num, numbers[1].Num, numbers[0].Character);
            }
        }


        private void cancellation_Click(object sender, EventArgs e)
        {
            ClearAll();
            isMinus = false;
        }

        private void ClearAll()
        {
            numbers.Clear();
            display.Text = "0";
            number = "";
            equation = "";
            countOfSymbol = 0;
        }

        private void plus1_Click(object sender, EventArgs e)
        {
            UpdateEquation("+");
        }

        private void division1_Click(object sender, EventArgs e)
        {
            UpdateEquation("/");
        }

        private void minus1_Click(object sender, EventArgs e)
        {
            UpdateEquation("-");
        }

        private void multiplication1_Click(object sender, EventArgs e)
        {
            UpdateEquation("*");
        }
        
    }
}
