using System;
using System.Windows;

namespace oef_10._3_Bankrekening
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string _ingave;
        private Bankrekening _bankrekening;
        public MainWindow()
        {
            InitializeComponent();

            _bankrekening = new Bankrekening();
            _ingave = inputTextBox.Text;
        }

        private void saldoButton_Click(object sender, RoutedEventArgs e)
        {
            _ingave = inputTextBox.Text;
            int number = Convert.ToInt32(_ingave[1..]);

            if (_ingave.Contains("+"))
            {
                _bankrekening.Deposit(number);
            } else
            {
                _bankrekening.Withdrawal(number);
            }
            saldoTextBlock.Text = Convert.ToString(_bankrekening.GetSaldo());
        }
    }
}
