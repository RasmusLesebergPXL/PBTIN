using System;
using System.Windows;


namespace oef_4._9_frisdrankautomaat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void amountResult_Click(object sender, RoutedEventArgs e)
        {
            //Calculating the amount of coins
            int amount, cost, change, euro, fifty, twenty, ten, five, two, one;
            amount = Convert.ToInt32(amountGiven.Text);
            cost = Convert.ToInt32(itemCost.Text);
            change = amount - cost;           

            euro = change / 100;
            fifty = change % 100 / 50;
            twenty = change % 100 % 50 / 20;
            ten = change % 100 % 50 % 20 / 10;
            five = change % 100 % 50 % 20 % 10 / 5;
            two = change % 100 % 50 % 20 % 10 % 5 / 2;
            one = change % 100 % 50 % 20 % 10 % 5 % 2 / 1;

            //Inserting the amounts into the TextBlocks
            amountEuro.Text = Convert.ToString("Number of 1 euro coins is " + $"{euro}");
            amountFifty.Text = Convert.ToString("Number of 50 cent coins is " + $"{fifty}");
            amountTwenty.Text = Convert.ToString("Number of 20 cent coins is " + $"{twenty}");
            amountTen.Text = Convert.ToString("Number of 10 cent coins is " + $"{ten}");
            amountFive.Text = Convert.ToString("Number of 5 cent coins is " + $"{five}");
            amountTwo.Text = Convert.ToString("Number of 2 cent coins is " + $"{two}");
            amountOne.Text = Convert.ToString("Number of 1 cent coins is " + $"{one}");    
        }

    }
}
