using System;
using System.Windows;
using System.Windows.Controls;

namespace Exercise07
{
    public partial class MainWindow : Window
    {
        string _inputOne = string.Empty;
        string _inputTwo = string.Empty;
        string _operandOne = string.Empty;
        string _operandTwo = string.Empty;
        double _numberOne;
        double _numberTwo;
        string _result = string.Empty;
       
        public MainWindow()
        {
            InitializeComponent();
            displayTextBlock.Text = "0";
        }

        private void Number_Click(object sender, RoutedEventArgs e)
        {
            var clickedButton = (Button)sender;
            if (String.IsNullOrEmpty(_operandOne))
            {
                _inputOne += clickedButton.Content;
                _numberOne = Convert.ToDouble(_inputOne);
                displayTextBlock.Text = _inputOne;

            } else if (!String.IsNullOrEmpty(_operandOne))
            {
                _inputTwo += clickedButton.Content;
                _numberTwo = Convert.ToDouble(_inputTwo);
                displayTextBlock.Text = _inputTwo;
            }
        }

        private void Operator_Click(object sender, RoutedEventArgs e)
        {
            var clickedOperand = (Button)sender;
            if ((clickedOperand.Content.Equals("+") || clickedOperand.Content.Equals("-")) && String.IsNullOrEmpty(_operandOne))
            {
                _operandOne += clickedOperand.Content;

            }
            else if ((clickedOperand.Content.Equals("+") || clickedOperand.Content.Equals("-")) && !String.IsNullOrEmpty(_operandOne))
            {
                _operandTwo += clickedOperand.Content;
                if (_operandOne.Equals("+"))
                {
                    _result = Convert.ToString(_numberOne + _numberTwo);
                }
                else if (_operandOne.Equals("-"))
                {
                    _result = Convert.ToString(_numberOne - _numberTwo);
                }

                displayTextBlock.Text = Convert.ToString(_result);
                _numberOne = Convert.ToInt32(_result);
                _inputOne = _result;
                _inputTwo = string.Empty;
                _operandOne = _operandTwo;
                _operandTwo = String.Empty;
            }
            if (clickedOperand.Content.Equals("="))
            {
                if (_operandOne.Equals("+"))
                {
                    _result = Convert.ToString(_numberOne + _numberTwo);
                }
                else if (_operandOne.Equals("-"))
                {
                    _result = Convert.ToString(_numberOne - _numberTwo);
                }
                displayTextBlock.Text = Convert.ToString(_result);
                _result = string.Empty;
                _inputOne = string.Empty;
                _inputTwo = string.Empty;
                _operandOne = string.Empty;
                _operandTwo = string.Empty;
                _numberOne = 0;
                _numberTwo = 0;
            }
        }

        private void clearButton_Click(object sender, RoutedEventArgs e)
        {
            displayTextBlock.Text = "0";
            _result = string.Empty;
            _inputOne = string.Empty;
            _inputTwo = string.Empty;
            _operandOne = string.Empty;
            _operandTwo = string.Empty;
            _numberOne = 0;
            _numberTwo = 0;
        }
    }
}
